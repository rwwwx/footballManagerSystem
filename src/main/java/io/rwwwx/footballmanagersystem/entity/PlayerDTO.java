package io.rwwwx.footballmanagersystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class PlayerDTO {


    private long id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @Min(18)
    @NotNull
    private int age;

    @NotNull
    private int amountOfExperience;

    private Team currentTeam;

    public PlayerDTO(long id, String firstName, String lastName, int age, int amountOfExperience, Team currentTeam) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.amountOfExperience = amountOfExperience;
        this.currentTeam = currentTeam;
    }

    public PlayerDTO(String firstName, String lastName, int age, int amountOfExperience, Team currentTeam) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.amountOfExperience = amountOfExperience;
        this.currentTeam = currentTeam;
    }

    public PlayerDTO(String firstName, String lastName, int age, int amountOfExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.amountOfExperience = amountOfExperience;
    }

}
