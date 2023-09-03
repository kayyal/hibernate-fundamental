package ir.neshan.hibernatefundamental.repository;

import ir.neshan.hibernatefundamental.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
