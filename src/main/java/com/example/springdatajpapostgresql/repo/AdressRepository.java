package com.example.springdatajpapostgresql.repo;

import com.example.springdatajpapostgresql.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress, Long> {

}
