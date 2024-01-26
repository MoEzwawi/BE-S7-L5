package MoEzwawi.BES7L5.controllers;

import MoEzwawi.BES7L5.entities.Event;
import MoEzwawi.BES7L5.payloads.events.EventDTO;
import MoEzwawi.BES7L5.services.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {
    @Autowired
    private EventsService eventsService;
    @GetMapping
    public List<Event> showEvents(){
        return eventsService.showEvents();
    }
    @PostMapping
    @PreAuthorize("hasAuthority('ORGANIZER')")
    public Event addNewEvent(EventDTO body){
        return eventsService.save(body);
    }
    @GetMapping("/{id}")
    public Event findById(@PathVariable long id){
        return eventsService.findById(id);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ORGANIZER')")
    public Event addImage(@PathVariable long id, @RequestBody EventDTO body){
        return eventsService.addImage(id, body);
    }
}
