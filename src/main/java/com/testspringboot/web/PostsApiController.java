package com.testspringboot.web;

import com.testspringboot.service.PostsService;
import com.testspringboot.web.dto.PostsResponseDto;
import com.testspringboot.web.dto.PostsSaveRequestDto;
import com.testspringboot.web.dto.PostsUpdateRequestDto;
import javafx.geometry.Pos;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //RequestBody가 param으로 있으면 어떻게 가져오는거지..? <- 이거 등록 버튼 눌렀을 때 작동하는 api다, 등록할 때 보내고 받는거지...
    //책에서 PutMapping으로 되어있는데 오타인듯 postMaping임, 그래야지 requestBody를 가져오지.. 근데 requstBody가 멀까.. 정확히 몰라..
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PostMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id,requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }
}
