package io.rwwwx.footballmanagersystem.controller;

import io.rwwwx.footballmanagersystem.dto.PlayerDTO;
import io.rwwwx.footballmanagersystem.service.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    public final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PutMapping("/transfer")
    public ResponseEntity<PlayerDTO> transfer(@RequestParam Long playerId, @RequestParam Long newTeamId) {
        return new ResponseEntity<>(transferService.transferPlayer(playerId, newTeamId), HttpStatus.OK);
    }

}
