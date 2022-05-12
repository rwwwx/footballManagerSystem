package io.rwwwx.footballmanagersystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "TEAMS")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    private int commission;

    private String name;

    private int account;

    @OneToMany(mappedBy = "id")
    private List<Player> players = new ArrayList<>();

    public Team(Long id, int commission, String name, int account, List<Player> players) {
        this.id = id;
        this.commission = commission;
        this.name = name;
        this.account = account;
        this.players = players;
    }

}
