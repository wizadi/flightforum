package ro.wizadi.flightforum.modules.sample.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import ro.wizadi.flightforum.modules.sample.domain.entities.Group;

import javax.validation.constraints.Size;

@Validated
public interface GroupService {

    Page<Group> getGroups(@Size(min = 4)String name, String slug, Pageable pageable);

}
