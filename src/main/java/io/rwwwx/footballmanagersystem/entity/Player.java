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
    private Team currentTeam;

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", amountOfExperience=" + amountOfExperience +
                ", currentTeam=" + currentTeam.getName() +
                '}';
    }

}
