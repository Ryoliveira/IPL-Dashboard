package com.ryoliveira.ipldashboard.service;

import com.ryoliveira.ipldashboard.model.*;

import java.util.*;

public interface TeamService {

    Iterable<Team> getAllTeams();

    Team getTeam(String teamName);

    List<Match> getTeamMatchesByYear(String teamName, int year);

}
