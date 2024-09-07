package kg.mega.building_materials_store_v1.controller;

import kg.mega.building_materials_store_v1.exception.CategoryNotFoundException;
import kg.mega.building_materials_store_v1.models.Product;
import kg.mega.building_materials_store_v1.models.dto.ProductDto;
import kg.mega.building_materials_store_v1.service.FileStorageService;
import kg.mega.building_materials_store_v1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final FileStorageService fileStorageService;

    @PostMapping("/save")
    public void saveProduct(@RequestBody ProductDto productDto) throws CategoryNotFoundException {
        productService.saveProduct(productDto);
    }

    @GetMapping("/findById")
    public ProductDto findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @PutMapping("/update")
    public Product update(@RequestBody Product product){
        return productService.update(product);}

    @PostMapping("/add_image")
    public void addImage(@RequestParam("file")MultipartFile file, @RequestParam Long id){
        fileStorageService.addImageToProduct(file, id);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }
}


