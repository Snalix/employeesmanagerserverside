package tech.getemployees.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getemployees.employeemanager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
