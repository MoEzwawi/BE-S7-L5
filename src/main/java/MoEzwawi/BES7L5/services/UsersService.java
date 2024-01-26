package MoEzwawi.BES7L5.services;

import MoEzwawi.BES7L5.entities.User;
import MoEzwawi.BES7L5.exceptions.NotFoundException;
import MoEzwawi.BES7L5.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public Page<User> getUsers(int page, int size, String orderBy) {
        if (size >= 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return usersRepository.findAll(pageable);
    }


    public User findById(long id) {
        return usersRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }


    public User findByUsername(String username) throws NotFoundException {
        return usersRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("User " + username + " not found"));
    }


}
