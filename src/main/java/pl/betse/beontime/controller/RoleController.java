package pl.betse.beontime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.betse.beontime.model.User;
import pl.betse.beontime.model.dto.RoleDTO;
import pl.betse.beontime.model.dto.UserDTO;
import pl.betse.beontime.service.DepartmentService;
import pl.betse.beontime.service.RoleService;
import pl.betse.beontime.service.UsersService;
import pl.betse.beontime.utils.DTOResponseConstructor;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {


    @Autowired
    UsersService usersService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    RoleService roleService;

    @GetMapping()
    public @ResponseBody
    List<RoleDTO> getRoleListWithUsers() {

        List<RoleDTO> roleList = new ArrayList<>();
        roleService.findAll().forEach(x -> {

            List<UserDTO> usersList = new ArrayList<>();

            for (User user : x.getUsers()) {
                DTOResponseConstructor.buildUserDTOListWithRoles(usersList, user);
            }

            roleList.add(RoleDTO.builder().role(x.getRole()).id(x.getId()).users(usersList).build());
        });


        return roleList;
    }


}
