package by.knit.it.controllers;


import by.knit.it.entity.User;
import by.knit.it.enums.StatusEnums;
import by.knit.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

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

        @GetMapping("/delete/{id}")
        public String deleteUser(@PathVariable("id") String id) {
            // достаем id через PathVariable и запихиваем в id
            userService.deleteUserById(id);
            //вызываем userService.deleteUserById-т образом мы удаляем Usera по его id
            return "redirect:/admin";//и возращаем нас на страницу Админа
        }

        @GetMapping("/block/{id}")
        public String blockUser(@PathVariable("id") String id) {
            userService.updateUserStatusById(StatusEnums.BLOCKED.name(), id);
            return "redirect:/admin";
        }
    @GetMapping("/unblock/{id}")
    public String unblockUser(@PathVariable("id") String id) {
        userService.updateUserStatusById(StatusEnums.ACTIVE.name(), id);
        return "redirect:/admin";
        //нам не будут выводится в списке пользователи, к-ые заблокированы
    }
    }

