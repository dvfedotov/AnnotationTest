package ru.dfed.web.rest;


import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dfed.mapper.EmployeeMapper;
import ru.dfed.model.Employee;
import ru.dfed.model.dto.EmployeeDto;

@RestController
@RequestMapping("api/")
public class EmployeeController {

    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeMapper mapper;

    public EmployeeController(EmployeeMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("employee")
    public ResponseEntity<EmployeeDto> getEmployeeDto(HttpServletRequest request,
                                                      @RequestBody Employee employee) {
        log.info("Request to getExampleDto: {}", employee);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(mapper.toDto(employee));
    }

    @PostMapping("employeeDto")
    public ResponseEntity<Employee> getEmployee(HttpServletRequest request,
                                                @RequestBody EmployeeDto employeeDto) {
        log.info("Request to getExampleDto: {}", employeeDto);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(mapper.fromDto(employeeDto));
    }

}

