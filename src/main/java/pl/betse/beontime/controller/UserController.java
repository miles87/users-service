package pl.betse.beontime.controller;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.betse.beontime.model.*;
import pl.betse.beontime.model.dto.UserDTO;
import pl.betse.beontime.model.enums.DepartmentEnum;
import pl.betse.beontime.model.enums.RoleEnum;
import pl.betse.beontime.model.validation.CreateUserValidation;
import pl.betse.beontime.service.DepartmentService;
import pl.betse.beontime.service.RoleService;
import pl.betse.beontime.service.UsersService;
import pl.betse.beontime.utils.CustomResponseMessage;
import pl.betse.beontime.utils.DTOResponseConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UsersService usersService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    /*

    GET MAPPINGS

    */
    @GetMapping
    public @ResponseBody
    ResponseEntity<?> obtainAllUsers() {
        List<UserDTO> userList = new ArrayList<>();
        usersService.findAll()
                .forEach(x ->
                        DTOResponseConstructor.buildUserDTOListWithRoles(userList, x));
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<?> getUserById(@PathVariable("id") String userId) {

        if (!usersService.existsByUserId(Integer.valueOf(userId))) {
            return new ResponseEntity<>(new CustomResponseMessage(HttpStatus.BAD_REQUEST, "User with ID=" + userId + " doesn't exist!"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(usersService.findById(Integer.valueOf(userId)), HttpStatus.OK);
    }

    /*

     POST MAPPINGS

     */
    @PostMapping
    public @ResponseBody
    CustomResponseMessage createNewUser(@RequestBody @Validated(CreateUserValidation.class) UserDTO userDTO) {


        if (!EnumUtils.isValidEnum(DepartmentEnum.class, userDTO.getUserDepartment().toUpperCase())) {
            return new CustomResponseMessage(HttpStatus.BAD_REQUEST, "Department does't exist!");
        }

        Set<UserRole> newUserRoles = new HashSet<>();

        if (userDTO.getRoles() != null) {
            if (validateUserRoles(userDTO, newUserRoles))
                return new CustomResponseMessage(HttpStatus.BAD_REQUEST, "Role doesn't exist!");
        }


        User newUser = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .isActive(userDTO.isActive())
                .emailLogin(userDTO.getEmailLogin())
                .password(passwordEncoder.encode("qwe123!"))
                .userDepartment(departmentService.findByName(userDTO.getUserDepartment()))
                .roles(newUserRoles)
                .build();


        usersService.save(newUser);


        return new CustomResponseMessage(HttpStatus.OK, newUser.toString());
    }


    /*

     PUT MAPPINGS

     */

    @PutMapping(path = "/{id}")
    public @ResponseBody
    CustomResponseMessage updateUser(@PathVariable("id") String userId, @RequestBody UserDTO userDTO) {

        if (!usersService.existsByUserId(Integer.valueOf(userId))) {
            return new CustomResponseMessage(HttpStatus.BAD_REQUEST, "User with ID=" + userId + " doesn't exist!");
        }

        User user = usersService.findById(Integer.valueOf(userId));

        if (userDTO.getUserDepartment() != null) {
            if (!EnumUtils.isValidEnum(DepartmentEnum.class, userDTO.getUserDepartment().toUpperCase())) {
                return new CustomResponseMessage(HttpStatus.BAD_REQUEST, "Department does't exist!");
            }

            user.setUserDepartment(departmentService.findByName(userDTO.getUserDepartment()));
        }

        Set<UserRole> newUserRoles = new HashSet<>();

        if (userDTO.getRoles() != null) {
            if (validateUserRoles(userDTO, newUserRoles))
                return new CustomResponseMessage(HttpStatus.BAD_REQUEST, "Role doesn't exist!");

            user.setRoles(newUserRoles);
        }

        if (user.getEmailLogin() != null) {

            if (usersService.existsByEmailLogin(userDTO.getEmailLogin())) {
                return new CustomResponseMessage(HttpStatus.BAD_REQUEST, "User with email: " + userDTO.getEmailLogin() + " currently exists in database!");
            }

            user.setEmailLogin(userDTO.getEmailLogin());
        }

        if (user.getFirstName() != null) {
            user.setFirstName(userDTO.getFirstName());
        }

        if (user.getLastName() != null) {
            user.setLastName(userDTO.getLastName());
        }

        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }


        return new CustomResponseMessage(HttpStatus.OK, "User successfully updated.");
    }


    /*

     ADDITIONAL METHODS

    */

    private boolean validateUserRoles(@Validated(CreateUserValidation.class) @RequestBody UserDTO userDTO, Set<UserRole> newUserRoles) {
        for (String role : userDTO.getRoles()) {
            if (!EnumUtils.isValidEnum(RoleEnum.class, role.toUpperCase())) {
                return true;
            } else {
                newUserRoles.add(roleService.findByName(role));
            }
        }
        return false;
    }
}
