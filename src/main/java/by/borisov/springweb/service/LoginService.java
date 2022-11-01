package by.borisov.springweb.service;

import by.borisov.springweb.dto.LoginDto;
import by.borisov.springweb.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    public Optional<UserDto> login(LoginDto loginDto) {
        return Optional.of(UserDto.builder()
                .id(1L)
                .name(loginDto.getUserName())
                .build());
    }
}
