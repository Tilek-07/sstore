package kg.mega.building_materials_store_v1.service;

import kg.mega.building_materials_store_v1.exception.CategoryNotFoundException;
import kg.mega.building_materials_store_v1.mapper.CategoryMapper;
import kg.mega.building_materials_store_v1.models.Category;
import kg.mega.building_materials_store_v1.models.Product;
import kg.mega.building_materials_store_v1.models.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void saveProduct(ProductDto productDto) throws CategoryNotFoundException;
    Product getById(Long id);
    ProductDto findById(Long id);
//    List<ProductDto> getProductsByCategoryName(String categoryName);
    List<Product> findAll();
    Product update (Product product);
    void delete (Long id);
}
