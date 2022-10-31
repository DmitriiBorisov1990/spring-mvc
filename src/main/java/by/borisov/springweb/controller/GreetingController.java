package by.borisov.springweb.controller;

import by.borisov.springweb.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static by.borisov.springweb.path.UrlPath.API;
import static by.borisov.springweb.path.UrlPath.GREETING;

@Controller
@RequestMapping(value = API + GREETING)
public class GreetingController {

    /*@GetMapping
    public ModelAndView greeting () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/greeting");
        return modelAndView;
    }*/

    @GetMapping
    public String greeting(Model model) {
        model.addAttribute("user", UserDto.of(1L, "Dima"));
        return "greeting";
    }
}
