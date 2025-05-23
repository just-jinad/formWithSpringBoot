package com.example.myFirstApp.repo;
import com.example.myFirstApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    // This interface will automatically provide CRUD operations for the User entity.
    // You can add custom query methods here if needed.

    Optional<User> findByEmail(String email);
 
    default User updateUser(User user) {
        return save(user);
    }
}
