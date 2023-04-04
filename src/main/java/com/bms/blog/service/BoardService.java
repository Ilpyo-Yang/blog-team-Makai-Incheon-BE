package com.bms.blog.service;

import com.bms.blog.dto.BoardDto;
import com.bms.blog.entity.Board;
import com.bms.blog.exception.ResourceNotFoundException;
import com.bms.blog.repository.BoardRepository;
import com.bms.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public List<BoardDto> getBoard(){
        List<Board> list =  boardRepository.getBoard();
        return mapper(list);
    }

    public BoardDto getBoard(String uuid){
        List<Board> list = new ArrayList<>();
        Board board = boardRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("Board", "uuid", uuid));
        board.setViewCount(board.getViewCount()+1);
        boardRepository.save(board);
        list.add(board);
        return mapper(list).get(0);
    }

    public List<BoardDto> getBoardByTag(String tag) {
        List<Board> list =  boardRepository.getBoardByTag(tag);
        return mapper(list);
    }

    public String[] getBoardTags() {
        String[] arr = boardRepository.getBoardTags().split(",");
        arr = Arrays.stream(arr).distinct().toArray(String[]::new);
        return arr;
    }

    public BoardDto setBoard(String uuid, String userId, String title, String contents, String tags) {
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

        List<Board> list = new ArrayList<>();
        boardRepository.save(board);
        list.add(board);
        return mapper(list).get(0);
    }

    public BoardDto deleteBoard(String uuid) {
        Board board = boardRepository.findById(uuid).get();
        board.setDeleteDate(LocalDateTime.now());
        List<Board> list = new ArrayList<>();
        boardRepository.save(board);
        list.add(board);
        return mapper(list).get(0);
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

    private List<BoardDto> mapper(List<Board> list){
        List<BoardDto> dtoList = new ArrayList<>();
        for(Board b: list){
            BoardDto dto = new BoardDto().builder()
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
