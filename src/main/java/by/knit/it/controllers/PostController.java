package by.knit.it.controllers;


import by.knit.it.entity.User;
import by.knit.it.entity.UserPost;
import by.knit.it.service.UserPostService;
import by.knit.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes({"userId", "role"})
public class PostController {

    @Autowired
    private UserPostService userPostService;
    @Autowired
    private UserService userService;

    @GetMapping("/news")
    public String showUsersPostsPage(Model model) {
        List<UserPost> userPostsList = userPostService.getMessagesList();
        model.addAttribute("messagesList", userPostsList);
        return "users_posts_page";
    }

    @PostMapping("/news")
    public String saveUserMessage(@RequestParam("userMessage") String message, Model model) {
        //считали UserMessage, положили в переменную messege
        Optional<User> user = userService.getUserById(String.valueOf(model.getAttribute("userId")));
        userPostService.save(message, user.get().getId(), user.get().getUsername());
        return "redirect:/news";
    }
}