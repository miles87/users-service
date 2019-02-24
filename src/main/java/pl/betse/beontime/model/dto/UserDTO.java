package pl.betse.beontime.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pl.betse.beontime.model.validation.CreateUserValidation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    private Integer userId;

    @NotNull(groups = {CreateUserValidation.class})
    @NotEmpty(groups = {CreateUserValidation.class})
    private String emailLogin;

    private String firstName;

    private String lastName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonProperty()
    private boolean isActive;

    @NotNull(groups = {CreateUserValidation.class})
    @NotEmpty(groups = {CreateUserValidation.class})
    private String userDepartment;

    private Set<String> roles;


}
