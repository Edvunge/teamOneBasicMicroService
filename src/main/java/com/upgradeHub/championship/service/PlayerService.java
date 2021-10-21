package com.upgradeHub.championship.service;
import com.upgradeHub.championship.controller.request.PlayerRQ;
import com.upgradeHub.championship.exception.ResourceNotFound;
import com.upgradeHub.championship.model.Player;
import com.upgradeHub.championship.model.Team;
import com.upgradeHub.championship.repository.PlayerRepository;
import com.upgradeHub.championship.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    PlayerRepository playerRepository;
    TeamRepository teamRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    public Player createPlayer(PlayerRQ playerRQ, Long teamId) {
        if(!teamRepository.existsById(teamId)){
            throw new ResourceNotFound("You need to add an Existing Team");
        }
        Team team = teamRepository.getById(teamId);
        String name = playerRQ.getName();
        int age = playerRQ.getAge();
        Long height = playerRQ.getHeight();
        Long weight = playerRQ.getWeight();
        Player newPlayer = Player
                .builder()
                .name(name)
                .age(age)
                .team(team)
                .height(height)
                .weight(weight)
                .build();
        return playerRepository.save(newPlayer);
    }

    public Player updatePlayerById(Long playerId, PlayerRQ playerRQ,Long teamId ) {
        if(!teamRepository.existsById(teamId)){
            throw new ResourceNotFound("You need to add an Existing Team");
        }
        Team team = teamRepository.getById(teamId);
        if(!playerRepository.existsById(playerId)){
            throw new ResourceNotFound("You need to add an existing Player ID");
        }
        String name = playerRQ.getName();
        int age = playerRQ.getAge();
        Long height = playerRQ.getHeight();
        Long weight = playerRQ.getWeight();
        Player playerToBeUpdated = playerRepository.getById(playerId);
        playerToBeUpdated.setName(name);
        playerToBeUpdated.setTeam(team);
        playerToBeUpdated.setAge(age);
        playerToBeUpdated.setHeight(height);
        playerToBeUpdated.setWeight(weight);
        return playerRepository.save(playerToBeUpdated);
    }

    public void deleteById(Long id) {
        if(!playerRepository.existsById(id)){
            throw new ResourceNotFound("You need to add an existing Player");
        }
        playerRepository.deleteById(id);
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player findById(Long id) {
        return playerRepository.findById(id).get();
    }
}
