package com.example.golfclubapi.controller;

import com.example.golfclubapi.entity.Member;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.golfclubapi.service.GolfClubService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GolfClubController.class)
class GolfClubControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GolfClubService golfClubService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void addMemberTest() throws Exception {
        Member member = new Member();
        member.setName("Jane Doe");

        when(golfClubService.addMember(any(Member.class))).thenReturn(member);

        mockMvc.perform(post("/api/golfclub/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(member)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jane Doe"));

        verify(golfClubService, times(1)).addMember(any(Member.class));
    }
}
