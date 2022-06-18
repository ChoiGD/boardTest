package org.board.mapper;

import org.board.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

    List<BoardVO> selectList();

    BoardVO selectOne(Integer bno);

    void register(BoardVO boardVO);

    void modify(BoardVO boardVO);

    void remove(Integer bno);

}