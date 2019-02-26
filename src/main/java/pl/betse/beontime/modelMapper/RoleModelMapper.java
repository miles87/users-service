package pl.betse.beontime.modelMapper;

import org.springframework.stereotype.Component;
import pl.betse.beontime.bo.RoleDTO;
import pl.betse.beontime.entity.RoleEntity;

@Component
public class RoleModelMapper {
    public RoleDTO fromRoleEntityToRoleDto(RoleEntity roleEntity) {
        return roleEntity == null ? null : RoleDTO.builder()
                .id(roleEntity.getId())
                .role(roleEntity.getRole())
                .build();
    }

    public RoleEntity fromRoleDtoToRoleEntity(RoleDTO roleDTO) {
        return roleDTO == null ? null : RoleEntity.builder()
                .id(roleDTO.getId())
                .role(roleDTO.getRole())
                .build();
    }
}
