package by.knit.it.controllers;

import by.knit.it.entity.User;
import by.knit.it.service.TopicService;
import by.knit.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes({"userId", "role"})
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;


    @GetMapping("/topics") //выводит страницу
    public String showPageWithListOfTopics(Model model) {
        model.addAttribute("topicsList", topicService.getAllTopics());
        model.addAttribute("thisIsCreationTopicStage", false);
        return "topics_page";
    }

    @GetMapping("/create-topic")
    public String showPageForCreatingTopic(Model model) {
        model.addAttribute("thisIsCreationTopicStage", true);
        //thisIsCreationTopicStag - видоизменяет возращаемую страницу
        //как только мы создадим поле для обсуждения,появится возможность заполнить данные
        return "topics_page";
    }

    @PostMapping("/create-topic")
    public String createTopic(
            @RequestParam("topicName") String topicName,
            @RequestParam("topicMessage") String topicMessage,
            Model model
    ) {
        Optional<User> author = userService.getUserById(String.valueOf(model.getAttribute("userId")));
        topicService.save(
                author.get().getId(),
                author.get().getUsername(),
                topicName,
                topicMessage);
        return "redirect:/topics";
    }

    @GetMapping("/topic/{id}")
    public String showSingleTopicPage(@PathVariable("id") String id, Model model) {
        model.addAttribute("topic", topicService.getTopicById(id));
        return "topic_page";
    }
}

