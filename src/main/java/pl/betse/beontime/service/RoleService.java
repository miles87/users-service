package pl.betse.beontime.service;

import pl.betse.beontime.entity.RoleEntity;

import java.util.List;

public interface RoleService {


    List<RoleEntity> findAll();

    RoleEntity findByName(String roleName);

    void save(RoleEntity roleEntity);

}
