package kg.mega.building_materials_store_v1.controller;

import kg.mega.building_materials_store_v1.models.Order;
import kg.mega.building_materials_store_v1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/findAll")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/findById")
    public Optional<Order> findById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @DeleteMapping("/deleteById")
    public void delete(@PathVariable Long id){
        orderService.delete(id);
    }
}
