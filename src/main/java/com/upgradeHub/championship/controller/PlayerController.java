package com.upgradeHub.championship.controller;
import com.upgradeHub.championship.controller.request.PlayerRQ;
import com.upgradeHub.championship.model.Player;
import com.upgradeHub.championship.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
public class PlayerController {

    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> getPlayers() {return playerService.findAll();}

    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable(value = "playerName") Long id) {return playerService.findById(id);}

    //Create
    @PostMapping(value ="/player", consumes = "application/json", produces = "application/json")
    public ResponseEntity createPlayer(@RequestBody PlayerRQ playerRQ, @RequestParam Long teamId){
        Long playerId = playerService.createPlayer(playerRQ, teamId).getId();
        return ResponseEntity.created(URI.create("/player/" + playerId )).body("Player Created");
    }

    //Update
    @PutMapping(value ="/player/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity updatePlayerByID(@RequestParam Long id, @RequestBody PlayerRQ playerRQ,  @RequestParam Long teamId){
        Long playerId = playerService.updatePlayerById(id, playerRQ, teamId).getId();
        return ResponseEntity.created(URI.create("/player/" + playerId)).body("Player Updated");
    }

    @DeleteMapping(path = "/delete-player/{id}")
    public ResponseEntity deletePlayer(@PathVariable(value = "id") Long playerId) {
        playerService.deleteById(playerId);
        return ResponseEntity.created(URI.create("/player" + playerId)).body("player was deleted");
    }
}
