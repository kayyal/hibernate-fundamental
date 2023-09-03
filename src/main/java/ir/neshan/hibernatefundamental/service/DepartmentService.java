package ir.neshan.hibernatefundamental.service;

import ir.neshan.hibernatefundamental.model.Department;
import ir.neshan.hibernatefundamental.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {
   final DepartmentRepository departmentRepository ;

    public Department saveDepartment(Department department) {
      return   departmentRepository.save(department);
    }




}
