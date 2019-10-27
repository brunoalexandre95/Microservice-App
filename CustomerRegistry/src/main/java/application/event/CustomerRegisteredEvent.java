package application.event;

import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class CustomerRegisteredEvent implements Serializable {

    private final Long customerId;
    private final String firstName;

}
