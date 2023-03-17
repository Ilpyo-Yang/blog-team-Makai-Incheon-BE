package com.bms.blog.controller;

import com.bms.blog.dto.BoardDto;
import com.bms.blog.entity.Board;
import com.bms.blog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<BoardDto> getBoard(){
       List<Board> list = boardService.getBoard();
       List<BoardDto> dto = new ArrayList<>();
       list.forEach(i -> dto.add(modelMapper.map(i, BoardDto.class)));
       return dto;
    }

    @GetMapping("/{uuid}")
    public BoardDto getBoard(@PathVariable("uuid") String uuid){
        return modelMapper.map(boardService.getBoard(uuid), BoardDto.class);
    }

    @GetMapping("/tag/{tag}")
    public List<BoardDto> getBoardByTag(@PathVariable("tag") String tag){
        List<Board> list = boardService.getBoardByTag(tag);
        List<BoardDto> dto = new ArrayList<>();
        list.forEach(i -> dto.add(modelMapper.map(i, BoardDto.class)));
        return dto;
    }

    @GetMapping("/tags")
    public String[] getBoardTags(){
        return boardService.getBoardTags();
    }

    @PostMapping
    public BoardDto setBoard(@RequestParam("board") BoardDto dto){
        return modelMapper.map(boardService.setBoard(dto), BoardDto.class);
    }

    @PostMapping("/delete/{uuid}")
    public BoardDto deleteBoard(@PathVariable("uuid") String uuid){
        return modelMapper.map(boardService.deleteBoard(uuid), BoardDto.class);
    }
}
