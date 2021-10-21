package com.upgradeHub.championship.controller;
import com.upgradeHub.championship.controller.request.GameRQ;
import com.upgradeHub.championship.model.Game;
import com.upgradeHub.championship.model.Player;
import com.upgradeHub.championship.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
public class GameController {

    GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public List<Game> getGame() {return gameService.findAll();}

    @GetMapping("/games/{id}")
    public Game getGamesById(@PathVariable(value = "id") Long id) {return gameService.findById(id);}


    //Create
    @PostMapping(value ="/game", consumes = "application/json", produces = "application/json")
    public ResponseEntity createGame(@RequestBody GameRQ gameRQ){
        String gameDay = gameService.createGame(gameRQ).getLocalDateTime().toString();
        return ResponseEntity.created(URI.create("/game/" + gameDay )).body("Game Created");
    }

    //Update
    @PutMapping(value ="/game/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateGameByID(@RequestParam Long id, @RequestBody GameRQ gameRQ){
        gameService.updateGameById(id, gameRQ);
        return ResponseEntity.created(URI.create("/game/" + id)).body("Date Updated");
    }

    @DeleteMapping(path = "/delete-game/{id}")
    public ResponseEntity deleteGame(@PathVariable(value = "id") Long gameId) {
        gameService.deleteById(gameId);
        return ResponseEntity.created(URI.create("/game")).body("Game was deleted");
    }
}
