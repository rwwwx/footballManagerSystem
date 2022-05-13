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

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private final List<Player> players = new ArrayList<>();

    public Team(int commission, String name, int account) {
        this.commission = commission;
        this.name = name;
        this.account = account;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
    public void subtractMoney(int deductibleAmount) {
        account = account - deductibleAmount;
    }

}
