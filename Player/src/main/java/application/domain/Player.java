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
public class Player {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @NotNull
    private String name;

    private Date birthDate;

    private double weight;

    private double height;

    @Enumerated(EnumType.STRING)
    private SexEnum sex;

    private String nationality = "Portuguese";

    @OneToOne(cascade = CascadeType.ALL)
    private Stats stats;

}
