package com.ryoliveira.ipldashboard.controller;

import com.ryoliveira.ipldashboard.model.*;
import com.ryoliveira.ipldashboard.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@CrossOrigin
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/team")
    public Iterable<Team> getAllTeams() {
        return this.teamService.getAllTeams();
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        return this.teamService.getTeam(teamName);
    }

    @GetMapping("/team/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {
        return this.teamService.getTeamMatchesByYear(teamName, year);
    }

}
