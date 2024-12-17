package com.example.golfclubapi.controller;

import com.example.golfclubapi.entity.Member;
import com.example.golfclubapi.entity.Tournament;
import com.example.golfclubapi.service.GolfClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/golfclub")
public class GolfClubController {

    @Autowired
    private GolfClubService service;

    @PostMapping("/members")
    public Member addMember(@RequestBody Member member) {
        return service.addMember(member);
    }

    @PostMapping("/tournaments")
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return service.addTournament(tournament);
    }

    @GetMapping("/members/search")
    public List<Member> searchMembers(@RequestParam String name) {
        return service.searchMembersByName(name);
    }

    @GetMapping("/tournaments/search")
    public List<Tournament> searchTournaments(@RequestParam String location) {
        return service.searchTournamentsByLocation(location);
    }
}
