import com.ems.entity.Employee;
import com.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service

@RequiredArgsConstructor

public class EmployeeServiceImpl 
        implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public Employee createEmployee(
            Employee employee){
        return employeeRepository.save(employee);

    }
    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    @Override
    public Employee getEmployeeById(Long id){
        return employeeRepository
                .findById(id)
                .orElseThrow(
                    () -> 
                    new RuntimeException(
                    "Employee not found"
                    )
                );

    }
    @Override
    public Employee updateEmployee(
            Long id,
            Employee employee){
        Employee existingEmployee =
                getEmployeeById(id);
        existingEmployee.setFirstName(
                employee.getFirstName()
        );
        existingEmployee.setLastName(
                employee.getLastName()
        );


        existingEmployee.setEmail(
                employee.getEmail()
        );


        existingEmployee.setDepartment(
                employee.getDepartment()
        );


        existingEmployee.setDesignation(
                employee.getDesignation()
        );


        existingEmployee.setSalary(
                employee.getSalary()
        );



        return employeeRepository.save(
                existingEmployee
        );

    }
    @Override
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }


}
