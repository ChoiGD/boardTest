package org.board.domain;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDate;

@ToString @Builder
public class TodoVO {

    private Long bno;

    private String title;

    private LocalDate dueDate;

    private boolean finished;
}
