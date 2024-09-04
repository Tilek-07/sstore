package kg.mega.building_materials_store_v1.controller;

import kg.mega.building_materials_store_v1.models.User;
import kg.mega.building_materials_store_v1.models.dto.UserDto;
import kg.mega.building_materials_store_v1.service.FileStorageService;
import kg.mega.building_materials_store_v1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final FileStorageService fileStorageService;

    @PostMapping("/save")
    public void saveUser(@RequestBody User user) { // возможен ли отличаться типы методов в сервисах и контроллеров?
        userService.saveUser(user);
    }

    @GetMapping ("findByEmail")
    public Optional<User> findByEmail(@RequestParam String email){
        return userService.findByEmail(email);
    }

    @GetMapping("/findById")
    public UserDto findById(@PathVariable Long id) {
        return userService.findById(id);}

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.findAll();
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        return userService.delete(id);}

    @PostMapping("/add_avatar")
    public void addImage(@RequestParam("file") MultipartFile file, @RequestParam Long id){
        fileStorageService.addUserAvatar(file, id);
    }

}

