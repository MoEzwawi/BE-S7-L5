package MoEzwawi.BES7L5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    @Setter
    private String description;
    private LocalDate date;
    @Setter
    private String venue;
    private int capacity;
    @ManyToOne
    @JoinColumn
    private User organizer;
    @Setter
    private String imageUrl;

    public Event(String title, LocalDate date, int capacity, User organizer) {
        this.title = title;
        this.date = date;
        this.capacity = capacity;
        this.organizer = organizer;
    }
}
