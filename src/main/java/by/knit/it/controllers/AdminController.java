package by.knit.it.controllers;


import by.knit.it.entity.User;
import by.knit.it.enums.StatusEnums;
import by.knit.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Controller
    @SessionAttributes({"userId", "role"})
    public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String showAdminPanel(Model model) {
        //делаем чтобы в списке пользователя не выводился Админ
        ArrayList<User> userList =
                (ArrayList<User>) userService.getAllUsers()//вызываему Userservice получить всех Userов /
                        // через стрим
                        .stream()
                        //фильтруем Aдмина от остальных пользователей
                        //создаем лямбдно выражение, где i - это один элемент
                        // него мы достаем одного Username и сравниваем с Админом
                        //если не совпадает с Админом, то идет в итоговый список
                        //если совпало, то Админ в коллектор не попадает
                        .filter(i -> !i.getUsername().equals("ADMIN"))
                        .collect(Collectors.toList());

        model.addAttribute("userList", userList);
        return "admin_page";
    }

//вместо BLOCK,UNBLOCK,DELETE - мы написали один метод, который считывает любой из параметров
    @PostMapping("/admin-action")
    public String doAdminAction(HttpServletRequest request) {
        return "redirect:/admin";
    }
}

