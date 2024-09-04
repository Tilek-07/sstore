package kg.mega.building_materials_store_v1.mapper;

import kg.mega.building_materials_store_v1.models.Category;
import kg.mega.building_materials_store_v1.models.Product;
import kg.mega.building_materials_store_v1.models.dto.CategoryDto;
import kg.mega.building_materials_store_v1.models.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mappings({
        @Mapping(source = "categoryName", target = "category.name"),
        @Mapping(source = "storeId", target = "store.id")})
    Product toProduct(ProductDto productDto);

    @Mappings({
        @Mapping(source = "category.name", target = "categoryName"),
        @Mapping(source = "store.id", target = "storeId")})
    ProductDto toProductDto(Product product);

    List<Product> toProductList(List<ProductDto> productDtoList);

    List<ProductDto> toProductDtoList(List<Product> productList);
}

