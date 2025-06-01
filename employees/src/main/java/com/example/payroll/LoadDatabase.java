package com.example.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.payroll.departmentService.Department;
import com.example.payroll.departmentService.DepartmentRepository;
import com.example.payroll.employeeService.Employee;
import com.example.payroll.employeeService.EmployeeRepository;
import com.example.payroll.security.User;
import com.example.payroll.security.UserRepository;

@Configuration
class LoadDatabase {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository,
            UserRepository userRepository) {

        return args -> {

            if (departmentRepository.count() == 0) {
                Department department1 = new Department("IT", "Bethlehem");
                Department department2 = new Department("HR", "Ramallah");

                departmentRepository.save(department1);
                departmentRepository.save(department2);

                log.info("Departments preloaded.");
            }

            if (userRepository.count() == 0) {
                User adminUser = new User("Bilbo@gmail.com", passwordEncoder.encode("bilbo"), "ROLE_ADMIN");
                User normalUser = new User("Frodo@gmail.com", passwordEncoder.encode("frodo"), "ROLE_USER");

                userRepository.save(adminUser);
                userRepository.save(normalUser);

                log.info("Users preloaded.");
            }

            if (employeeRepository.count() == 0) {
                User adminUser = userRepository.findByUsername("Bilbo@gmail.com").orElseThrow();
                User normalUser = userRepository.findByUsername("Frodo@gmail.com").orElseThrow();

                Department department1 = departmentRepository.findByName("IT").orElseThrow();
                Department department2 = departmentRepository.findByName("HR").orElseThrow();

                Employee employee1 = new Employee("Bilbo Baggins", "burglar", "bilbo@email.com");
                employee1.setUser(adminUser);
                employee1.setDepartment(department1);

                Employee employee2 = new Employee("Frodo Baggins", "thief", "frodo@email.com");
                employee2.setUser(normalUser);
                employee2.setDepartment(department2);

                employeeRepository.save(employee1);
                employeeRepository.save(employee2);

                log.info("Employees preloaded.");
            }

            log.info("All initial data loaded successfully!");
};
}
}