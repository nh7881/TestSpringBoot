package com.testspringboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//extends JpaRepository<Entity, PK> 만하면 자동 CRUD 생성... 와우..
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
