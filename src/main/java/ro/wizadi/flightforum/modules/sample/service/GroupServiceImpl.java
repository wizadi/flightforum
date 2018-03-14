package ro.wizadi.flightforum.modules.sample.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ro.wizadi.flightforum.modules.sample.domain.entities.Group;
import ro.wizadi.flightforum.modules.sample.domain.repositories.GroupRepository;

@Service
@Validated
@Transactional
public class GroupServiceImpl implements GroupService {


    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Page<Group> getGroups(String name, String slug, Pageable pageable) {
        return groupRepository.findByNameAndSlug(name, slug, pageable);
    }

    public Group findOne(Long id)
    {
        return  groupRepository.findOne(id);
    }

    public Group findByName(String name) {
        return groupRepository.findByName(name);
    }

    public Group create(String name, String slug) {
        Group group = new Group();
        group.setName(name);
        group.setSlug(slug);

        return groupRepository.save(group);
    }
}
