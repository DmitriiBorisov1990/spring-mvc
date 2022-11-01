package by.borisov.springweb.controller.hellper;

import by.borisov.springweb.exception.DaoException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerHelper {

    @ExceptionHandler(DaoException.class)
    public String error(Model model, DaoException exception) {
        model.addAttribute("message", exception.getMessage());
        return "error";
    }
}
