package by.knit.it.repository;


import by.knit.it.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.Optional;


@Transactional
public interface UserRepository extends JpaRepository<User, String> {

    @Query("from User where username =:username")
    Optional<User> findUserByUsername(@Param("username") String username);

    @Query("update User set status =:status where id =:id")
    @Modifying //ставится над теми методами, к-ые что-то меняют в БД
    void updateUserStatusById(@Param("status") String status, @Param("id") String id);

    //добавляем фото
    @Query("update User set pathToImage =:path where id =:id")
    @Modifying
    void updateUserPathToImageById(@Param("path") String path, @Param("id") String id);
}


