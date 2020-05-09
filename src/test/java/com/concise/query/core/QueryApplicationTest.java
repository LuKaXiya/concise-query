package com.concise.query.core;

import com.concise.query.QueryApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(classes = QueryApplication.class)
public class QueryApplicationTest {

    @Resource
    protected WebApplicationContext wac;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void queryByUsername() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/query?username=f0rb"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].password").value("123456"));
    }

    @Test
    public void queryByAccount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/query?account=17778888882"))
                .andDo(print())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].nickname").value("测试2"))
                .andExpect(jsonPath("$[1]").doesNotExist())
        ;
    }

    @Test
    public void pageByAccount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/page?account=17778888882&pageNumber=0&pageSize=5"))
                .andExpect(jsonPath("$.list").isArray())
                .andExpect(jsonPath("$.list[0].email").value("test2@163.com"))
                .andExpect(jsonPath("$.total").value(1))
        ;
    }

    @Test
    public void getUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get?id=1"))
                .andExpect(jsonPath("$.username").value("f0rb"))
                .andExpect(jsonPath("$.nickname").value("测试1"))
        ;
    }

    /*=============== menu ==================*/
    @Test
    public void pageMenu() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/menu/page?pageNumber=1&pageSize=2"))
                .andExpect(jsonPath("$.list").isArray())
                .andExpect(jsonPath("$.list[0]").doesNotExist())
                .andExpect(jsonPath("$.total").value(1))
        ;
    }


    @Test
    public void getMenuById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/menu/get?id=1"))
                .andExpect(jsonPath("$.id").value("1"))
        ;
    }
}
