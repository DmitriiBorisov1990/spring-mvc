package by.borisov.springweb.controller;

import by.borisov.springweb.dto.LoginDto;
import by.borisov.springweb.servise.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static by.borisov.springweb.path.UrlPath.API;
import static by.borisov.springweb.path.UrlPath.LOGIN;

@Controller
@RequestMapping(API + LOGIN)
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping
    public String getLogin() {
        return "login";
    }

    @PostMapping
    public String doLogin(LoginDto loginDto) {
        return loginService.login(loginDto)
                .map(user -> "redirect:/api/v1/user/" + user.getId())
                .orElse("redirect:/api/v1/login");
    }
}
