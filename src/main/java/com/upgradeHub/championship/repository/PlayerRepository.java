package com.upgradeHub.championship.repository;
import com.upgradeHub.championship.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
