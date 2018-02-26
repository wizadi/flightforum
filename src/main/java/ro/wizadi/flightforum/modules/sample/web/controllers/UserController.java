package ro.wizadi.flightforum.modules.sample.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.wizadi.flightforum.modules.sample.domain.entities.User;
import ro.wizadi.flightforum.modules.sample.service.UserServiceImpl;
import ro.wizadi.flightforum.modules.sample.web.forms.UserForm;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService)
    {
        this.userService = userService;
    }

    @GetMapping("add")
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String email)
    {

        userService.addNewUser(name, email);
        return "Saved";
    }

    @GetMapping("all")
    public @ResponseBody
    Iterable<User> getAllUsers()
    {
        return userService.findAll();
    }

    @PostMapping("")
    public @ResponseBody
    String createUser(@Valid @RequestBody UserForm form)
    {


        return form.toString();
    }

    @GetMapping(value = "new", produces = "application/json")
    public @ResponseBody
    User getNewUser()
    {
        return userService.returnNewUser();
    }
}
