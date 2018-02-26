package ro.wizadi.flightforum.modules.sample.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import ro.wizadi.flightforum.container.configuration.properties.AppConfiguration;

@RestController
@EnableConfigurationProperties(AppConfiguration.class)
public class HomeController {

    @Autowired
    private Environment env;

    @Autowired
    private AppConfiguration appConfiguration;

    @RequestMapping("/")
    public String home() {
        return "The Home hello2";
    }

    @RequestMapping("/props")
    public String prop(@RequestParam("prop") String prop) {
        return env.getProperty(prop);
    }

    @RequestMapping(value="/props/{prop}", method=RequestMethod.GET)
    public String props(@PathVariable String prop) {
        return "hit " + prop;
    }

    @RequestMapping("/config")
    public String config() throws JsonProcessingException {

        System.out.println("hello!");

        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(appConfiguration);
    }
}
