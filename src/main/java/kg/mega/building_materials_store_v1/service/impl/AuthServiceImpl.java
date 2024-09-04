package kg.mega.building_materials_store_v1.service.impl;

import kg.mega.building_materials_store_v1.models.dto.RegistrationRequestDto;
import kg.mega.building_materials_store_v1.service.AuthService;
import kg.mega.building_materials_store_v1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
//    private final UserService userService;
//    @Override
//    public RegistrationRequestDto registrateUser(RegistrationRequestDto registrationRequestDto) {
//        if (!registrationRequestDto.getPassword().equals(registrationRequestDto.getConfirmPassword())){
//            System.out.println("Введенные пароли несовпадают!");
//            return null;
//        } else if (userService.findByName(registrationRequestDto.getFirstName())()) {
//            System.out.println(String.format("Ползователя с логином '%s' уже существует!",registrationRequestDto.getUsername()));
//            return null;
//        }
//        User user = new User(registrationRequestDto);
//        user.setActivationCode((generateRandomActivationCode()));
//        userService.saveUser(user);
//        mailService.sendSimpleMessage( user.getEmail(), "Код аквифации аккаунта", "Ваш код активации аккаунта " + user.getActivationCode());
//
//        return authenticate(new AuthRequestDto(new User(registrationRequestDto)));
//    }
}
