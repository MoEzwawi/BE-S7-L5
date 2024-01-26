package MoEzwawi.BES7L5.payloads.users;

import MoEzwawi.BES7L5.entities.enums.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewUserDTO(
        @NotEmpty(message = "Name field is mandatory")
        @Size(min = 3, max = 20)
        String name,
        @NotEmpty(message = "Surname field is mandatory")
        @Size(min = 3, max = 20)
        String surname,
        @NotEmpty(message = "Username field is mandatory")
        @Size(min = 3, max = 20)
        String username,
        @NotEmpty(message = "Password field is mandatory")
        @Size(min = 4)
        String password,
        Role role) {
}
