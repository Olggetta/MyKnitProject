package by.knit.it.repository;


import by.knit.it.entity.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserPostRepository extends JpaRepository<UserPost, String> {

}