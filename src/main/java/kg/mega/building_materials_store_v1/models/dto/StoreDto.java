package kg.mega.building_materials_store_v1.models.dto;

import lombok.Data;

@Data
public class StoreDto {
    private String name;
    private String address;
    private Boolean status;

    public StoreDto() {
    }
}
