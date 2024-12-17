package com.example.golfclubapi.service;

import com.example.golfclubapi.entity.Member;
import com.example.golfclubapi.repository.MemberRepository;
import com.example.golfclubapi.repository.TournamentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GolfClubServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private TournamentRepository tournamentRepository;

    @InjectMocks
    private GolfClubService golfClubService;

    @Test
    void addMemberTest() {
        Member member = new Member();
        member.setName("John Doe");

        when(memberRepository.save(any(Member.class))).thenReturn(member);

        Member savedMember = golfClubService.addMember(member);

        assertNotNull(savedMember);
        assertEquals("John Doe", savedMember.getName());
        verify(memberRepository, times(1)).save(any(Member.class));
    }
}
