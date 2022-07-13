package org.board.service;

import org.board.dto.BoardDTO;
import org.board.dto.ListDTO;
import org.board.dto.ListResponseDTO;

import java.util.List;

public interface BoardService {

    ListResponseDTO<BoardDTO> selectList(ListDTO listDTO);

    BoardDTO selectOne(Integer bno);

    void register(BoardDTO boardDTO);

    void modify(BoardDTO boardDTO);

    void remove(Integer bno);
}
