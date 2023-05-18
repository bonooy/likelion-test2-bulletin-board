package com.example.likeliontest2bulletinboard.controller;

import com.example.likeliontest2bulletinboard.dto.BoardDto;
import com.example.likeliontest2bulletinboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    private static final String CREATE_BOARD_MESSAGE = "게시판에 글 등록 완료";

    @PostMapping("/create")
    public String create(@RequestBody BoardDto boardDto) {
        Long savedBoardId = boardService.saveBoard(boardDto);
        return CREATE_BOARD_MESSAGE;
    }
}
