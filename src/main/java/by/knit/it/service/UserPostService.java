package by.knit.it.service;


import by.knit.it.entity.UserPost;
import by.knit.it.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserPostService {

    @Autowired
    private UserPostRepository userPostRepository;

    public void save(String text, String ownerId, String ownerNickname) {
        UserPost userPost = new UserPost();
        userPost.setOwnerId(ownerId);
        userPost.setOwnerNickname(ownerNickname);
        userPost.setText(text);
        userPost.setPostTime(LocalDateTime.now());
        save(userPost);
    }

    private void save(UserPost post) {
        userPostRepository.save(post);
    }

    public List<UserPost> getMessagesList() {
        return userPostRepository.findAll();
    }
}