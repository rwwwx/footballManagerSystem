package io.rwwwx.footballmanagersystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class TeamDTO {

    private Long id;

    @Min(0)
    @Max(10)
    private int commission;

    //TODO customValidator
    @NotNull
    private String name;

    @Min(0)
    private int account;

    private List<Player> players = new ArrayList<>();

    public TeamDTO(Long id, int commission, String name, int account, List<Player> players) {
        this.id = id;
        this.commission = commission;
        this.name = name;
        this.account = account;
        this.players = players;
    }

}
