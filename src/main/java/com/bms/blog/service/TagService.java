package com.bms.blog.service;

import com.bms.blog.entity.Tag;
import com.bms.blog.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public List<Tag> getTag(){ return tagRepository.findAll(); }

    @Transactional
    public void setTag(String tag) { tagRepository.save(modelMapper.map(tag, Tag.class)); }
}
