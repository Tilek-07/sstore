package kg.mega.building_materials_store_v1.repository;

import kg.mega.building_materials_store_v1.enums.ImageType;
import kg.mega.building_materials_store_v1.models.Image;
import kg.mega.building_materials_store_v1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepo extends JpaRepository<Image, Long> {
    Optional<Image> findByUser(User user);
}
