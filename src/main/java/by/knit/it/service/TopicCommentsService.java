package by.knit.it.service;

import by.knit.it.entity.TopicComments;
import by.knit.it.repository.TopicCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service //чтобы спринг автоматически создавал нужные методы( вместо new class)
public class TopicCommentsService {

    @Autowired
    private TopicCommentsRepository repository;

    public void save(
            String topicId,
            String authorId,
            String authorUsername,
            String comment
    ) {
        TopicComments topicComments = new TopicComments();
        topicComments.setAuthorId(authorId);
        topicComments.setAuthorUsername(authorUsername);
        topicComments.setTopicId(topicId);
        topicComments.setComment(comment);
        topicComments.setCreatedDate(LocalDateTime.now());
        save(topicComments);
    }

    private void save(TopicComments topicComments) {
        repository.save(topicComments);//метод, который все это сохраняет
    }

    public List<TopicComments> getCommentsListByTopicId(String topicId) {
        return repository.findByTopicId(topicId);// метод для контроллера
    }

    public void deleteCommentById(String id) {
        repository.deleteById(id);
    }
}
