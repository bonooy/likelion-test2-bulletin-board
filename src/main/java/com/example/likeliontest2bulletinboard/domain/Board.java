package com.example.likeliontest2bulletinboard.domain;

import com.example.likeliontest2bulletinboard.dto.BoardDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
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


}
