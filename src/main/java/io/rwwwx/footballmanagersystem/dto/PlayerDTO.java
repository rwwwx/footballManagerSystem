package io.rwwwx.footballmanagersystem.dto;

import io.rwwwx.footballmanagersystem.utils.TeamIdConstraint;
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

    @NotNull
    @TeamIdConstraint
    private Long idOfCurrentTeam;

    public PlayerDTO(String firstName, String lastName, int age, int amountOfExperience, Long idOfCurrentTeam) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.amountOfExperience = amountOfExperience;
        this.idOfCurrentTeam = idOfCurrentTeam;
    }

}
