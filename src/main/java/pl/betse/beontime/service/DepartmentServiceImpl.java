package pl.betse.beontime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.betse.beontime.entity.DepartmentEntity;
import pl.betse.beontime.repository.DepartamentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartamentRepository departamentRepository;

    @Override
    public DepartmentEntity findByName(String departmentName) {
        return departamentRepository.findByName(departmentName);
    }

    @Override
    public List<DepartmentEntity> findAll() {
        List<DepartmentEntity> departments = new ArrayList<>();
        departamentRepository.findAll().forEach(departments::add);
        return departments;
    }

    @Override
    public DepartmentEntity getDepartmentById(Integer departmentId) {
        return departamentRepository.findById(departmentId).get();
    }

    @Override
    public void save(DepartmentEntity departmentEntity) {
        departamentRepository.save(departmentEntity);
    }
}
