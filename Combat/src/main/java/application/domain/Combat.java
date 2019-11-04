package application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Combat {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private Date combatDate;

    @ManyToOne
    private TournamentFighter fighterA;

    @ManyToOne
    private TournamentFighter fighterB;

    @ManyToOne
    private TournamentFighter winner;

    @ManyToOne
    private Tournament tournament;

}
