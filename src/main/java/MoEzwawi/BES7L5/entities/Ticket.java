package MoEzwawi.BES7L5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name="tickets")
public class Ticket {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn
    private User user;
    @ManyToOne
    @JoinColumn
    private Event event;

    public Ticket(User user, Event event) {
        this.user = user;
        this.event = event;
    }
}
