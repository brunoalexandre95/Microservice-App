package application.domain;

import application.enumerate.SexEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Fighter {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @NotNull
    private String name;

    private Integer tournaments = 0;

    private Date birthDate;

    private double weight;

    private double height;

    @Enumerated(EnumType.STRING)
    private SexEnum sex;

    private String nationality = "Portuguese";

    @OneToOne(cascade = CascadeType.ALL)
    private Stats stats;

    public void incrementVictories() {

        int currentVictories = stats.getVictories();
        stats.setVictories(currentVictories + 1);
    }

    public void incrementLosses() {
        int currentLosses = stats.getLosses();
        stats.setLosses(currentLosses + 1);
    }
}
