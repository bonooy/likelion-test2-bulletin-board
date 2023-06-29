package com.example.likeliontest2bulletinboard.repository;

import com.example.likeliontest2bulletinboard.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAll();
}
