package com.bms.blog.controller;

import com.bms.blog.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping
    public ResponseEntity<List<String>> getTag(){
       return ResponseEntity.ok(tagService.getTag());
    }

    @PostMapping
    public ResponseEntity<String> setTag(@RequestParam("tag") String tag){
        return ResponseEntity.ok(tagService.setTag(tag).getTag());
    }
}
