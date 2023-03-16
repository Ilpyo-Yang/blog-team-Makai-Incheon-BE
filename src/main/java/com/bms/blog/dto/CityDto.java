package com.bms.blog.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CityDto {
    private Long id;
    private String name;
    private String countryCode;
    private String district;
    private String population;

    public CityDto(Long id, String name, String countryCode, String district, String population){
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }
}
