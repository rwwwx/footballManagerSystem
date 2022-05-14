package io.rwwwx.footballmanagersystem.controller;

import io.rwwwx.footballmanagersystem.dto.TeamDTO;
import io.rwwwx.footballmanagersystem.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Long id) {
        return new ResponseEntity<>(teamService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<TeamDTO> saveNewTeam(@Valid @RequestBody TeamDTO teamDTO) {
        return new ResponseEntity<>(teamService.save(teamDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDTO> updateTeam(@PathVariable Long id, @Valid @RequestBody TeamDTO teamDTO) {
        return new ResponseEntity<>(teamService.updateTeam(id, teamDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
