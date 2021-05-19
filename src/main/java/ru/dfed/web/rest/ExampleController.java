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
import ru.dfed.mapper.ExampleMapper;
import ru.dfed.model.Example;
import ru.dfed.model.dto.ExampleDto;

@RestController
@RequestMapping("api/")
public class ExampleController {

    private final Logger log = LoggerFactory.getLogger(ExampleController.class);

    private final ExampleMapper mapper;

    public ExampleController(ExampleMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("example")
    public ResponseEntity<ExampleDto> getExampleDto(HttpServletRequest request,
                                                    @RequestBody Example example) {
        log.info("Request to getExampleDto: {}", example);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(mapper.toDto(example));
    }

    @PostMapping("example/dto")
    public ResponseEntity<Example> getExample(HttpServletRequest request,
                                              @RequestBody ExampleDto exampleDto) {
        log.info("Request to getExample: {}", exampleDto);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(mapper.fromDto(exampleDto));
    }
}

