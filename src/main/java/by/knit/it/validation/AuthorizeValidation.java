package by.knit.it.validation;

import by.knit.it.encoder.PasswordEncoder;
import by.knit.it.entity.User;
import by.knit.it.enums.StatusEnums;
import by.knit.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class AuthorizeValidation {

    @Autowired
    private UserService userService; //создает доступ к UserService

    public String validateLoginData(String username, String password) {
        String error = "";
        Optional<User> user = userService.getUserByUsername(username);

        if (user == null) {
            error = "User not found"; //существует ли такой пользователь
        } else if (!user.get().getPassword().equals(PasswordEncoder.encodePassword(password))) {
            error = "Incorrect password";
            //если пароль введенный из базы данных не равен введенному паролю,
            // то мы присваеваем Incorrect password
        } else if (user.get().getStatus().equals(StatusEnums.BLOCKED.name())) {
            error = "Account is blocked";//заблокировал ли аккаукнт пользователя
        }
        return error;
    }

    public String validateRegistrationData(
            String username,
            String password
    ) {
        String error = "";

        if (userService.getUserByUsername(username).isPresent()) {
            error = "User already exists";
        }

        return error;
    }
}
