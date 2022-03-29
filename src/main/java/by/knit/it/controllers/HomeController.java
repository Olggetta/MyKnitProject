package by.knit.it.controllers;

import by.knit.it.entity.User;
import by.knit.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes({"userId", "role"}) //анатация которая,подключает атрибуты сессии.

public class HomeController {

    @Autowired
    private UserService userService;//создает доступ к UserService

    @GetMapping("/user/{id}")//этот метод сработает,если мы перейдем по адресу /user.
    // т.е по этот метод будет работать по адресу указанному в скобках
    public String showHomePage(@PathVariable("id") String id, Model model) {
        //с помощью PathVariable мы можем достать Id c адресной строки
        String username = userService.getUserById(id).getUsername();// достаем User по Id.
        // Для этого нам нужно написать в UserService метод getUserById и применяем его.
        //getUserName-достали Usera
        model.addAttribute("username", username);// и закинули его (Usera) на страничку
        return "home_page";
    }

    @GetMapping("/users") //создаем список(лист) всех пользователей,которые зарегистрировались
    public String showAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();// идем в UserServise и создаем там метод,
        //который будет выводить всех зарегистрированных пользователей(getAllUsers)
        model.addAttribute("usersList", userList);//добавляем атрибут и его название
        return "users";// возвращаем страницу(и идем ее создавать в JSP)
    }
}
