package ro.wizadi.flightforum.modules.sample.service;

import org.springframework.stereotype.Service;
import ro.wizadi.flightforum.modules.sample.domain.entities.User;
import ro.wizadi.flightforum.modules.sample.domain.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User addNewUser(String name, String email) {

        User u = new User();
        u.setName(name);
        u.setEmail(email);
        userRepository.save(u);

        return u;
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User returnNewUser() {
        return new User();
    }
}
