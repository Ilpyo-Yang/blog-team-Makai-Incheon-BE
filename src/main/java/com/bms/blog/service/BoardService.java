package com.bms.blog.service;

import com.bms.blog.dto.BoardDto;
import com.bms.blog.entity.Board;
import com.bms.blog.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    ModelMapper modelMapper = new ModelMapper();

    public List<Board> getBoard(){
        return boardRepository.getBoard();
    }

    public Board getBoard(String uuid){
        Board board = boardRepository.findById(uuid).get();
        board.setViewCount(board.getViewCount()+1);
        return boardRepository.save(board);
    }

    public List<Board> getBoardByTag(String tag) { return boardRepository.getBoardByTag(tag);  }

    public String[] getBoardTags() {
        String[] arr = boardRepository.getBoardTags().split(",");
        arr = Arrays.stream(arr).distinct().toArray(String[]::new);
        return arr;
    }

    public Board setBoard(BoardDto dto) { return boardRepository.save(modelMapper.map(dto, Board.class)); }

    public Board deleteBoard(String uuid) {
        Board board = boardRepository.findById(uuid).get();
        board.setDeleteDate(LocalDateTime.now());
        return boardRepository.save(board);
    }
}
