package pl.betse.beontime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.betse.beontime.bo.DepartmentDTO;
import pl.betse.beontime.bo.UserDTO;
import pl.betse.beontime.entity.UserEntity;
import pl.betse.beontime.service.DepartmentService;
import pl.betse.beontime.service.RoleService;
import pl.betse.beontime.service.UsersService;
import pl.betse.beontime.utils.DTOResponseConstructor;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {


    @Autowired
    UsersService usersService;

    @Autowired
    RoleService roleService;

    @Autowired
    DepartmentService departmentService;


    @GetMapping
    public List<DepartmentDTO> getDepartmentWithUsers() {

        List<DepartmentDTO> departmentList = new ArrayList<>();


        departmentService.findAll().forEach(department -> {

            List<UserDTO> userList = new ArrayList<>();

            for (UserEntity user : usersService.findByDepartmentEntity(departmentService.getDepartmentById(department.getId()))) {
                DTOResponseConstructor.buildUserDTOListWithRoles(userList, user);
            }


            departmentList.add(new DepartmentDTO().builder()
                    .id(department.getId())
                    .name(department.getName())
                    .users(userList)
                    .build());
        });


        return departmentList;

    }


}
