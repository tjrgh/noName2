package com.jojoldu.book.untitled.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.jojoldu.book.untitled.domain.posts.*;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author = author;
    }
    public Posts toEntity(){
        return Posts.builder().title(title).content(content).author(author).build();
    }

}
