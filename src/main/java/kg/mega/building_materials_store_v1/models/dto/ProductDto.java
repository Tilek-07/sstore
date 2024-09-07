package kg.mega.building_materials_store_v1.models.dto;

import lombok.Data;

@Data
public class ProductDto {
    private CategoryDto category;
    private StoreDto store;
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


