package MoEzwawi.BES7L5.payloads.events;

import java.time.LocalDate;

public record EventDTO(String title, LocalDate date, int capacity, long organizerId, String imgUrl) {
}
