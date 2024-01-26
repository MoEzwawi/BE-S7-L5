package MoEzwawi.BES7L5.services;

import MoEzwawi.BES7L5.entities.User;
import MoEzwawi.BES7L5.exceptions.BadRequestException;
import MoEzwawi.BES7L5.exceptions.UnauthorizedException;
import MoEzwawi.BES7L5.payloads.users.NewUserDTO;
import MoEzwawi.BES7L5.payloads.users.UserLoginDTO;
import MoEzwawi.BES7L5.repositories.UsersRepository;
import MoEzwawi.BES7L5.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder bcrypt;

    @Autowired
    private JWTTools jwtTools;

    public String authenticateUser(UserLoginDTO body) {
        User user = usersService.findByUsername(body.username());
        if (bcrypt.matches(body.password(), user.getPassword())) {
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Invalid username or password");
        }
    }

    public User save(NewUserDTO body) {
		Optional<User> user = usersRepository.findByUsername(body.username());
		if(user.isPresent()){
            throw new BadRequestException("Username "+body.username()+" already in use");
        }
        User newUser = new User(body.name(), body.surname(), body.username(),
                bcrypt.encode(body.password()),body.role());
        return usersRepository.save(newUser);
    }
}
