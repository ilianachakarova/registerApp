package regApp.service;

import org.modelmapper.ModelMapper;
import regApp.domain.entities.Employee;
import regApp.domain.models.service.EmployeeServiceModel;
import regApp.repository.EmployeeRepository;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

     private final EmployeeRepository employeeRepository;
     private final ModelMapper modelMapper;
    @Inject
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean saveEmployee(EmployeeServiceModel employeeServiceModel) {
        try{
        this.employeeRepository.save(this.modelMapper.map(employeeServiceModel, Employee.class));

        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<EmployeeServiceModel> findAllEmployees() {
        return this.employeeRepository.findAll().stream().map(e->this.modelMapper.map(e, EmployeeServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean removeEmployee(int id) {
        try{
            this.employeeRepository.remove(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public BigDecimal calculateTotalSalary() {
         BigDecimal sum = new BigDecimal(0);
        for (Employee employee : this.employeeRepository.findAll()) {
           sum = sum.add(employee.getSalary());
        }
        return sum;
    }

    @Override
    public BigDecimal calculateAverageSalary() {

        return this.calculateTotalSalary().
                divide(BigDecimal.valueOf(this.employeeRepository.findAll().size()), MathContext.DECIMAL32);
    }


}
