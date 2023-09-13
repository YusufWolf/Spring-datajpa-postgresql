package com.example.springdatajpapostgresql.services;

import com.example.springdatajpapostgresql.dto.PersonDto;
import com.example.springdatajpapostgresql.entity.Person;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;


@Service
public interface PersonService {

    PersonDto save(PersonDto personDto);
    void delete(long id);

    List<PersonDto> getAll();
    Page<PersonDto> getAll(Pageable pageable);
}
