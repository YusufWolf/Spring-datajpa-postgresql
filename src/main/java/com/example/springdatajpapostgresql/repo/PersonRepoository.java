package com.example.springdatajpapostgresql.repo;

import com.example.springdatajpapostgresql.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepoository extends JpaRepository<Person, Long> {

}
