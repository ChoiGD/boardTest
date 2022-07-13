package org.board.dto;

import lombok.Getter;
import lombok.ToString;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@ToString
@Getter
public class ListDTO {

    private int page;

    private int size;

    private String link;

    //t tc tcw
    private String type;

    private String keyword;

    public ListDTO(){
        this.page = 1;
        this.size = 10;
    }

    public String[] getTypes(){
        if(type == null || type.trim().length() == 0){
            return new String[]{};
        }
        return type.split("");
    }

    public String getKeyword(String s){

        return keyword ==null || keyword.trim().length() ==0 ? null: keyword.trim();
    }

    public void setPage(int page) {
        this.page = page <= 0? 1:page;
    }

    public void setSize(int size) {
        this.size = size <= 10? 10: size;
    }

    public int getSkip(){
        return (this.page - 1) * size;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getLink(){
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        builder.queryParam("page",getPage())
                .queryParam("size",getSize());

        if(type != null){
            builder.queryParam("type", type);
        }

        if(keyword != null){
            try {
                String enStr = URLEncoder.encode(keyword, "UTF-8");
                builder.queryParam("keyword", enStr);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return builder.build().toString();
    }
}
