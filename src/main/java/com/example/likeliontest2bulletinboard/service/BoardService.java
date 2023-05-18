package com.example.likeliontest2bulletinboard.service;

import com.example.likeliontest2bulletinboard.domain.Board;
import com.example.likeliontest2bulletinboard.dto.BoardDto;
import com.example.likeliontest2bulletinboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long saveBoard(BoardDto boardDto) {
        Board board = Board.createBoard(boardDto);
        Board saveBoard = boardRepository.save(board);
        return saveBoard.getBoardId();
    }
}
