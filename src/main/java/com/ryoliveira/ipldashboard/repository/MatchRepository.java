package com.ryoliveira.ipldashboard.repository;

import com.ryoliveira.ipldashboard.model.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.*;

import java.util.*;

public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);

    default List<Match> findLatestMatchesByTeam(String teamName, int count){
        return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
    }

}
