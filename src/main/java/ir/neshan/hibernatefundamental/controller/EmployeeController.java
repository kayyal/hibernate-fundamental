package ir.neshan.hibernatefundamental.controller;

import ir.neshan.hibernatefundamental.model.Employee;
import ir.neshan.hibernatefundamental.repository.EmployeeRepository;
import ir.neshan.hibernatefundamental.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    EmployeeRepository employeeRepository;


    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }


    @GetMapping("/{id}")
    public Optional<Employee> findEmployeeById(@PathVariable Long id) {
      return employeeService.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    @DeleteMapping("/delete/dep/{name}")
    public void deleteAllEmployeeByDepartmentName(@PathVariable String name) {
        employeeRepository.deleteAllByDepartmentName(name);

    }





    // other endpoints for retrieving, updating, and deleting employees
}
