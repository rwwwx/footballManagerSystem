package io.rwwwx.footballmanagersystem.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "PLAYERS")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private int amountOfExperience;

    @ManyToOne
    @JoinColumn(name = "current_team_id")
    private Team currentTeam;

    public Player(long id, String firstName, String lastName, int age, int amountOfExperience, Team currentTeam) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.amountOfExperience = amountOfExperience;
        this.currentTeam = currentTeam;
    }

}