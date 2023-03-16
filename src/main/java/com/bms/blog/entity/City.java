package com.bms.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CITY")
@Getter
@Setter
@NoArgsConstructor
public class City {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="COUNTRYCODE")
    private String countryCode;

    @Column(name="DISTRICT")
    private String district;

    @Column(name="POPULATION")
    private String population;

    public City(String name, String countryCode, String district, String population){
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }
}
