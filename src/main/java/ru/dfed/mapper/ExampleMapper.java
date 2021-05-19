package ru.dfed.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.dfed.model.Example;
import ru.dfed.model.dto.ExampleDto;

@Mapper(componentModel = "spring",uses = {ExampleDateMapper.class})
public interface ExampleMapper {
    @Mapping(source = ".", target = "fullName", qualifiedByName = "FullNameByFirstAndLastName")
    @Mapping(source = "dateCreated", target = "dateCreated")
    ExampleDto toDto(Example example);

    @Mapping(source = ".", target = "firstName", qualifiedByName = "FirstNameByFullName")
    @Mapping(source = ".", target = "lastName", qualifiedByName = "LastNameByFullName")
    @Mapping(source = "dateCreated", target = "dateCreated")
    Example fromDto(ExampleDto exampleDto);

    @Named("FullNameByFirstAndLastName")
    default String fullNameByFirstAndLastName(Example example) {
        return example.getFirstName() + ' ' + example.getLastName();
    }

    @Named("FirstNameByFullName")
    default String firstNameByFullName(ExampleDto exampleDto) {
        return exampleDto.getFullName().split(" ")[0];
    }

    @Named("LastNameByFullName")
    default String lastNameByFullName(ExampleDto exampleDto) {
        return exampleDto.getFullName().split(" ")[1];
    }

}
