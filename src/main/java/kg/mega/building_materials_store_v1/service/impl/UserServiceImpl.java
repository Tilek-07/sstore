package kg.mega.building_materials_store_v1.service.impl;

import kg.mega.building_materials_store_v1.mapper.UserMapper;
import kg.mega.building_materials_store_v1.models.User;
import kg.mega.building_materials_store_v1.models.dto.UserDto;
import kg.mega.building_materials_store_v1.repository.UserRepo;
import kg.mega.building_materials_store_v1.service.RoleService;
import kg.mega.building_materials_store_v1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
//    private final RoleService roleService;
    @Override
    public User saveUser(User user) {
        User newUser = null;
        if (findByEmail(user.getEmail()).isPresent()) {
            System.out.println("User already exists");
        }
        else {
            user.setPassword(user.getPassword());
//            user.setRoles(Set.of(roleService.findByName("CLIENT")));
            newUser = userRepo.save(user);
        }
        return newUser;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public UserDto findById(Long id) {
        return UserMapper.INSTANCE.toDto(userRepo.findById(id).orElse(null));
    }

    @Override
    public User getById(Long id) {
        if (userRepo.findById(id).isEmpty()){
            System.out.println("User not found!");}
        else {
            return userRepo.findById(id).get();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(User user) {
        Optional<User> existingUserOpt = findByEmail(user.getEmail());
        if (existingUserOpt.isEmpty()) {
            System.out.println("User not found for update!");
        }
        User existingUser = existingUserOpt.get();
        updateUserData(existingUser, user);
        return userRepo.save(existingUser);
    }

    @Override
    public void updateUserData(User existingUser, User updatedUser) {
        if (updatedUser.getPassword() != null){
            existingUser.setPassword(updatedUser.getPassword());
        }
        if (updatedUser.getEmail() != null){
            existingUser.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getAddress() != null){
            existingUser.setAddress(updatedUser.getAddress());
        }
        if (updatedUser.getFirstName() != null){
            existingUser.setFirstName(updatedUser.getFirstName());
        }
        if (updatedUser.getLastName() != null){
            existingUser.setLastName(updatedUser.getLastName());
        }
        if (updatedUser.getRoles() != null){
            existingUser.setRoles(updatedUser.getRoles());
        }
    }

//    2-ой вариант обновление данных юзера
//    public ResponseEntity<UserDto> update(UserDto userDto) {
//        if (userRepository.existsById(userDto.getId())) {
//            User user = userMapper.toEntity(userDto);
//            User updatedUser = userRepository.save(user);
//            return ResponseEntity.ok(userMapper.toDto(updatedUser));
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }

    @Override
    public String delete(Long id) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isEmpty()){
            return "User not found with this ID!";
        }
        else{
            userRepo.deleteById(id);
            return "User deleted successfully!";
        }
    }

}
