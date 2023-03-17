package com.bms.blog.service;

import com.bms.blog.entity.Tag;
import com.bms.blog.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    ModelMapper modelMapper = new ModelMapper();

    public List<String> getTag(){
        return tagRepository.getTag();
    }

    @Modifying
    public Tag setTag(String tag) {
        Tag entity = new Tag();
        entity.setTag(tag);
        return tagRepository.save(entity);
    }
}
