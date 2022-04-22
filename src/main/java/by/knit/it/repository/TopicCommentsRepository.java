package by.knit.it.repository;

import by.knit.it.entity.TopicComments;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface TopicCommentsRepository extends JpaRepository<TopicComments, String> {

    List<TopicComments> findByTopicId(String topicId); //Берем List топиков и find- ищет by- по TopicId
}
