package pa.techpanama.employeemanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pa.techpanama.employeemanager.model.Employee;
import pa.techpanama.employeemanager.service.EmployeeService;


import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    /**
     * Json add
     *{
     *     "email":"charinthebest@hotmail.com",
     *     "imageUrl":"https://media-exp3.licdn.com/dms/image/C5635AQFCl6o6g-FzTw/profile-framedphoto-shrink_200_200/0/1597428813991?e=1626350400&v=beta&t=KAuQ_3qqXXO7bskxxMfEvNH5oNBz8ZPa02jUQ5wk87k",
     *     "jobTitle":"Tech Electronic",
     *     "name":"Charin Herrera"
     *     "phone":"66666666"
     *
     *}
     *
     *
     * @param employee
     * @return
     */

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
