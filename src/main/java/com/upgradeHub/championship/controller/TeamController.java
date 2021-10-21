package com.upgradeHub.championship.controller;
import com.upgradeHub.championship.controller.request.TeamRQ;
import com.upgradeHub.championship.model.Player;
import com.upgradeHub.championship.model.Team;
import com.upgradeHub.championship.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
public class TeamController {

    TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public List<Team> getTeams() {return teamService.findAll();}

    @GetMapping("/teams/{id}")
    public Team getTeamsById(@PathVariable(value = "id") Long id) {return teamService.findById(id);}


    //Create
    @PostMapping(value ="/team", consumes = "application/json", produces = "application/json")
    public ResponseEntity createTeam(@RequestBody TeamRQ teamRQ){
        Long teamId = teamService.createTeam(teamRQ).getId();
        return ResponseEntity.created(URI.create("/team/" + teamId )).body("Team Created");
    }

    //Update
    @PutMapping(value ="/team/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateTeamByID(@RequestParam Long id, @RequestBody TeamRQ teamRQ){
        Long teamId = teamService.updateTeamById(id, teamRQ).getId();
        return ResponseEntity.created(URI.create("/team/" + teamId)).body("Team Updated");
    }

    @DeleteMapping(path = "/delete-team/{id}")
    public ResponseEntity deleteTeam(@PathVariable(value = "id") Long teamId) {
        teamService.deleteById(teamId);
        return ResponseEntity.created(URI.create("/team" + teamId)).body("Team was deleted");
    }
}
