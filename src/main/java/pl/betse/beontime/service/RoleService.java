package pl.betse.beontime.service;

import pl.betse.beontime.model.role.UserRole;

import java.util.List;

public interface RoleService {


    List<UserRole> findAll();

    void save(UserRole userRole);

}
