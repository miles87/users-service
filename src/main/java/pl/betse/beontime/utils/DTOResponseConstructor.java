package pl.betse.beontime.utils;

import org.springframework.stereotype.Component;
import pl.betse.beontime.entity.UserEntity;
import pl.betse.beontime.entity.RoleEntity;
import pl.betse.beontime.bo.UserDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DTOResponseConstructor {

    public static void buildUserDTOListWithRoles(List<UserDTO> usersList, UserEntity userEntity) {
        Set<String> userRoles = new HashSet<>();

        for (RoleEntity roleEntity : userEntity.getRoles()) {
            userRoles.add(new StringBuilder().append(roleEntity.getRole()).toString());
        }

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
