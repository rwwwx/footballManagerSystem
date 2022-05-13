package io.rwwwx.footballmanagersystem.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class TeamDTO {

    @Min(0)
    @Max(10)
    private int commission;

    @NotNull
    private String name;

    @Min(0)
    private int account;

    public TeamDTO(int commission, String name, int account) {
        this.commission = commission;
        this.name = name;
        this.account = account;
    }

}
