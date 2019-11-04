package application.event.tournament_join;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;


@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class TournamentFighterJoinEvent implements Serializable {

    private final Long fighterId;
    private final String fighterName;

}
