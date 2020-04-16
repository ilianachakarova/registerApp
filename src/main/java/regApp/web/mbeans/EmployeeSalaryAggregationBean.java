package regApp.web.mbeans;

import regApp.service.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named
@RequestScoped
public class EmployeeSalaryAggregationBean {
    private EmployeeService employeeService;

    public EmployeeSalaryAggregationBean() {
    }
    @Inject
    public EmployeeSalaryAggregationBean(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

   public BigDecimal getTotal(){
        return this.employeeService.calculateTotalSalary();
   }

   public BigDecimal getAverage(){
        return this.employeeService.calculateAverageSalary();
   }
}
