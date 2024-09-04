package kg.mega.building_materials_store_v1.controller;

import kg.mega.building_materials_store_v1.models.Product;
import kg.mega.building_materials_store_v1.models.Store;
import kg.mega.building_materials_store_v1.models.dto.ProductDto;
import kg.mega.building_materials_store_v1.models.dto.StoreDto;
import kg.mega.building_materials_store_v1.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores")
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/save")
    public void save(@RequestBody StoreDto storeDto){
        storeService.save(storeDto);
    }

    @GetMapping("/findAll")
    public List<Store> findAll(){
        return storeService.findAll();
    }

    @PutMapping("/update")
    public Store update(@RequestBody Store store){
        return storeService.update(store);}

    @DeleteMapping("/delete")
    public void delete(@PathVariable Long id){
        storeService.delete(id);
    }
}
