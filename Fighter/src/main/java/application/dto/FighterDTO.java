package application.dto;

import application.domain.Stats;
import application.enumerate.SexEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import java.util.Date;

@Getter
@Setter
public class FighterDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("tournaments")
    private Integer tournaments;

    @JsonProperty("birthDate")
    private Date birthDate;

    @JsonProperty("weight")
    private double weight;

    @JsonProperty("height")
    private double height;

    @JsonProperty("sex")
    private SexEnum sex;

    @JsonProperty("nationality")
    private String nationality;

    @JsonProperty("attack")
    private double attack;

    @JsonProperty("defense")
    private double defense;

    @JsonProperty("stamina")
    private double stamina;

    @JsonProperty("victories")
    private int victories;

    @JsonProperty("losses")
    private int losses;

}
