package com.example.springdatajpapostgresql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor //tüm parametrelerin olduğu bir constructer ekliyorum.
@NoArgsConstructor // hiçbir parametrenin olmadığı bir constructer ekliyorum
@Table(name = "adress")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}) // 2 adress nesnesinin id'leri birbirine eşitse bu iki nesne aynı nesnedir.
@ToString // hazır bir toString metodu getirsin bize

public class Adress implements Serializable { //jpa entityleri Serializable interface'indne gelmektedir.
    @Id
    @SequenceGenerator(name = "seq_adress", allocationSize = 1)
    @GeneratedValue(generator = "seq_adress", strategy = GenerationType.SEQUENCE)

    private long id;
    @Column(length = 225, name = "adress")
    private String adress;

    @Enumerated(EnumType.STRING)
    private AdressType adressType;
    @Column(name = "enable")
    private Boolean enable;

    @ManyToOne
    @JoinColumn(name = "person_addresses")
    private Person person;


    public enum AdressType {
        home_adress,
        work_adress,
        others

    }

}
