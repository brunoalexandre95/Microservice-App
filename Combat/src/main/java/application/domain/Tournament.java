package application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Tournament {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private boolean finished = false;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TournamentFighter> tournamentFighters = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Combat> combats = new ArrayList<>();

}
