package ir.neshan.hibernatefundamental.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {
    public Department(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "department",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Employee> employeeList = new ArrayList<>();

    public Department() {

    }

    public void addEmployee(Employee employee) {
        if (!this.employeeList.contains(employee)) {
            this.employeeList.add(employee);
            employee.setDepartment(this);
        }
    }


    public void removeEmployee(Employee employee) {
        if (this.employeeList.contains(employee)) {
            this.employeeList.remove(employee);
            employee.setDepartment(null);
        }

    }
}
