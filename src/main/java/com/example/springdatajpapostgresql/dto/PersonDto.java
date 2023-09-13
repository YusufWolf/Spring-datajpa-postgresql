package com.example.springdatajpapostgresql.dto;

import com.example.springdatajpapostgresql.entity.Adress;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class PersonDto {
    private long id;
    private String name;
    private String surname;
    private List<String> adressList;  // bir //addressleri frontend'den bir String listesi olarak isyiorum
}
