package sungsu.springone.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NewsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("상품 등록 페이지 권한 테스트")
    @WithMockUser(username = "admin", roles = "ADMIN")
    void test1() throws Exception {
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/news/new"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("상품 등록 페이지 권한 실패 테스트")
    @WithMockUser(username = "user", roles = "USER")
    void test2() throws Exception {
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/news/new"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("상품 등록 페이지 권한 post테스트")
    @WithMockUser(username = "admin", roles = "ADMIN")
    void test3() throws Exception {
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/news/new")
                .with(csrf()))  // CSRF 토큰 전달
                .andDo(print())
                .andExpect(status().isOk());
    }
}