package kg.mega.building_materials_store_v1.service.impl;

import kg.mega.building_materials_store_v1.mapper.ProductMapper;
import kg.mega.building_materials_store_v1.models.Product;
import kg.mega.building_materials_store_v1.models.dto.ProductDto;
import kg.mega.building_materials_store_v1.repository.ProductRepo;
import kg.mega.building_materials_store_v1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;



    @Override
    public void saveProduct(ProductDto productDto) {
        Product product = ProductMapper.INSTANCE.toProduct(productDto);   // Преобразование DTO в сущность
        Product savedProduct = productRepo.save(product);                // Сохранение продукта в базе данных
//        ProductMapper.INSTANCE.toProductDto(savedProduct);            // Преобразование сохраненной сущности обратно в DTO
    }

    @Override
    public Product getById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public ProductDto findById(Long id) {
        return ProductMapper.INSTANCE.toProductDto(productRepo.findById(id).orElse(null));
    }

//    @Override
//    public List<ProductDto> getProductsByCategoryName(String categoryName) {
//        return productRepo.findAllByCategoryName(categoryName).stream()
//                .map(productMapper::toProductDto)
//                .collect(Collectors.toList());
//    }


    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Long id) {
        if (productRepo.existsById(id)){
            productRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("Product not found whith id:" + id);
        }

    }
}
