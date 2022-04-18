package by.knit.it.controllers;

import by.knit.it.entity.User;

import by.knit.it.service.TopicCommentsService;
import by.knit.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import java.util.Optional;

@Controller
@SessionAttributes("userId")
public class TopicCommentsController {
    @Autowired
    private TopicCommentsService topicCommentsService; //считываем Топиккомментсервис

    @Autowired
    private UserService userService;// считываем методы с Юзерсервиса

    @PostMapping("/add-comment/{id}")
    public String saveComment(
            @PathVariable("id") String topicId,//PathVariable -забираем id и кладем его в переменную
            @RequestParam("comment") String comment,//считываем комментарий
            Model model)
    {

        Optional<User> user = userService.getUserById(String.valueOf(model.getAttribute("userId")));
        topicCommentsService.save(topicId, user.get().getId(), user.get().getUsername(), comment);
        //сохранили комментарий и возвращаем страницуу топика
        return "redirect:/topic/" + topicId;
    }

    //удаление комментария
    @PostMapping("/topic/{id}")
    public String deleteComment(
            @PathVariable("id") String topicId,//PathVariable -забираем id и кладем его в переменную
            @RequestParam("deleteComment") String commentId) //считываем удаление комментария
    {
        topicCommentsService.deleteCommentById(commentId);
        return "redirect:/topic/" + topicId;// возвращаем страницу топика
    }
}