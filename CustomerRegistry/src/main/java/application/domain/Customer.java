package application.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    private Date birthDate = new Date();

    @OneToMany
    List<Address> addresses;

}
