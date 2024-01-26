package MoEzwawi.BES7L5.exceptions;

import java.time.LocalDateTime;

public record ErrorsDTO(String message, LocalDateTime timestamp) {
}
