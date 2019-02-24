package pl.betse.beontime.service;


import pl.betse.beontime.model.UserDepartment;

public interface DepartmentService {

    UserDepartment findByName(String departmentName);

    void save(UserDepartment userDepartment);

}
