package com.wholesale.backend.config;

import org.modelmapper.Converters.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wholesale.backend.models.dto.EmployeeCreateDto;
import com.wholesale.backend.models.entities.Employee;
import com.wholesale.backend.repositories.EmployeeRepository;


@Configuration
public class MapperConfig {
    
    @Bean
    public ModelMapper modelMapper(EmployeeRepository employeeRepository) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

}
