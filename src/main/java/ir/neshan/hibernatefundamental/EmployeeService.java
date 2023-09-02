package ir.neshan.hibernatefundamental;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
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

    public List<Employee> getEmployeeByNameNative(String name) {
        String sql = "SELECT * FROM Employee E WHERE E.name = :employee_name";
        Query query = (Query) entityManager.createNativeQuery(sql, Employee.class);
        query.setParameter("employee_name", name);
        List<Employee> results = query.getResultList();
        return results;
    }

    public List<Employee> getEmployeeByNameCriteria(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name));
        Query query = (Query) entityManager.createQuery(criteriaQuery);
        List<Employee> results = query.getResultList();
        return results;
    }



}
