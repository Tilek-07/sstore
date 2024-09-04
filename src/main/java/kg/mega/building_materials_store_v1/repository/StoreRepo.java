package kg.mega.building_materials_store_v1.repository;

import kg.mega.building_materials_store_v1.models.Store;
import kg.mega.building_materials_store_v1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepo extends JpaRepository<Store, Long> {
    Optional<Store> findByName(String name);
}
