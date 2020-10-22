package com.jojoldu.book.untitled.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.jojoldu.book.untitled.service.*;
import com.jojoldu.book.untitled.web.dto.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PutMapping("/api/v1/posts")//put메소드이면서 해당 url인 요청을 매핑.
    public Long save(@RequestBody PostsSaveRequestDto requestDto){//@RequestBody는 요청의 body를 해당 객체로 바인딩.
        return postsService.save(requestDto);
    }

   /* @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }*/
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
