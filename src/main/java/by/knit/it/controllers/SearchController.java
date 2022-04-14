package by.knit.it.controllers;

import by.knit.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class SearchController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public String searchUsers (@RequestParam("userSearch")String userSearch, Model model){
        //считали параметры с юзерпоиска,
        // далее идем в Репозиторийи создаем метод для поиска юзеров
        //далее в Юзерсервис и там пишем метод
        model.addAttribute("usersList", userService.searchUserUsernameByInputText(userSearch));
        return "users";

    }
}



