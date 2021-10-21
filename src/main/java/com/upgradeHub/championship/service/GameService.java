package com.upgradeHub.championship.service;
import aj.org.objectweb.asm.ConstantDynamic;
import com.upgradeHub.championship.controller.request.GameRQ;
import com.upgradeHub.championship.exception.ResourceNotFound;
import com.upgradeHub.championship.model.Game;
import com.upgradeHub.championship.model.Player;
import com.upgradeHub.championship.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GameService {

    GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game createGame(GameRQ gameRQ) {
        int year = gameRQ.getScheduleYear2021to3000();
        int month = gameRQ.getScheduleMonth1to12();
        int day = gameRQ.getScheduleDay1to31();
        int hour = gameRQ.getScheduleHour0to23();
        LocalDateTime gameDay = LocalDateTime.of(year, month, day, hour,00,00);
        Game newGame = Game
                .builder()
                .localDateTime(gameDay)
                .build();
        return gameRepository.save(newGame);
    }

    public Game updateGameById(Long gameId, GameRQ gameRQ) {
        int year = gameRQ.getScheduleYear2021to3000();
        int month = gameRQ.getScheduleMonth1to12();
        int day = gameRQ.getScheduleDay1to31();
        int hour = gameRQ.getScheduleHour0to23();
        LocalDateTime gameDay = LocalDateTime.of(year, month, day, hour,00,00);
        if(!gameRepository.existsById(gameId)){
            throw new ResourceNotFound("You need to add an existing Game ID");
        }
        Game gameToBeUpdated = gameRepository.findById(gameId).get();
        gameToBeUpdated.setLocalDateTime(gameDay);
        return gameRepository.save(gameToBeUpdated);
    }

    public void deleteById(Long id) {
        if (!gameRepository.existsById(id)) {
            throw new ResourceNotFound("You need to add an existing Game");
        }
        gameRepository.deleteById(id);
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game findById(Long id) {
        return gameRepository.findById(id).get();
    }

}
