package tech.getemployees.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import tech.getemployees.employeemanager.model.Employee;
import tech.getemployees.employeemanager.service.EmployeeService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/employee")
public class EmployeeResoruce {
    private final EmployeeService employeeService;

    public EmployeeResoruce(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employees = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employeeData) {
        Employee employee = employeeService.addEmployee(employeeData);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee updatedEmployeeData) {
        Employee updatedEmployee = employeeService.updateEmployee(updatedEmployeeData);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}