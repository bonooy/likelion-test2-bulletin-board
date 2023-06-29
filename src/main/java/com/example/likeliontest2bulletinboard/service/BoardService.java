package com.example.likeliontest2bulletinboard.service;

import com.example.likeliontest2bulletinboard.domain.Board;
import com.example.likeliontest2bulletinboard.dto.BoardDto;
import com.example.likeliontest2bulletinboard.dto.BoardForOneDto;
import com.example.likeliontest2bulletinboard.dto.BoardRespDto;
import com.example.likeliontest2bulletinboard.exception.NotFoundBoardException;
import com.example.likeliontest2bulletinboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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


    @Transactional
    public Long updateBoard(Long boardId, BoardDto boardDto) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NotFoundBoardException("없는 게시글 입니다."));
        board.setBoard(boardDto);
        return board.getBoardId();
    }


    public void deleteBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(()
                -> new NotFoundBoardException("없는 게시글 입니다."));
        boardRepository.deleteById(boardId);
    }


    public List<BoardRespDto> findAllBoard() {
        List<Board> boards = boardRepository.findAll();
        List<BoardRespDto> boardList = new ArrayList<>();
        for (Board board : boards) {
            boardList.add(board.setBoardRespDto());
        }
        return boardList;
    }

    public BoardForOneDto findOneBoard(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NotFoundBoardException("없는 게시글 입니다."));
        return board.setBoardForOneDto();
    }
}
