package org.board.service;

import lombok.RequiredArgsConstructor;
import org.board.domain.BoardVO;
import org.board.dto.BoardDTO;
import org.board.dto.ListDTO;
import org.board.dto.ListResponseDTO;
import org.board.mapper.BoardMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;
    private final ModelMapper modelMapper;

    @Override
    public ListResponseDTO<BoardDTO> selectList(ListDTO listDTO) {

        List<BoardVO> boardList = boardMapper.selectList(listDTO);

        List<BoardDTO> dtoList = boardList.stream().map(board -> modelMapper
                        .map(board, BoardDTO.class))
                .collect(Collectors.toList());

        //ListResponseDTO를 이용해서 dtoList와 Total 값 넘기기
        return ListResponseDTO.<BoardDTO>builder().dtoList(dtoList).total(boardMapper.getTotal(listDTO)).build();
    }

    @Override
    public BoardDTO selectOne(Integer bno) {
        BoardVO boardVO = boardMapper.selectOne(bno);

        BoardDTO boardDTO = modelMapper.map(boardVO, BoardDTO.class);

        return boardDTO;
    }

    @Override
    public void register(BoardDTO boardDTO) {
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        boardMapper.register(boardVO);
    }

    @Override
    public void modify(BoardDTO boardDTO) {

        boardMapper.modify(BoardVO.builder()
                        .bno(boardDTO.getBno())
                        .title(boardDTO.getTitle())
                        .content(boardDTO.getContent())
                .build());

    }

    @Override
    public void remove(Integer bno) {
        boardMapper.remove(bno);
    }
}
