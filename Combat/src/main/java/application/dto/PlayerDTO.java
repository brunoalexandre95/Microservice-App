package application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PlayerDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("birthDate")
    private Date birthDate;

    @JsonProperty("weight")
    private double weight;

    @JsonProperty("height")
    private double height;

    @JsonProperty("sex")
    private String sex;

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
