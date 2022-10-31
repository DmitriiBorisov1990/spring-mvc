package by.borisov.springweb.controller;

import by.borisov.springweb.dto.UserDto;
import by.borisov.springweb.path.UrlPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(UrlPath.API + UrlPath.USER)
public class UserController {

    @GetMapping
    public String getPage(Model model, @RequestParam(value = "id",required = false) Long id,UserDto userDto) {
        //model.addAttribute("user", UserDto.of(id, "Ivan"));
        model.addAttribute("user", userDto);
        return "user";
    }

    @GetMapping("/{id}")
    public String getUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", UserDto.of(id,"Ivan"));
        return "user";
    }
}
