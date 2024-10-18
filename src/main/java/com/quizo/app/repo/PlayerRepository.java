package com.quizo.app.repo;

import com.quizo.app.entity.Player;
import com.quizo.app.entity.PlayerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, PlayerId> {
}
