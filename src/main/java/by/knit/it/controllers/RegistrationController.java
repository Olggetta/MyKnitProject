package by.knit.it.controllers;

import by.knit.it.enums.RoleEnums;
import by.knit.it.service.UserService;
import by.knit.it.validation.AuthorizeValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

// Контроллеры соединяют сайт с базой данных, путем передачи ПОСТ
@Controller
@SessionAttributes({"userId", "role"})//анатация которая,подключает атрибуты сессии.
// userId,role-это атрибуты
public class RegistrationController {

    private UserService userService;//создает доступ к UserService
    private AuthorizeValidation authorizeValidation;//создает доступ к AuthorizeValidation

    @Autowired
    public RegistrationController(UserService userService, AuthorizeValidation authorizeValidation) {
        this.userService = userService;
        this.authorizeValidation = authorizeValidation;
    }

    @GetMapping("/registration")//контроллер, который рисует страницу
    public String showRegistrationPage() {
        return "register_page";
    }

    @PostMapping("/registration")//контроллер, который принимает уже введенные данные на страницу
    // и принимает пост -запрос
    public String checkInputData(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model
    ) {
        String error = authorizeValidation.validateRegistrationData(username, password);

        if (!error.isEmpty()) {
            model.addAttribute("error", error);
            return "register_page";
        } else {
            userService.save(username, password, RoleEnums.USER.name());
            return "redirect:/"; // redirect -это перенаправление на страницы
        }
    }
}