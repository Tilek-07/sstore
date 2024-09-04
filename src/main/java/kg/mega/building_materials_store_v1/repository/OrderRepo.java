package kg.mega.building_materials_store_v1.repository;

import kg.mega.building_materials_store_v1.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long id);
}
