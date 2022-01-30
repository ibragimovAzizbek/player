package com.example.demo4.Controller;

import com.example.demo4.Service.PlayerService;
import com.example.demo4.modul.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Player requestplayer){
        return playerService.create(requestplayer);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return playerService.getAll();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam("playerId")Integer playerId,
                         @RequestBody Player requestPlayer) {
       return playerService.update(playerId,requestPlayer);
        }

        @DeleteMapping
        public ResponseEntity<?>delete (@RequestParam("playerId") Integer playerId){
           return playerService.delete(playerId);
        }

    }
