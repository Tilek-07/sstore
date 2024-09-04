package kg.mega.building_materials_store_v1.service;

import kg.mega.building_materials_store_v1.models.User;
import kg.mega.building_materials_store_v1.models.dto.UserDto;
//import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser (User user);
    Optional<User> findByEmail(String email);
    UserDto findById(Long id);
    User getById(Long id);
    List<User> findAll();
    User updateUser (User user);
    void updateUserData(User existingUser, User updatedUser);
    String delete (Long id);
}
