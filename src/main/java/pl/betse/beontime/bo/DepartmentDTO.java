package pl.betse.beontime.bo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private int id;

    private String name;

    private List<UserDTO> users;
}
