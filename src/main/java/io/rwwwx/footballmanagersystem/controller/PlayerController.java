package io.rwwwx.footballmanagersystem.controller;

import io.rwwwx.footballmanagersystem.entity.PlayerDTO;
import io.rwwwx.footballmanagersystem.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long id) {
        return new ResponseEntity<>(playerService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<PlayerDTO> saveNewPlayer(@Valid @RequestBody PlayerDTO playerDTO) {
        return new ResponseEntity<>(playerService.save(playerDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable Long id, @Valid @RequestBody PlayerDTO playerDTO) {
        return new ResponseEntity<>(playerService.updatePlayer(id, playerDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PlayerDTO> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
