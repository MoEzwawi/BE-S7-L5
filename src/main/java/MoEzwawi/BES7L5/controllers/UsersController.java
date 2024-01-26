package MoEzwawi.BES7L5.controllers;

import MoEzwawi.BES7L5.entities.User;
import MoEzwawi.BES7L5.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping
    @PreAuthorize("hasAuthority('ORGANIZER')")
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size,
                               @RequestParam(defaultValue = "id") String orderBy) {
        return usersService.getUsers(page, size, orderBy);
    }

    @GetMapping("/me")
    public User getProfile(@AuthenticationPrincipal User currentUser) {
        return currentUser;
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('ORGANIZER')")
    public User getUserById(@PathVariable long userId) {
        return usersService.findById(userId);
    }
}
