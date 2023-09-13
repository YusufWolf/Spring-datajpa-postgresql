package com.example.springdatajpapostgresql.services.Impl;

import com.example.springdatajpapostgresql.dto.PersonDto;
import com.example.springdatajpapostgresql.entity.Adress;
import com.example.springdatajpapostgresql.entity.Person;
import com.example.springdatajpapostgresql.repo.AdressRepository;
import com.example.springdatajpapostgresql.repo.PersonRepoository;
import com.example.springdatajpapostgresql.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor // constructer injection ile yapacağız
@Service // dependency injectionı içerisinde bir tna instance oluştuması için service annotationını kullanıyorum.
public class ServiceImpl implements PersonService {

    private final PersonRepoository personRepoository;
    private final AdressRepository adressRepository;
    @Override
    @Transactional // save metodunun hepsini bir seferde uygular. Tablolara verileri kaydetme.
    public PersonDto save(PersonDto personDto) {
        Assert.isNull(personDto.getName(), "You must enter a name.");
        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        final Person persondb = personRepoository.save(person); //Personları person tablosuna kaydediyorum
        List<Adress> aList = new ArrayList<>();
        Adress adress = new Adress();
        personDto.getAdressList().forEach(item ->{
                adress.setAdress(item); //Ne kadar address varsa address tablosuna kaydolur.
        adress.setAdressType(Adress.AdressType.others);
        adress.setEnable(true);
        adress.setPerson(persondb);
        aList.add(adress);
                }
                );
        adressRepository.saveAll(aList);
        personDto.setId(persondb.getId());
        return personDto;


    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<PersonDto> getAll() {
        // Person person1 = new Person();
        List<Person> personList = personRepoository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();
        personList.forEach(item -> {
            PersonDto personDto = new PersonDto();
            personDto.setId(item.getId());
            personDto.setName(item.getName());
            personDto.setSurname(item.getSurname());
            // niye personList.setName(person.getName); Demiyoruz
            // personList.set(person1.setName());
            personDto.setAdressList(item.getAdressList().stream().map(Adress::getAdress).collect(Collectors.toList()));
            personDtoList.add(personDto);
        });
        return personDtoList;
    }

    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }
}
