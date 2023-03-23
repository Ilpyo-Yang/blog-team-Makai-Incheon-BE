package com.bms.blog.controller;

import com.bms.blog.dto.BoardDto;
import com.bms.blog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public List<BoardDto> getBoard(){
       return boardService.getBoard();
    }

    @GetMapping("/{uuid}")
    public BoardDto getBoard(@PathVariable("uuid") String uuid){
        return boardService.getBoard(uuid);
    }

    @GetMapping("/tag/{tag}")
    public List<BoardDto> getBoardByTag(@PathVariable("tag") String tag){
        return boardService.getBoardByTag(tag);
    }

    @GetMapping("/tags")
    public String[] getBoardTags(){
        return boardService.getBoardTags();
    }

    @PostMapping
    public BoardDto setBoard(@RequestParam("user_uuid") String userId,
                             @RequestParam("title") String title,
                             @RequestParam("contents") String contents,
                             @RequestParam("tags") String tags){
        return boardService.setBoard(null, userId, title, contents, tags);
    }

    @PostMapping("/{uuid}")
    public BoardDto setBoard(@PathVariable("uuid") String uuid,
                             @RequestParam("user_uuid") String userId,
                             @RequestParam("title") String title,
                             @RequestParam("contents") String contents,
                             @RequestParam("tags") String tags){
        return boardService.setBoard(uuid, userId, title, contents, tags);
    }

    @PostMapping("/delete/{uuid}")
    public BoardDto deleteBoard(@PathVariable("uuid") String uuid){
        return boardService.deleteBoard(uuid);
    }
}
