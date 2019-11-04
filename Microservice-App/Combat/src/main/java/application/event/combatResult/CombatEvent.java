package application.event.combatResult;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;


@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class CombatEvent implements Serializable {

    @JsonProperty("fighter1")
    private final String fighterOne;

    @JsonProperty("fighter2")
    private final String fighterTwo;

    @JsonProperty("winner")
    private final String winner;

}
