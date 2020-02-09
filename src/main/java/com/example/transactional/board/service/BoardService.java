package com.example.transactional.board.service;

import com.example.transactional.board.Board;
import com.example.transactional.board.infrastructure.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    //정상 커밋
    public List<Board> saveCommitTransaction() {
        boardRepository.save(new Board(1, "hello"));
        boardRepository.save(new Board(2, "hello2"));
        boardRepository.save(new Board(3, "hello3"));
        boardRepository.save(new Board(4, "hello4"));
        boardRepository.save(new Board(5, "hello5"));
        return boardRepository.findAll();
    }

    // 데이터 이상으로 트랜젝션 중간에 exception 발생
    // 전부 롤백
    public List<Board> saveRollbackTransaction() {
        boardRepository.save(new Board(1, "hello"));
        boardRepository.save(new Board(2, "hello2"));
        //컬럼사이즈 초과 exception 발생 전부 롤백
        boardRepository.save(new Board(3, "abcdefghijklmnopqrstu123456"));
        boardRepository.save(new Board(4, "hello4"));
        boardRepository.save(new Board(5, "hello5"));
        return boardRepository.findAll();
    }

    // 임의적은 Default Exception 발생
    // 롤백이 되지 않는다.
    // Checked 예외는 롤백이 되지 않는다.
    public List<Board> saveDefaultExceptionTransaction() throws Exception {
        boardRepository.save(new Board(1, "hello"));
        boardRepository.save(new Board(2, "hello2"));

        throw new Exception("Exception for rollback");

    }

    // 임의적은 Runtime Exception 발생
    // 롤백이 된다.
    // Unchecked 예외는 롤백이 된다.
    public List<Board> saveRunTimeExceptionTransaction() throws Exception{
        boardRepository.save(new Board(1, "hello"));
        boardRepository.save(new Board(2, "hello2"));

        throw new RuntimeException("Exception for rollback");
    }
}
