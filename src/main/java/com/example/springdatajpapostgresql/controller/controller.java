package com.example.springdatajpapostgresql.controller;


import com.example.springdatajpapostgresql.dto.PersonDto;
import com.example.springdatajpapostgresql.entity.Person;
import com.example.springdatajpapostgresql.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController // dışarı açacağımız bir api olduğu için bu api kullandım.
@RequestMapping ("/person")
@RequiredArgsConstructor // bu defa kişi servise ihitiyaç duycağız
public class controller {
    Person person = new Person();
    private final PersonService personService;

    public ResponseEntity<PersonDto> save(@RequestBody PersonDto personDto){
        return ResponseEntity.ok(personService.save(personDto));
    }

    public ResponseEntity<List<PersonDto>> listAll(){
        return ResponseEntity.ok((personService.getAll()));
    }
    //Sunucudan kayıtları istediğim için getmapping yapmıyorum. Listhalinde
}
