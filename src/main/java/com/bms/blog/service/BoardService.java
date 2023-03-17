package com.bms.blog.service;

import com.bms.blog.dto.BoardDto;
import com.bms.blog.entity.Board;
import com.bms.blog.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    ModelMapper modelMapper = new ModelMapper();

    public List<Board> getBoard(){ return boardRepository.getBoard(); }

    public Board getBoard(Long uuid){ return boardRepository.findById(uuid).get(); }

    public Board setBoard(BoardDto dto) { return boardRepository.save(modelMapper.map(dto, Board.class)); }

    public Board deleteBoard(Long uuid) {
        Board board = boardRepository.findById(uuid).get();
        board.setDeleteDate(LocalDateTime.now());
        return boardRepository.save(board);
    }
}
