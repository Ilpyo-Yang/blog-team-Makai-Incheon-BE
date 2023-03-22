package com.bms.blog.controller;

import com.bms.blog.dto.BoardDto;
import com.bms.blog.entity.Board;
import com.bms.blog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public List<BoardDto> getBoard(){
       List<Board> list = boardService.getBoard();
       return mapper(list);
    }

    @GetMapping("/{uuid}")
    public BoardDto getBoard(@PathVariable("uuid") String uuid){
        List<Board> list = new ArrayList<>();
        list.add(boardService.getBoard(uuid));
        return mapper(list).get(0);
    }

    @GetMapping("/tag/{tag}")
    public List<BoardDto> getBoardByTag(@PathVariable("tag") String tag){
        List<Board> list = boardService.getBoardByTag(tag);
        return mapper(list);
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
        List<Board> list = new ArrayList<>();
        list.add(boardService.setBoard(null, userId, title, contents, tags));
        return mapper(list).get(0);
    }

    @PostMapping("/{uuid}")
    public BoardDto setBoard(@PathVariable("uuid") String uuid,
                             @RequestParam("user_uuid") String userId,
                             @RequestParam("title") String title,
                             @RequestParam("contents") String contents,
                             @RequestParam("tags") String tags){
        List<Board> list = new ArrayList<>();
        list.add(boardService.setBoard(uuid, userId, title, contents, tags));
        return mapper(list).get(0);
    }

    @PostMapping("/delete/{uuid}")
    public BoardDto deleteBoard(@PathVariable("uuid") String uuid){
        List<Board> list = new ArrayList<>();
        list.add(boardService.deleteBoard(uuid));
        return mapper(list).get(0);
    }

    private List<BoardDto> mapper(List<Board> list){
        List<BoardDto> dtoList = new ArrayList<>();
        for(Board b: list){
            BoardDto dto = new BoardDto().builder()
                                    .uuid(b.getUuid())
                                    .userId(b.getUser().getUuid())
                                    .userNickname(b.getUser().getNickname())
                                    .title(b.getTitle())
                                    .contentsPath(b.getContentsPath())
                                    .tags(b.getTags())
                                    .viewCount(b.getViewCount())
                                    .createdDate(b.getCreatedDate())
                                    .editDate(b.getEditDate())
                                    .deleteDate(b.getDeleteDate())
                                    .build();
            dtoList.add(dto);
        }
        return dtoList;
    }
}
