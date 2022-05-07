package com.testspringboot.domain.posts;

import com.testspringboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Entity는 테이블의 명세서이며 Repository는 명세서대로 테이블 및 쿼리를 생성하는 것이다.
//Entity = 객체, Repository 와 한 세트이다.
//NoArgsConstructor = 기본 생성자 자동 추가
//Id = PK, GeneratedValue = PK 조건
//@Column은 없어도 자동, 그러나 자동 값말고 다른거 줄려면 쓸 것
//Builder = Builder 패턴 자동 생성.. 패턴 중요하단걸 다시 한 번 깨달음..
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
