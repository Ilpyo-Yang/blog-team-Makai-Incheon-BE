package com.bms.blog.service;

import com.bms.blog.entity.City;
import com.bms.blog.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    @Transactional
    public List<City> getCity(){
        return cityRepository.findAll();
    }

}
