package ro.wizadi.flightforum.modules.sample.web.controllers;

import org.springframework.context.MessageSource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.wizadi.flightforum.modules.sample.domain.entities.Group;
import ro.wizadi.flightforum.modules.sample.service.GroupServiceImpl;

import java.time.ZoneId;
import java.util.Locale;

@Controller
@RequestMapping("/groups")
public class GroupsController {

    private final GroupServiceImpl groupService;
    private final MessageSource messageSource;

    public GroupsController(GroupServiceImpl groupService, MessageSource messageSource)
    {
        this.groupService = groupService;
        this.messageSource = messageSource;
    }

    @GetMapping("nameAndSlug")
    public @ResponseBody
    Iterable<Group> getByNameAndSlug(@RequestParam String name, @RequestParam String slug, Pageable pageable)
    {
        return groupService.getGroups(name, slug, pageable);
    }

    @GetMapping("locale")
    @ResponseBody
    public String getLocale(Locale locale, ZoneId clientZoneId)
    {

        String timezone = clientZoneId.normalized().getId();
        String greeting = messageSource.getMessage("greeting", null, locale);


        return String.format("Got language %s, country %s, timezone %s,  message is: %s",
                locale.getLanguage(), locale.getDisplayCountry(), timezone, greeting);
    }
}
