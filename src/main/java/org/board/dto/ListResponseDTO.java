package org.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListResponseDTO<E> {

    //리스트
    private List<E> dtoList;

    //리스트의 총 수
    private int total;

}
