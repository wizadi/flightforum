package ro.wizadi.flightforum.modules.sample.web.controllers;

import org.springframework.context.MessageSource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.wizadi.flightforum.modules.sample.domain.entities.Group;
import ro.wizadi.flightforum.modules.sample.service.GroupServiceImpl;

import javax.validation.constraints.NotNull;
import java.time.ZoneId;
import java.util.Locale;

@Validated
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

    @GetMapping("{id}")
    public @ResponseBody Group findOne(@PathVariable Long id) {
        return groupService.findOne(id);
    }

    @GetMapping("validation")
    public @ResponseBody Group findByName(@RequestParam @NotNull String name) {
        return groupService.findByName(name);
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

    @PostMapping("")
    public @ResponseBody Group create() {
        return groupService.create("Test", "test");
    }
}
