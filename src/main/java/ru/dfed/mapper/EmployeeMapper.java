package ru.dfed.mapper;


import java.util.ArrayList;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.dfed.annotation.Mask;
import ru.dfed.model.Address;
import ru.dfed.model.Employee;
import ru.dfed.model.Item;
import ru.dfed.model.Phone;
import ru.dfed.model.dto.EmployeeDto;

@Mapper
public interface EmployeeMapper {

    @Mapping(source = ".", target = "address", qualifiedByName = "GetAddressFromEmployee")
    @Mapping(source = ".", target = "phone", qualifiedByName = "GetPhoneFromEmployee")
    EmployeeDto toDto(Employee employee);

    @Mapping(source = "address", target = "address", qualifiedByName = "GetAddressFromEmployeeDto")
    @Mapping(source = "phone", target = "phone", qualifiedByName = "GetPhoneFromEmployeeDto")
    Employee fromDto(EmployeeDto employeeDto);


    @Named("GetAddressFromEmployeeDto")
    default List<Address> getAddressFromEmployeeDto(EmployeeDto employeeDto) {
        List<Address> addressList = new ArrayList<>();
        Address address = new Address();
        Item item = new Item();
        item.setName("address");
        item.setValue(employeeDto.getAddress());
        List<Item> items = new ArrayList<>();
        items.add(item);
        address.setItems(items);
        addressList.add(address);
        return addressList;
    }

    @Named("GetPhoneFromEmployeeDto")
    default List<Phone> getPhoneFromEmployeeDto(EmployeeDto employeeDto) {
        List<Phone> phones = new ArrayList<>();
        Phone phone = new Phone();
        phone.setNumber(employeeDto.getPhone());
        return phones;
    }

    @Named("GetAddressFromEmployee")
    default String getAddressFromEmployee(Employee employee) {
        return employee.getAddress().get(0).getItems().get(0).getValue();
    }

    @Mask(regex = "\\+?\\d+(\\d{8})(\\d{2})$")
    @Named("GetPhoneFromEmployee")
    default String getPhoneFromEmployee(Employee employee) {
        String number = employee.getPhone().get(0).getNumber();
        return number;
    }

}