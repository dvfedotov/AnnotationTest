package ru.dfed.web.rest;


import javax.servlet.http.HttpServletRequest;
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

    private final EmployeeMapper mapper;

    public EmployeeController(EmployeeMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("employee")
    public ResponseEntity<EmployeeDto> getExampleDto(HttpServletRequest request,
                                                     @RequestBody Employee employee) {
        System.out.println(employee.toString());
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(mapper.toDto(employee));
    }


}

