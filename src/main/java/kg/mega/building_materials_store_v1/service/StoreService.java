package kg.mega.building_materials_store_v1.service;

import kg.mega.building_materials_store_v1.models.Store;
import kg.mega.building_materials_store_v1.models.dto.StoreDto;

import java.util.List;
import java.util.Optional;

public interface StoreService {
    void save(StoreDto storeDto);
    List<Store> findAll();
    Optional<Store> findByName(String name);
    Store update(Store store);
    void delete(Long id);
}
