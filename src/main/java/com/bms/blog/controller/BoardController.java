package com.bms.blog.controller;

import com.bms.blog.dto.BoardDto;
import com.bms.blog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<List<BoardDto>> getBoard(){
        return ResponseEntity.ok(boardService.getBoard());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BoardDto> getBoard(@PathVariable("uuid") String uuid){
        return ResponseEntity.ok(boardService.getBoard(uuid));
    }

    @GetMapping("/tag/{tag}")
    public ResponseEntity<List<BoardDto>> getBoardByTag(@PathVariable("tag") String tag){
        return ResponseEntity.ok(boardService.getBoardByTag(tag));
    }

    @GetMapping("/tags")
    public ResponseEntity<String[]> getBoardTags(){
        return ResponseEntity.ok(boardService.getBoardTags());
    }

    @PostMapping
    public ResponseEntity<BoardDto> setBoard(@RequestParam("user_uuid") String userId,
                             @RequestParam("title") String title,
                             @RequestParam("contents") String contents,
                             @RequestParam("tags") String tags){
        return ResponseEntity.ok(boardService.setBoard(null, userId, title, contents, tags));
    }

    @PostMapping("/{uuid}")
    public ResponseEntity<BoardDto> setBoard(@PathVariable("uuid") String uuid,
                             @RequestParam("user_uuid") String userId,
                             @RequestParam("title") String title,
                             @RequestParam("contents") String contents,
                             @RequestParam("tags") String tags){
        return ResponseEntity.ok(boardService.setBoard(uuid, userId, title, contents, tags));
    }

    @PostMapping("/delete/{uuid}")
    public ResponseEntity<BoardDto> deleteBoard(@PathVariable("uuid") String uuid){
        return ResponseEntity.ok(boardService.deleteBoard(uuid));
    }
}
