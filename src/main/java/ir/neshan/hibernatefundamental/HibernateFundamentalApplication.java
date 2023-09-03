package ir.neshan.hibernatefundamental;

import com.github.javafaker.Faker;
import ir.neshan.hibernatefundamental.model.Department;
import ir.neshan.hibernatefundamental.model.Employee;
import ir.neshan.hibernatefundamental.repository.DepartmentRepository;
import ir.neshan.hibernatefundamental.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateFundamentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateFundamentalApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner( DepartmentRepository departmentRepository) {
        return args -> {
            Faker faker = new Faker();
            Department department = new Department("Software engineer");
            department.addEmployee(new Employee("amir kayyal" ,"amir@gmail.com" , 23 ));
            departmentRepository.save(department);

        };
    }

}
