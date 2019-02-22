package pl.betse.beontime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.betse.beontime.model.enums.DepartmentEnum;
import pl.betse.beontime.model.enums.RoleEnum;
import pl.betse.beontime.model.role.UserRole;
import pl.betse.beontime.model.user.User;
import pl.betse.beontime.model.department.UserDepartment;
import pl.betse.beontime.service.DepartmentService;
import pl.betse.beontime.service.RoleService;
import pl.betse.beontime.service.UsersService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    UsersService usersService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    RoleService roleService;

    @GetMapping(path = "/hello")
    public String getUsers() {
        return "HELLO USERS SERVICE";
    }


    @PostMapping
    public @ResponseBody
    List<User> createNewUser() {

        UserDepartment department1 = new UserDepartment(DepartmentEnum.SALESFORCE);
        departmentService.save(department1);
        UserDepartment department2 = new UserDepartment(DepartmentEnum.DIGITAL);
        departmentService.save(department2);

        UserRole userRole1 = new UserRole(RoleEnum.CONSULTANT);
        roleService.save(userRole1);
        UserRole userRole2 = new UserRole(RoleEnum.MANAGER);
        roleService.save(userRole2);
        UserRole userRole3 = new UserRole(RoleEnum.ADMINISTRATION);
        roleService.save(userRole3);


        //SET 1
        Set<UserRole> userSetRoles1 = new HashSet<>();
        userSetRoles1.add(userRole1);
        userSetRoles1.add(userRole3);

        // SET 2
        Set<UserRole> userSetRoles2 = new HashSet<>();
        userSetRoles2.add(userRole2);


        User user1 = new User("test1@be-tse.com", "A", "A", "A", "A", false, department1, userSetRoles1);
        usersService.save(user1);
        User user2 = new User("test2@be-tse.com", "B", "B", "B", "B", false, department2, userSetRoles2);
        usersService.save(user2);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        return userList;


    }


    @GetMapping
    public List<User> obtainAllUsers() {
        return usersService.findAll();
    }


    @GetMapping("/roles")
    public List<UserRole> getUserRoles() {
        return roleService.findAll();
    }
}
