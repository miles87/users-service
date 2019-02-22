package pl.betse.beontime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.betse.beontime.model.department.UserDepartment;
import pl.betse.beontime.repository.DepartamentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartamentRepository departamentRepository;

    @Override
    public void save(UserDepartment userDepartment) {
        departamentRepository.save(userDepartment);
    }
}
