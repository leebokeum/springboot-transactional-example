package com.example.transactional.board.controller;

import com.example.transactional.board.Board;
import com.example.transactional.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    BoardService boardService;

    @Autowired
    void setBoardService(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/commit")
    public ResponseEntity saveCommitTransaction(){
        return new ResponseEntity<>(boardService.saveCommitTransaction().size(), HttpStatus.OK);
    }

    @GetMapping("/rollback")
    public ResponseEntity saveRollbackTransaction(){
        return new ResponseEntity<>(boardService.saveRollbackTransaction().size(), HttpStatus.OK);
    }

    @GetMapping("/defaultException")
    public ResponseEntity saveDefaultExceptionTransaction() throws Exception {
        return new ResponseEntity<>(boardService.saveDefaultExceptionTransaction().size(), HttpStatus.OK);
    }

    @GetMapping("/runTimeException")
    public ResponseEntity saveRunTimeExceptionTransaction() throws Exception{
        return new ResponseEntity<>(boardService.saveRunTimeExceptionTransaction().size(), HttpStatus.OK);
    }
}
