package com.bms.blog.service;

import com.bms.blog.entity.Tag;
import com.bms.blog.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public List<String> getTag(){
        return tagRepository.getTag();
    }

    public Tag setTag(String tag) {
        Tag entity = new Tag();
        entity.setTag(tag);
        return tagRepository.save(entity);
    }
}
