package com.testspringboot.service;

import com.testspringboot.domain.posts.Posts;
import com.testspringboot.domain.posts.PostsRepository;
import com.testspringboot.web.dto.PostsResponseDto;
import com.testspringboot.web.dto.PostsSaveRequestDto;
import com.testspringboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Service란 뭘까?
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    //Dto 값을 table에 저장하고 id(PK)를 리턴
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    //Dto 값을 table에 저장하고 id(PK)를 리턴
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }
}
