package com.example.likeliontest2bulletinboard.domain;

import com.example.likeliontest2bulletinboard.dto.BoardDto;
import com.example.likeliontest2bulletinboard.dto.BoardForOneDto;
import com.example.likeliontest2bulletinboard.dto.BoardRespDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false)
    private String title;

    private String content;

    @Builder
    public Board(String title, String content){
        this.title = title;
        this.content = content;
    }

    public static Board createBoard(BoardDto boardDto) {
        return Board.builder()
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .build();
    }


    public void setBoard(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();

    }

    public BoardRespDto setBoardRespDto() {
        return BoardRespDto.builder()
                .boardId(this.boardId)
                .title(this.title)
                .build();
    }

    public BoardForOneDto setBoardForOneDto() {
        return BoardForOneDto.builder()
                .boardId(this.boardId)
                .title(this.title)
                .content(this.content)
                .build();
    }


}
