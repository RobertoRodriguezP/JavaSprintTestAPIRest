package pa.techpanama.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import pa.techpanama.employeemanager.model.Employee;

public interface EmployeeRepo  extends JpaRepository<Employee, Long>{
     void deleteEmployeeById(Long id);

     Optional<Employee> findEmployeeById(Long id);
}
