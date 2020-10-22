package com.jojoldu.book.untitled.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest/*이게 있으면 자동으로 h2 데이터베이스를 실행해줌.*/
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After/*junit에서 단위테스트 끝날때마다 실행될 메소드임을 나타냄.*/
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test/*junit runner에 의해 자동으로샐행될 메소드.*/
    public void 게시글저장_불러오기(){
        String title="테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()/*빌더패턴을 이용한 엔터티 객체 생성. save()는 테이블posts에 insert/update 실행.
                                                id값이 있다면 update, 없으면 insert.*/
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build());

        List<Posts> postsList = postsRepository.findAll();/*posts 테이블의 모든 데이터 조회.*/

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

}
