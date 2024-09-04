package kg.mega.building_materials_store_v1.mapper;

import kg.mega.building_materials_store_v1.models.Store;
import kg.mega.building_materials_store_v1.models.dto.StoreDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoreMapper {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    StoreDto toStoreDto(Store store);
    Store toStore(StoreDto storeDto);
}
