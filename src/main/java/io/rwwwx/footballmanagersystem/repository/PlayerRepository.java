package io.rwwwx.footballmanagersystem.repository;

import io.rwwwx.footballmanagersystem.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}