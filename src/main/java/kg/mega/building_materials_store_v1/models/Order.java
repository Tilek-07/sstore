package kg.mega.building_materials_store_v1.models;

import jakarta.persistence.*;
import kg.mega.building_materials_store_v1.enums.OrderStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_orders")
@RequiredArgsConstructor
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Store store;
    private String receiptNumber;
    @ManyToOne
    private User user;
    private Double finalPrice;
    private OrderStatus status; // Статус заказа (например, "В обработке", "Доставлен", "Отменен")
}
