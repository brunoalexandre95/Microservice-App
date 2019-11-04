package application.repository;

import application.domain.TournamentFighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentFighterRepository extends JpaRepository<TournamentFighter,Long> {

}
