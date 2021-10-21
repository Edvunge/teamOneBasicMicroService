package com.upgradeHub.championship.repository;
import com.upgradeHub.championship.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
