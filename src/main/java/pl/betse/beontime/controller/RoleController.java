package pl.betse.beontime.controller;

import org.springframework.web.bind.annotation.*;
import pl.betse.beontime.bo.RoleDTO;
import pl.betse.beontime.bo.UserDTO;
import pl.betse.beontime.entity.UserEntity;
import pl.betse.beontime.repository.RoleRepository;
import pl.betse.beontime.service.DepartmentService;
import pl.betse.beontime.service.RoleService;
import pl.betse.beontime.service.UsersService;
import pl.betse.beontime.utils.DTOResponseConstructor;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    UsersService usersService;
    DepartmentService departmentService;
    RoleService roleService;
    RoleRepository roleRepository;

    public RoleController(UsersService usersService, DepartmentService departmentService, RoleService roleService, RoleRepository roleRepository) {
        this.usersService = usersService;
        this.departmentService = departmentService;
        this.roleService = roleService;
        this.roleRepository = roleRepository;
    }

    @GetMapping()
    public @ResponseBody
    List<RoleDTO> getRoleListWithUsers() {

        List<RoleDTO> roleList = new ArrayList<>();
        roleService.findAll().forEach(x -> {

            List<UserDTO> usersList = new ArrayList<>();

            for (UserEntity userEntity : x.getUserEntities()) {
                DTOResponseConstructor.buildUserDTOListWithRoles(usersList, userEntity);
            }

            roleList.add(RoleDTO.builder().role(x.getRole()).id(x.getId()).users(usersList).build());
        });

        return roleList;
    }


}
