package application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Stats {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private double attack = 50;

    private double defense = 50;

    private double stamina = 50;

    private int victories = 0;

    private int losses = 0;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "stats")
    private Fighter fighter;

}
