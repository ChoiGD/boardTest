package org.board.dto;

import lombok.Data;

@Data
public class PageMaker {

    private int page; //현재 페이지번호
    private int start,end;

    private boolean prev,next;

    private int total; //전체 데이터의 수

    public PageMaker(int page, int total) {

        this.page = page <= 0 ? 1 : page;
        this.total = total;

        //가짜 end
        int tempEnd = (int)(Math.ceil(this.page/10.0) * 10);

        this.start = tempEnd - 9;

        this.prev = this.start != 1;

        //진짜 end
        if(tempEnd * 10 >= total) {
            this.end = (int)(Math.ceil(total/10.0));
            this.next = false;
        }else {
            this.end = tempEnd;
            this.next = true;
        }

    }

}
