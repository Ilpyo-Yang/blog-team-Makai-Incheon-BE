package com.bms.blog.controller;

import com.bms.blog.entity.Tag;
import com.bms.blog.service.TagService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;
    ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<String> getTag(){
       List<Tag> list = tagService.getTag();
       List<String> tags = new ArrayList<>();
       list.forEach(i -> tags.add(i.getTag()));
       return tags;
    }

    @PostMapping()
    public void setTag(@RequestParam("tag") String tag){
        tagService.setTag(tag);
    }

    @DeleteMapping("/delete")
    public void deleteTag(@RequestParam(value = "uuid") Long uuid){
        tagService.deleteTag(uuid);
    }
}
