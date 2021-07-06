package com.ryoliveira.ipldashboard.repository;

import com.ryoliveira.ipldashboard.model.*;
import org.springframework.data.repository.*;

public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByTeamName(String teamName);
}
