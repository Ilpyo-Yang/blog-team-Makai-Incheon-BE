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

    @Transactional
    public List<Board> getBoard(){ return boardRepository.findByDeleteDateIsNotNull(); }

    @Transactional
    public void setBoard(BoardDto dto) { boardRepository.save(modelMapper.map(dto, Board.class)); }

    @Transactional
    public void deleteBoard(Long uuid) {
        Board board = boardRepository.findById(uuid).get();
        board.setDeletedDate(LocalDateTime.now());
        boardRepository.save(board);
    }
}
