package kg.mega.building_materials_store_v1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
//import java.util.List;
import org.springframework.stereotype.Service;

@Entity
@Getter
@Setter
@Table (name = "tb_product")
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne                              //(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne                              //(cascade = CascadeType.PERSIST)
    private Store store ;
    private String name;
    private Double price;
    private Integer quantity;
//    @OneToMany
//    private List<OrderItem> orderItems;
}



