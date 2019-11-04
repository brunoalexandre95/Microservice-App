package application.repository;

import application.domain.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Long> {

    @Query("select fighter.id from Fighter fighter")
    List<Long> findAllIds();

    Fighter findById(Long randomIndex);

    Fighter findByName(String f1);
}
