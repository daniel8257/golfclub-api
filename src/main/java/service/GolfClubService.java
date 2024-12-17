package com.example.golfclubapi.service;

import com.example.golfclubapi.entity.Member;
import com.example.golfclubapi.entity.Tournament;
import com.example.golfclubapi.repository.MemberRepository;
import com.example.golfclubapi.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GolfClubService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public List<Member> searchMembersByName(String name) {
        return memberRepository.findByNameContaining(name);
    }

    public List<Tournament> searchTournamentsByLocation(String location) {
        return tournamentRepository.findByLocationContaining(location);
    }
}
