package kg.mega.building_materials_store_v1.service.impl;

import kg.mega.building_materials_store_v1.models.Order;
import kg.mega.building_materials_store_v1.repository.OrderRepo;
import kg.mega.building_materials_store_v1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;



    @Override
    public Optional<Order> findById(Long id) {
        return orderRepo.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public void delete(Long id) {
        if (orderRepo.existsById(id)) {
            orderRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("Order not found whith id:" + id);
        }
    }

}
