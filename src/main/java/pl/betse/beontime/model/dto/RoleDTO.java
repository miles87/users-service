package pl.betse.beontime.model.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private int id;

    private String role;

    private List<UserDTO> users;

}
