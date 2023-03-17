package com.bms.blog.controller;

import com.bms.blog.entity.Tag;
import com.bms.blog.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping
    public List<String> getTag(){
       return tagService.getTag();
    }

    @PostMapping
    public Tag setTag(@RequestParam("tag") String tag){
        return tagService.setTag(tag);
    }
}
