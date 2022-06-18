package org.board.service;

import org.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    List<BoardDTO> selectList();

    BoardDTO selectOne(Integer bno);

    void register(BoardDTO boardDTO);

    void modify(BoardDTO boardDTO);

    void remove(Integer bno);
}
