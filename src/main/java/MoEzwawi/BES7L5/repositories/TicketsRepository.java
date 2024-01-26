package MoEzwawi.BES7L5.repositories;

import MoEzwawi.BES7L5.entities.Event;
import MoEzwawi.BES7L5.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<Ticket, Event> {
}
