package ir.neshan.hibernatefundamental.controller;


import ir.neshan.hibernatefundamental.model.Department;
import ir.neshan.hibernatefundamental.model.Employee;
import ir.neshan.hibernatefundamental.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dep")
@AllArgsConstructor
public class DepartmentController {
    DepartmentService departmentService;

    @PostMapping("/create")
    public Department createDepartment(@RequestBody Department department) {
      return   departmentService.saveDepartment(department);
    }
}
