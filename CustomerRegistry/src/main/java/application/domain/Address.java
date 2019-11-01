package application.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String country;

    private String city;

    private String street;

    private String zipCode;

}
