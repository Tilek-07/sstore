package kg.mega.building_materials_store_v1.models.dto;

import lombok.Data;

@Data
public class CompleteRegistrationDto {
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
}
