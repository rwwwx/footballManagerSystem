package io.rwwwx.footballmanagersystem.repository;

import io.rwwwx.footballmanagersystem.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}