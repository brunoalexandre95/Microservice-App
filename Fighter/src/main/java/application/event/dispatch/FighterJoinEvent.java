package application.event.dispatch;

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
public final class FighterJoinEvent implements Serializable {

    @JsonProperty("id")
    private final Long fighterId;

    @JsonProperty("name")
    private final String fighterName;

}
