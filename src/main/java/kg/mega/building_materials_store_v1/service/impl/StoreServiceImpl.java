package kg.mega.building_materials_store_v1.service.impl;

import kg.mega.building_materials_store_v1.mapper.ProductMapper;
import kg.mega.building_materials_store_v1.mapper.StoreMapper;
import kg.mega.building_materials_store_v1.models.Product;
import kg.mega.building_materials_store_v1.models.Store;
import kg.mega.building_materials_store_v1.models.User;
import kg.mega.building_materials_store_v1.models.dto.StoreDto;
import kg.mega.building_materials_store_v1.repository.StoreRepo;
import kg.mega.building_materials_store_v1.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StoreRepo storeRepo;
    @Override
    public void save(StoreDto storeDto) {
//        Store newStore = null;
        if (findByName(storeDto.getName()).isPresent()) {
            System.out.println("This branch of the store already exists!");
        }
        else {
            Store store = StoreMapper.INSTANCE.toStore(storeDto);   // Преобразование DTO в сущность
            Store savedStore = storeRepo.save(store);                // Сохранение нового магазина в базе данных
//            StoreMapper.INSTANCE.toStoreDto(savedStore);              // Преобразование сохраненной сущности обратно в DTO
        }
    }

    @Override
    public List<Store> findAll() {
        return storeRepo.findAll();
    }

    @Override
    public Optional<Store> findByName(String name) {
        return storeRepo.findByName(name);
    }

    @Override
    public Store update(Store store) {
        return null;
    }

    @Override
    public void delete(Long id) {
        storeRepo.deleteById(id);
    }
}
