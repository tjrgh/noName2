package com.jojoldu.book.untitled.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long>{

}
/*JPA에서 Repository라고 부름. JpaRepository<Entity클래스, PK타입>을 상속하면 기본 CRUD메소드가 생성.
 * Entity클래스와 Entity Repository는 함께 위치해야 한다. */