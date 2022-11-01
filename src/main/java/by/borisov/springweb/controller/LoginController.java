package by.borisov.springweb.controller;

import by.borisov.springweb.dto.Gender;
import by.borisov.springweb.dto.LoginDto;
import by.borisov.springweb.exception.DaoException;
import by.borisov.springweb.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static by.borisov.springweb.path.UrlPath.API;
import static by.borisov.springweb.path.UrlPath.LOGIN;

@Controller
@RequestMapping(API + LOGIN)
@RequiredArgsConstructor
@SessionAttributes({"currentUser"})
public class LoginController {

    private final LoginService loginService;

    @ModelAttribute
    public void setReferences(Model model) {
        model.addAttribute("gender", Gender.values()[0]);
    }

    @GetMapping
    public String getLogin() {
        return "login";
    }

    @GetMapping("/test")
    public String getErrorPage() {
        if(true) {
            throw new DaoException("Oopss");
        }
        return "login";
    }

    @PostMapping
    public String doLogin(LoginDto loginDto) {
        return loginService.login(loginDto)
                .map(user -> "redirect:/api/v1/user/" + user.getId())
                .orElse("redirect:/api/v1/login");
    }
}
