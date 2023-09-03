package ir.neshan.hibernatefundamental.repository;


import ir.neshan.hibernatefundamental.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

    List<Employee> findEmployeeByName(String name);

    @Transactional
    @Modifying
    @Query(value = "DELETE from Employee WHERE department_name=: name" , nativeQuery = true)
    public void deleteAllByDepartmentName(@Param("name") String name);


}
