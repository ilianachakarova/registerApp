package regApp.web.mbeans;

import regApp.service.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class EmployeeRemoveBean {

    private EmployeeService employeeService;

    public EmployeeRemoveBean() {
    }
    @Inject
    public EmployeeRemoveBean(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void remove(int id) throws IOException {
        this.employeeService.removeEmployee(id);

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("/");
    }
}
