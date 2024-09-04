package kg.mega.building_materials_store_v1.service;

import kg.mega.building_materials_store_v1.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> findById(Long id);
    List<Order> findAll();
    Order update(Order order);
    void delete(Long id);
}


