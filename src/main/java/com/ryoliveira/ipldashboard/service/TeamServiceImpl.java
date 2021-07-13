package com.ryoliveira.ipldashboard.service;


import com.ryoliveira.ipldashboard.model.*;
import com.ryoliveira.ipldashboard.repository.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepo;
    private final MatchRepository matchRepo;

    public TeamServiceImpl(TeamRepository teamRepo, MatchRepository matchRepo){
        this.teamRepo = teamRepo;
        this.matchRepo = matchRepo;
    }


    @Override
    public Iterable<Team> getAllTeams() {
        return teamRepo.findAll();
    }

    @Override
    public Team getTeam(String teamName) {
        Optional<Team> optTeam = this.teamRepo.findByTeamName(teamName);
        Team team = optTeam.orElseThrow(NoSuchElementException::new);

        if(team != null){
            List<Match> teamMatches = this.matchRepo.findLatestMatchesByTeam(teamName, 4);
            team.setMatches(teamMatches);
        }

        return team;
    }

    @Override
    public List<Match> getTeamMatchesByYear(String teamName, int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year + 1, 1, 1);
        return this.matchRepo.getMatchesByTeamBetweenDates(teamName, startDate, endDate);
    }
}
