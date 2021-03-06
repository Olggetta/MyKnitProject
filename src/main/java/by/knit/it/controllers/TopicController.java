package by.knit.it.controllers;

import by.knit.it.entity.User;
import by.knit.it.service.TopicCommentsService;
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

    private final TopicService topicService;
    private final UserService userService;
    private final TopicCommentsService topicCommentsService;


    @Autowired
    public TopicController(TopicService topicService, UserService userService, TopicCommentsService topicCommentsService) {
        this.topicService = topicService;
        this.userService = userService;
        this.topicCommentsService = topicCommentsService;
    }


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
    public String showSingleTopicPage(@PathVariable("id") String topicId, Model model) {
        model.addAttribute("topic", topicService.getTopicById(topicId));
        model.addAttribute("comments", topicCommentsService.getCommentsListByTopicId(topicId));
        return "topic_page";
    }
}

