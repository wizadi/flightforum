package ro.wizadi.flightforum.modules.sample.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import ro.wizadi.flightforum.modules.sample.domain.entities.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {

    Page<Group> findByNameAndSlug(String name, String slug, Pageable pageable);

    Group findByName(String name);
}
