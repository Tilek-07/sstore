package kg.mega.building_materials_store_v1.repository;

import kg.mega.building_materials_store_v1.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
