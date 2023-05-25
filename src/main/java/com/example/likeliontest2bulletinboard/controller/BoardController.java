package com.example.likeliontest2bulletinboard.controller;

import com.example.likeliontest2bulletinboard.dto.BoardDto;
import com.example.likeliontest2bulletinboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    private static final String CREATE_BOARD_MESSAGE = "게시판에 글 등록 완료";

    private static final String UPDATE_BOARD_MESSAGE = "수정 완료";

    private static final String DELETE_BOARD_MESSAGE = "삭제 완료";

    @PostMapping("/create")
    public String create(@RequestBody BoardDto boardDto) {
        Long savedBoardId = boardService.saveBoard(boardDto);
        return CREATE_BOARD_MESSAGE;
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") Long boardId, @RequestBody BoardDto boardDto) {
        Long savedboard = boardService.updateBoard(boardId, boardDto);
        return UPDATE_BOARD_MESSAGE;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long boardId) {
        boardService.deleteBoard(boardId);
        return DELETE_BOARD_MESSAGE;
    }







}
