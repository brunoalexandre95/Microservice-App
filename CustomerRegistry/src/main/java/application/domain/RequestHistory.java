package application.domain;

import application.enumerate.RequestTypeEnum;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class RequestHistory {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private RequestTypeEnum requestType;

    private Date requestDate;

    private long requestTime;

    @ManyToOne
    Customer customer;

}
