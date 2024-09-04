package kg.mega.building_materials_store_v1.mapper;

import kg.mega.building_materials_store_v1.models.User;
import kg.mega.building_materials_store_v1.models.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity (UserDto userDto);
    UserDto toDto (User user);
}
