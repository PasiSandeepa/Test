package edu.icet.service.custom.impl;

import edu.icet.dto.Employee;
import edu.icet.entity.EmployeeEntity;
import edu.icet.repository.custom.EmployeeRepository;
import edu.icet.service.custom.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        List<EmployeeEntity> all = employeeRepository.findAll();
        all.forEach(
                employeeEntity -> employeeList.add(
                        modelMapper.map(employeeEntity, Employee.class)
                )
        );

        return employeeList;
    }

    @Override
    public void register(Employee employee) {
        EmployeeEntity map = modelMapper.map(employee, EmployeeEntity.class);
        employeeRepository.save(map);
    }
}
