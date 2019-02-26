package pl.betse.beontime.utils;

import org.springframework.stereotype.Component;
import pl.betse.beontime.bo.UserDTO;
import pl.betse.beontime.entity.RoleEntity;
import pl.betse.beontime.entity.UserEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DTOResponseConstructor {

    public static void buildUserDTOListWithRoles(List<UserDTO> usersList, UserEntity userEntity) {
        Set<String> userRoles = userEntity.getRoles()
                .stream()
                .map(RoleEntity::getRole)
                .collect(Collectors.toSet());

        usersList.add(new UserDTO().builder()
                .userId(userEntity.getUserId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .emailLogin(userEntity.getEmailLogin())
                .isActive(userEntity.isActive())
                .department(userEntity.getDepartmentEntity().getName())
                .roles(userRoles)
                .build());
    }
}
