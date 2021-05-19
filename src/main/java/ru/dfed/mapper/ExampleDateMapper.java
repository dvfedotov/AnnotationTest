package ru.dfed.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class ExampleDateMapper {
    private final String THE_FORMAT = "yyyy-MM-dd HH:mm";
    private final DateTimeFormatter DATETIMEFORMATTER = DateTimeFormatter.ofPattern(THE_FORMAT);
    public LocalDateTime asLocalDateTime(String str){
        return LocalDateTime.parse(str, DATETIMEFORMATTER);
    }
    public String asString(LocalDateTime datetime){
        return datetime.format(DATETIMEFORMATTER);
    }

}
