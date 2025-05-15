package edu.icet.service.custom;

import edu.icet.dto.Employee;
import jakarta.validation.Valid;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    void register(@Valid Employee employee);
}
