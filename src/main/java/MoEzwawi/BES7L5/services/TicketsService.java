package MoEzwawi.BES7L5.services;

import MoEzwawi.BES7L5.entities.Event;
import MoEzwawi.BES7L5.entities.Ticket;
import MoEzwawi.BES7L5.entities.User;
import MoEzwawi.BES7L5.payloads.tickets.NewTicketDTO;
import MoEzwawi.BES7L5.repositories.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketsService {
    @Autowired
    private TicketsRepository ticketsRepository;
    @Autowired
    private EventsService eventsService;
    @Autowired
    private UsersService usersService;
    public Ticket buyTicket(NewTicketDTO body){
        User user = usersService.findById(body.userId());
        Event event = eventsService.findById(body.eventId());
        Ticket newTicket = new Ticket(user,event);
        return ticketsRepository.save(newTicket);
    }
}
