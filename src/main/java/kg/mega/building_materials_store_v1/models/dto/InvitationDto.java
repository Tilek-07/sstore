package kg.mega.building_materials_store_v1.models.dto;

import kg.mega.building_materials_store_v1.models.Role;
import lombok.Data;

import java.util.Set;

@Data
public class InvitationDto {
    private String email;
    private Set<Long> roleIds;
    private Long storeId; // ID филиала
}
