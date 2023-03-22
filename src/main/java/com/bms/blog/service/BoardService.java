package com.bms.blog.service;

import com.bms.blog.entity.Board;
import com.bms.blog.repository.BoardRepository;
import com.bms.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
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

    public Board setBoard(String uuid, String userId, String title, String contents, String tags) {
        Board board;

        if(uuid==null){
            board = new Board();
            board.setUser(userRepository.findById(userId).get());
        }
        else{
            board = boardRepository.findById(uuid).get();
        }

        board.setTitle(title);
        board.setTags(tags);

        /*String str = saveFile(userId, title, contents);
        if("IOException".equals(saveFile(userId, title, contents))){
            return new Board(); // 에러 메세지
        }
        board.setContentsPath(str);*/
        return boardRepository.save(board);
    }

    public Board deleteBoard(String uuid) {
        Board board = boardRepository.findById(uuid).get();
        board.setDeleteDate(LocalDateTime.now());
        return boardRepository.save(board);
    }

    private String saveFile(String uuid, String title, String contents) {
        try {
            String path = "C:\\blog\\uuid\\" + LocalDateTime.now() + "_" + title + ".md";
            File file = new File(path);
            FileWriter writer = new FileWriter(file);
            writer.write(contents);
            writer.close();
            return path;
        } catch (IOException e) {   // todo 에러 어떻게 할건지
            return e.toString();
        }

    }
}
