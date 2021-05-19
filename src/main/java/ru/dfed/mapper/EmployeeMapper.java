package ru.dfed.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.dfed.model.Employee;
import ru.dfed.model.dto.EmployeeDto;

@Mapper
public interface EmployeeMapper {

    @Mapping(source = ".", target = "address",qualifiedByName = "GetAddressFromEmployee")
    @Mapping(source = ".", target = "phone",qualifiedByName = "GetPhoneFromEmployee")
    EmployeeDto toDto(Employee employee);


    @Named("GetAddressFromEmployee")
    default String getAddressFromEmployee(Employee employee) {
        return employee.getAddress().get(0).getItems().get(0).getValue();
    }


    @Named("GetPhoneFromEmployee")
    default String getPhoneFromEmployee(Employee employee) {
        return employee.getPhone().get(0).getNumber();
    }

}
