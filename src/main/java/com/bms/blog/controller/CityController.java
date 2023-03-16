package com.bms.blog.controller;

import com.bms.blog.dto.CityDto;
import com.bms.blog.entity.City;
import com.bms.blog.service.CityService;
import org.modelmapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;
    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/city")
    public List<CityDto> getCity(){
       List<City> list = cityService.getCity();
       List<CityDto> dto = new ArrayList<>();
       list.forEach(i -> dto.add(modelMapper.map(i, CityDto.class)));
       return dto;
    }
}
