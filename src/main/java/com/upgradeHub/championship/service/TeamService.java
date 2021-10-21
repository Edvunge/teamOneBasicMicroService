package com.upgradeHub.championship.service;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.upgradeHub.championship.controller.request.TeamRQ;
import com.upgradeHub.championship.exception.ResourceNotFound;
import com.upgradeHub.championship.model.Player;
import com.upgradeHub.championship.model.Team;
import com.upgradeHub.championship.model.TeamType;
import com.upgradeHub.championship.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    public Team createTeam(TeamRQ teamRQ) {
        boolean contains = false;
        for(TeamType c : TeamType.values()) {
            if(c == teamRQ.getTeamType()){
                contains = true;
            }
        }
        if(!contains){
            throw new ResourceNotFound("You Need To add a Existing Type");
        }
        TeamType teamType = teamRQ.getTeamType();
        String teamName = teamRQ.getTeamName();
        Team newTeam = Team
                .builder()
                .teamName(teamName)
                .teamType(teamType)
                .build();
        return teamRepository.save(newTeam);
    }

    public Team updateTeamById(Long id, TeamRQ teamRQ) {
        if(!teamRepository.existsById(id)){
            throw new ResourceNotFound("You need to add an existing Team ID");
        }
        boolean contains = false;
        for(TeamType c : TeamType.values()) {
            if(c == teamRQ.getTeamType()){
                contains = true;
            }
        }
        if(!contains){
            throw new ResourceNotFound("You Need To add a Existing Type");
        }
        TeamType teamType = teamRQ.getTeamType();
        String teamName = teamRQ.getTeamName();
        Team teamToBeUpdated = teamRepository.getById(id);
        teamToBeUpdated.setTeamType(teamType);
        teamToBeUpdated.setTeamName(teamName);
        return teamRepository.save(teamToBeUpdated);
    }

    public void deleteById(Long id) {
        if(!teamRepository.existsById(id)){
            throw new ResourceNotFound("You need to add an existing Team");
        }
        teamRepository.deleteById(id);
    }
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Team findById(Long id) {
        return teamRepository.findById(id).get();
    }

}
