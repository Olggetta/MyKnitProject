package by.knit.it.controllers;

import by.knit.it.entity.User;
import by.knit.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
@SessionAttributes({"userId", "role"}) //анатация которая,подключает атрибуты сессии.

public class HomeController {

    @Autowired
    private UserService userService;//создает доступ к UserService

    @GetMapping("/user/{id}")//этот метод сработает,если мы перейдем по адресу /user.
    // т.е по этот метод будет работать по адресу указанному в скобках
    //getMapping- передает данные через адресную строку, а PostMapping -это тело запроса.
    //Get- передает данные в адресную строку(строка вверху, типо localhost/user ,
    // а post -на страницу (сами таблички логин,пароль и тп)

    public String showHomePage(@PathVariable("id") String id, Model model) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            String flag = "thisIsMainUser";
            if (checkIfThisMainUser(id, model.getAttribute("userId").toString())) {
                model.addAttribute(flag, true);
            } else {
                model.addAttribute(flag, false);
            }
            model.addAttribute("image", user.get().getPathToImage());
            model.addAttribute("username", user.get().getUsername());
        } else {
            return "redirect:/registration";
        }
        return "home_page";
    }


    @GetMapping("/users") //создаем список(лист) всех пользователей,которые зарегистрировались
    public String showAllUsers(Model model) {
        ArrayList<User> userList =
                (ArrayList<User>) userService.getAllUsers()
                        .stream()
                        .filter(i -> !i.getUsername().equals("ADMIN"))
                        .collect(Collectors.toList());

        model.addAttribute("usersList", userList);//добавляем атрибут и его название
        return "users"; // возвращаем страницу(и идем ее создавать в JSP)
    }

    private boolean checkIfThisMainUser(String pathId, String currentId) {
        return pathId.equals(currentId);
    }
}


// List<User> userList = userService.getAllUsers();// идем в UserServise и создаем там метод,
//        //который будет выводить всех зарегистрированных пользователей(getAllUsers)


//    @GetMapping("/user/{id}")
//    public String showHomePage(@PathVariable("id") String id, Model model) {
//


// String username = userService.getUserById(id).getUsername();// достаем User по Id.
// Для этого нам нужно написать в UserService метод getUserById и применяем его.
//getUserName-достали Usera

// model.addAttribute("username", username); // и закинули его (Usera) на страничку
// return "home_page";
