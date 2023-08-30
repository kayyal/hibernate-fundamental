package ir.neshan.hibernatefundamental;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }


    @GetMapping("/{id}")
    public Optional<Employee> findEmployeeById(@PathVariable Long id) {
      return employeeService.findById(id);
    }





    // other endpoints for retrieving, updating, and deleting employees
}
