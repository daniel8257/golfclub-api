package com.example.golfclubapi.repository;

import com.example.golfclubapi.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    List<Tournament> findByLocationContaining(String location);
    List<Tournament> findByStartDate(String startDate);
}
