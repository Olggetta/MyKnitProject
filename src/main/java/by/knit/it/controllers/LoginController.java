package by.knit.it.controllers;

import by.knit.it.entity.User;
import by.knit.it.service.UserService;
import by.knit.it.validation.AuthorizeValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Optional;

@Controller
@SessionAttributes({"userId", "role"})//анатация которая,подключает атрибуты сессии.
public class LoginController {

    private UserService userService; //создает доступ к UserService
    private AuthorizeValidation authorizeValidation;//создает доступ к AuthorizeValidation

    @Autowired
    //проверка данных
    public LoginController(UserService userService, AuthorizeValidation authorizeValidation) {
        this.userService = userService;
        this.authorizeValidation = authorizeValidation;
    }

    @GetMapping({"/", "/login"})//контроллер, который рисует страницу
    public String showLoginPage() {
        return "login_page";
    }

    @PostMapping("/login")// контроллер, который принимает уже введенные данные на страницу
    public String checkInputData(
            @RequestParam("username") String username,//считываем данные username
            @RequestParam("password") String password,//считываем данные password
            Model model// позволяет нам додавлять атрибуты
    ) {
        String error = authorizeValidation.validateLoginData(username, password);//делаем проверку,
        // если данные не пустые, то возвращаемся на login_page,
        // если пустые - то перенаправляем на home страницу

        if (!error.isEmpty()) {
            model.addAttribute("error", error);//"error"-название атрибута, error-сам атрибут
            return "login_page";
        } else {

            Optional<User> user = userService.getUserByUsername(username);
            model.addAttribute("userId", user.get().getId());
            model.addAttribute("role", user.get().getRole());
            return "redirect:/user/" + user.get().getId();
        }
    }

}