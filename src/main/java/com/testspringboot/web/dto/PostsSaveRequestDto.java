package com.testspringboot.web.dto;

import com.testspringboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//POST에 대한 DTO
//Entity는 테이블에 직접적으로 관여하는 근본적인 얘기 때문에
//viewer 단에서 가져오는건 dto로 가져오고 entitiy로 빌드하자.
//나중에 수정할 일 생기면 entity가 아니라 여기 DTO를 수정할 것!!(*중요)
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
