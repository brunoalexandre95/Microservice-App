package application.repository;

import application.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("select player.id from Player player")
    List<Long> findAllIds();

    Player findById(Long randomIndex);
}
