package com.upgradeHub.championship.repository;
import com.upgradeHub.championship.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findTeamByTeamName(String teamName);
}
