package com.example.likeliontest2bulletinboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardRespDto {
    private Long boardId;

    private String title;

}
