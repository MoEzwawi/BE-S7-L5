package MoEzwawi.BES7L5.controllers;

import MoEzwawi.BES7L5.entities.User;
import MoEzwawi.BES7L5.exceptions.BadRequestException;
import MoEzwawi.BES7L5.payloads.users.NewUserDTO;
import MoEzwawi.BES7L5.payloads.users.NewUserResponseDTO;
import MoEzwawi.BES7L5.payloads.users.UserLoginDTO;
import MoEzwawi.BES7L5.payloads.users.UserLoginResponseDTO;
import MoEzwawi.BES7L5.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginDTO body) {
        String accessToken = authService.authenticateUser(body);
        return new UserLoginResponseDTO(accessToken);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewUserResponseDTO createUser(@RequestBody @Validated NewUserDTO newUserPayload, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException("Invalid payload!");
        } else {
            User newUser = authService.save(newUserPayload);
            return new NewUserResponseDTO(newUser.getId(), LocalDateTime.now());
        }
    }
}
