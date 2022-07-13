package org.board.mapper;

import org.board.domain.BoardVO;
import org.board.dto.ListDTO;

import java.util.List;

public interface GenericMapper<E,K>{

    List<BoardVO> selectList(ListDTO listDTO);

    BoardVO selectOne(K bno);

    void register(E board);

    void remove(K bno);

    void modify(E board);

    int getTotal(ListDTO listDTO);

}
