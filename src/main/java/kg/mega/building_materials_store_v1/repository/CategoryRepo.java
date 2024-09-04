package kg.mega.building_materials_store_v1.repository;

import kg.mega.building_materials_store_v1.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
