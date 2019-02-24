package pl.betse.beontime.utils;

import org.springframework.stereotype.Component;
import pl.betse.beontime.model.User;
import pl.betse.beontime.model.UserRole;
import pl.betse.beontime.model.dto.UserDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DTOResponseConstructor {

    public static void buildUserDTOListWithRoles(List<UserDTO> usersList, User user) {
        Set<String> userRoles = new HashSet<>();

        for (UserRole userRole : user.getRoles()) {
            userRoles.add(new StringBuilder().append(userRole.getRole()).toString());
        }

        usersList.add(new UserDTO().builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .emailLogin(user.getEmailLogin())
                .isActive(user.isActive())
                .userDepartment(user.getUserDepartment().getName())
                .roles(userRoles)
                .build());
    }
}
