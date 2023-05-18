package com.example.likeliontest2bulletinboard.repository;

import com.example.likeliontest2bulletinboard.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
