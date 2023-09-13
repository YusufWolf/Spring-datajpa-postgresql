package com.example.springdatajpapostgresql.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor //tüm parametrelerin olduğu bir constructer ekliyorum.
@NoArgsConstructor // hiçbir parametrenin olmadığı bir constructer ekliyorum
@Table(name = "adress")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}) // 2 adress nesnesinin id'leri birbirine eşitse bu iki nesne aynı nesnedir.
@ToString // hazır bir toString metodu getirsin bize

public class Person {
    @Id
    @SequenceGenerator(name = "seq_person", allocationSize = 1)
    @GeneratedValue(generator = "seq_person", strategy = GenerationType.SEQUENCE)

    private long id;
    @Column(length = 225, name = "name")
    private String name;

    @Column(length = 100, name = "surname")
    private String surname;

    @OneToMany
    @JoinColumn(name = "person_adresses")
    private List<Adress> adressList;  // bir kisiye istediğim kadar adres ekeleyebiliyorum.
    //ilişkisel veritabanın bize sunduğu en önemli özelliklerden biri olan oin işlemini gerçekleştirdik.
}
