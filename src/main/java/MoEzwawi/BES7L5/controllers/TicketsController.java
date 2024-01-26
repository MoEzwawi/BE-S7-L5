package MoEzwawi.BES7L5.controllers;

import MoEzwawi.BES7L5.entities.Ticket;
import MoEzwawi.BES7L5.payloads.tickets.NewTicketDTO;
import MoEzwawi.BES7L5.payloads.tickets.TicketResponseDTO;
import MoEzwawi.BES7L5.services.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/tickets")
public class TicketsController {
    @Autowired
    private TicketsService ticketsService;
    @PostMapping
    public TicketResponseDTO buyTicket(NewTicketDTO body){
        Ticket newTicket = ticketsService.buyTicket(body);
        return new TicketResponseDTO(newTicket.getId(), LocalDateTime.now());
    }
}
