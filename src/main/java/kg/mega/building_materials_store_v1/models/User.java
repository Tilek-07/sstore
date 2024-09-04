package kg.mega.building_materials_store_v1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table (name = "tb_user")
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;
    @ManyToOne
    private Store store;
    @OneToMany
    private List<Order> orders;
    @ManyToMany
    @JoinTable(name = "tb_user_roles",
            joinColumns = {@JoinColumn(name = "user_id")
            },inverseJoinColumns = {
            @JoinColumn(name = "role_id")
    })
    private Set<Role> roles;
}


