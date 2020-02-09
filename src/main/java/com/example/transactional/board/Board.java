package com.example.transactional.board;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue
    Integer id;
    @Size(max = 10)
    String data;
    public Board(){

    }
    public Board(final Integer id, final String data) {
        this.id = id;
        this.data = data;
    }
}
