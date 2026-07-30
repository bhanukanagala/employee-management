import com.ems.entity.Employee;
import com.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@CrossOrigin(
        origins = "http://localhost:5173"
)
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<Employee> createEmployee(
            @RequestBody Employee employee){
        return new ResponseEntity<>(
                employeeService.createEmployee(employee),
                HttpStatus.CREATED
        );
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        return ResponseEntity.ok(
                employeeService.getAllEmployees()
        );

    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(
            @PathVariable Long id){
        return ResponseEntity.ok(
                employeeService.getEmployeeById(id)

        );

    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee
    ){
        return ResponseEntity.ok(
                employeeService.updateEmployee(
                        id,
                        employee
                )
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long id){


        employeeService.deleteEmployee(id);


        return ResponseEntity.ok(
                "Employee deleted successfully"
        );

    }


}
