package MoEzwawi.BES7L5.repositories;

import MoEzwawi.BES7L5.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Event,Long> {
}
