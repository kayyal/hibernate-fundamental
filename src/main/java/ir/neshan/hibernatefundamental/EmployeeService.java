package ir.neshan.hibernatefundamental;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private EntityManager entityManager;
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findByName(String name) {
      return   employeeRepository.findEmployeeByName(name);
    }

    public List<Employee> getEmployeeByName(String name) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "FROM Employee E WHERE E.name = :employee_name";
        Query query = session.createQuery(hql);
        query.setParameter("employee_name", name);
        List<Employee> results = query.list();
        return results;
    }

    // other methods for retrieving, updating, and deleting employees
}
