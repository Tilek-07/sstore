package kg.mega.building_materials_store_v1.models.dto;

import jakarta.persistence.ManyToOne;
import kg.mega.building_materials_store_v1.models.Category;
import kg.mega.building_materials_store_v1.models.Product;
import kg.mega.building_materials_store_v1.models.Store;
import lombok.Data;

@Data
public class ProductDto {
    private String categoryName;
    private Long storeId;
    private String name;
    private Double price;
    private Integer quantity;

//    public ProductDto(Product product) {
//        this.categoryName = product.getCategory() != null ? product.getCategory().getName() : null;
//        this.storeId = product.getStore() != null ? product.getStore().getId() : null;
//        this.name = product.getName();
//        this.price = product.getPrice();
//        this.quantity = product.getQuantity();
//    }

    public ProductDto() {
    }
}


