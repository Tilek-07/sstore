package kg.mega.building_materials_store_v1.models;

import jakarta.persistence.*;
import kg.mega.building_materials_store_v1.enums.ImageType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_images")
@Getter
@Setter
@RequiredArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    @ManyToOne
//    @JsonIgnore
    private Product product;
    @ManyToOne
//    @JsonIgnore
    private User user;
    private ImageType type;
    private Boolean isActive;
}
