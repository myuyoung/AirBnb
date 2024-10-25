package me.changwook.AirBnb.controller;

import lombok.RequiredArgsConstructor;
import me.changwook.AirBnb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "renewal";
    }

    @GetMapping("/renewal")
    public String renewal() {
        return "renewal";
    }
}
