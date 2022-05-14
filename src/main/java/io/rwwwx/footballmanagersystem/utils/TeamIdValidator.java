package io.rwwwx.footballmanagersystem.utils;

import io.rwwwx.footballmanagersystem.repository.TeamRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TeamIdValidator implements ConstraintValidator<TeamIdConstraint, Long> {

    private final TeamRepository teamRepository;

    public TeamIdValidator(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void initialize(TeamIdConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        return teamRepository.existsById(id);
    }
}
