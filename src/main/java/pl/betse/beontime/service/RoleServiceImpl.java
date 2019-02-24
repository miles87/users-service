package pl.betse.beontime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.betse.beontime.model.UserRole;
import pl.betse.beontime.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<UserRole> findAll() {
        List<UserRole> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    @Override
    public UserRole findByName(String roleName) {
        return roleRepository.findByRole(roleName);
    }

    @Override
    public void save(UserRole userRole) {
        roleRepository.save(userRole);
    }
}
