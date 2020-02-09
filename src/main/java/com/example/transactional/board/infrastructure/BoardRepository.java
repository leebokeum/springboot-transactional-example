package com.example.transactional.board.infrastructure;

import com.example.transactional.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
