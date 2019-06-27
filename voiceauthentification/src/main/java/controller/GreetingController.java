package controller;

import model.repos.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ui.User;

import java.util.Map;


@Controller
public class GreetingController {
    @Autowired
    private IUserRepo userRepository;

    @GetMapping("/greeting") // Map ONLY GET Requests
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World")
                    String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<User> users = userRepository.findAll();
        model.put("users", users);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name, @RequestParam String email, Map<String, Object> model) {
        User user = new User(name, email);
        userRepository.save(user);
        Iterable<User> users = userRepository.findAll();
        model.put("users", users);
        return "main";
    }
}