package application.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public  class CustomerTrack {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ActionTypeEnum actionType;

    private String username;

    private Date birthDate = new Date();
}
