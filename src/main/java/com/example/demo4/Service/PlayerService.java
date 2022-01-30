package com.example.demo4.Service;

import com.example.demo4.modul.Player;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class PlayerService {
    private List<Player> playerList;
    private static int index;

    public PlayerService() {
        this.playerList = new ArrayList<>();
        index = 1;
    }

    public ResponseEntity<?> create(@RequestBody Player requestplayer) {
        requestplayer.setPlayerId(index);
        playerList.add(requestplayer);
        index++;
        HttpHeaders Headers = new HttpHeaders();
        Headers.add("Date", LocalDateTime.now().toString());
        Headers.add("Status", "Object created");
        return new ResponseEntity<>(requestplayer, Headers, HttpStatus.OK);
    }

    //-----
    public ResponseEntity<?> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Date", LocalDateTime.now().toString());
        return new ResponseEntity<>(playerList, headers, HttpStatus.OK);
    }

    public ResponseEntity<?> update(@RequestParam("playerId") Integer playerId,
                                    @RequestBody Player requestPlayer) {
        for (Player updatePlayer : playerList) {
            if (updatePlayer.getPlayerId().equals(playerId)) {
                updatePlayer.setPlayerName(requestPlayer.getPlayerName());
                updatePlayer.setPlayerSurname(requestPlayer.getPlayerSurname());
                updatePlayer.setPlayerNumber(requestPlayer.getPlayerNumber());
                updatePlayer.setPlayerSalary(requestPlayer.getPlayerSalary());
                HttpHeaders Headers = new HttpHeaders();
                Headers.add("Date", LocalDateTime.now().toString());
                return new ResponseEntity<>(updatePlayer, Headers, HttpStatus.OK);
            }
        }
        HttpHeaders Headers = new HttpHeaders();
        Headers.add("Date", LocalDateTime.now().toString());
        return new ResponseEntity<>("Player information is incorrect", Headers, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> delete(@RequestParam("playerId") Integer playerId) {
        for (Player deletePlayer : playerList) {
            if (deletePlayer.getPlayerId().equals(playerId)) {
                playerList.remove(deletePlayer);
                HttpHeaders Headers = new HttpHeaders();
                Headers.add("Date", LocalDateTime.now().toString());
                return new ResponseEntity<>(deletePlayer, Headers, HttpStatus.OK);
            }
        }
        HttpHeaders Headers = new HttpHeaders();
        Headers.add("Date", LocalDateTime.now().toString());
        return new ResponseEntity<>("yuo entered bad request", Headers, HttpStatus.BAD_REQUEST);
    }
}