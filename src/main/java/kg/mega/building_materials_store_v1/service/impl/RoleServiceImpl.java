package kg.mega.building_materials_store_v1.service.impl;

import kg.mega.building_materials_store_v1.models.Role;
import kg.mega.building_materials_store_v1.repository.RoleRepo;
import kg.mega.building_materials_store_v1.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;
    @Override
    public Role save(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public Role findByName(String name) {
        return roleRepo.findByName(name);
    }
}
