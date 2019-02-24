package pl.betse.beontime.service;

import pl.betse.beontime.model.UserRole;

import java.util.List;

public interface RoleService {


    List<UserRole> findAll();

    UserRole findByName(String roleName);

    void save(UserRole userRole);

}
