package kg.mega.building_materials_store_v1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_store")
@RequiredArgsConstructor
public class Store {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private Boolean status;
    @OneToMany
    private List<Product> products;
//    @OneToMany
//    private List<Order> orders;
}
