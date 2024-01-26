package MoEzwawi.BES7L5.payloads.users;

import java.time.LocalDateTime;

public record NewUserResponseDTO(long id, LocalDateTime iat) {
}
