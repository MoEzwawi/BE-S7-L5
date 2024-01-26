package MoEzwawi.BES7L5.services;

import MoEzwawi.BES7L5.entities.Event;
import MoEzwawi.BES7L5.entities.User;
import MoEzwawi.BES7L5.exceptions.NotFoundException;
import MoEzwawi.BES7L5.payloads.events.EventDTO;
import MoEzwawi.BES7L5.repositories.EventsRepository;
import MoEzwawi.BES7L5.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService {
    @Autowired
    private EventsRepository eventsRepository;
    @Autowired
    private UsersService usersService;
    public List<Event> showEvents(){
        return this.eventsRepository.findAll();
    }
    public Event save(EventDTO body){
        User organizer = usersService.findById(body.organizerId());
        Event newEvent = new Event(body.title(), body.date(), body.capacity(), organizer);
        eventsRepository.save(newEvent);
        return newEvent;
    }
    public Event findById(long id){
        return eventsRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public Event addImage(long id,EventDTO body){
        Event event = this.findById(id);
        event.setImageUrl(body.imgUrl());
        return eventsRepository.save(event);
    }
}
