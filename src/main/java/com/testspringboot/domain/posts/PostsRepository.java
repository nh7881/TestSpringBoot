package com.testspringboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//extends JpaRepository<Entity, PK> 만하면 자동 CRUD 생성... 와우..
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT P FROM Posts P ORDER BY P.id DESC")
    List<Posts> findAllDesc();
}
