package org.board.service;

import org.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    List<BoardDTO> selectList();

    BoardDTO selectOne(Integer bno);

    void register();

    void modify();

    void remove();
}
