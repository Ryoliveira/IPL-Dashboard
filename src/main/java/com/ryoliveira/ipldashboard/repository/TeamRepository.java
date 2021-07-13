package com.ryoliveira.ipldashboard.repository;

import com.ryoliveira.ipldashboard.model.*;
import org.springframework.data.repository.*;

import java.util.*;

public interface TeamRepository extends CrudRepository<Team, Long> {

    Optional<Team> findByTeamName(String teamName);
}
