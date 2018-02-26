package ro.wizadi.flightforum.modules.sample.domain.repositories.impl;

import ro.wizadi.flightforum.modules.sample.domain.entities.User;
import ro.wizadi.flightforum.modules.sample.domain.repositories.UserCustomRepository;

public class UserRepositoryImpl implements UserCustomRepository{

    @Override
    public User returnNewUser()
    {
        return new User();
    }
}
