package application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class TournamentFighter {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private String name;

    private boolean eliminated = false;

    @ManyToOne
    private Tournament tournament;

}
