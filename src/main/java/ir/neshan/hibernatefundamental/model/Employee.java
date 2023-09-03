package ir.neshan.hibernatefundamental.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    private String email;

    private int age ;


    @ManyToOne
    @JoinColumn(
            name = "department_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "employee_department_fk"
            )
    )
    private Department department;


    public Employee(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}