package regApp.service;

import regApp.domain.models.service.EmployeeServiceModel;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {
    boolean saveEmployee(EmployeeServiceModel employeeServiceModel);

    List<EmployeeServiceModel> findAllEmployees();

    boolean removeEmployee(int id);

    BigDecimal calculateTotalSalary();

    BigDecimal calculateAverageSalary();
}
