package ro.wizadi.flightforum.modules.sample.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import ro.wizadi.flightforum.modules.sample.domain.entities.User;

public interface UserRepository extends CrudRepository<User, Long> , UserCustomRepository{
}
