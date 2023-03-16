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

    @PostMapping("/{uuid}")
    public void setBoard(@PathVariable(value = "uuid", required = false) Long uuid, @RequestParam("board") BoardDto dto){
        boardService.setBoard(dto);
    }

    @PostMapping("/delete")
    public void deleteBoard(@RequestParam(value = "uuid") Long uuid){
        boardService.deleteBoard(uuid);
    }
}
