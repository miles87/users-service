package pl.betse.beontime.modelMapper;

import org.springframework.stereotype.Component;
import pl.betse.beontime.bo.UserDTO;
import pl.betse.beontime.entity.UserEntity;

@Component
public class UserModelMapper {
    public UserDTO fromUserEntityToUserDTO (UserEntity userEntity){
        return userEntity == null ? null : UserDTO.builder()
                .userId(userEntity.getUserId())
                .emailLogin(userEntity.getEmailLogin())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .password(userEntity.getPassword())
                .isActive(userEntity.isActive())
                .build();
    }

    public UserEntity fromUserDtoToUserEntity(UserDTO userDTO){
        return userDTO == null ? null : UserEntity.builder()
                .userId(userDTO.getUserId())
                .emailLogin(userDTO.getEmailLogin())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .password(userDTO.getPassword())
                .isActive(userDTO.isActive())
                .build();
    }
}
