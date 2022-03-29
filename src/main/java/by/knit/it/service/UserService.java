package by.knit.it.service;


import by.knit.it.encoder.PasswordEncoder;
import by.knit.it.entity.User;
import by.knit.it.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;//создает доступ к UserRepository

    private void save(User user) {
        userRepository.save(user);
    }
    public void save(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        user.setRole(role);
        user.setPassword(PasswordEncoder.encodePassword(password));
        save(user);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll(); // создаем метод для вывода зарегистрировавшихся пользователей
    }

    public User getUserById(String id) { // создаем метод для вывода пользователей по Id
        return userRepository.getById(id);
    }
}