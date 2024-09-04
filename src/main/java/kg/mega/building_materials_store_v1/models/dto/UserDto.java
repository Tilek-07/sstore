package kg.mega.building_materials_store_v1.models.dto;

import kg.mega.building_materials_store_v1.models.User;
import lombok.Data;

@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.address = user.getAddress();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public UserDto() {}
}
