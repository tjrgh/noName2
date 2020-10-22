package com.jojoldu.book.untitled.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)/*JUnit안에 runner객체가 내장되어있어 테스트를 징행해주는데, 이것대신에 Spring에서 제공하는
 runner를 사용하겟다는 오노테이션. 스프링 runner도 junit의 runner를 커스터마이징하여 스프링에 맞게만든것.*/
@WebMvcTest
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name="hello";
        int amount=1000;

        mvc.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(amount)))
                .andExpect(status().isOk()).andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));

    }
}
