package regApp.repository;

import regApp.domain.entities.Employee;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EntityManager entityManager;
    @Inject
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee save(Employee entity) {
       this.entityManager.getTransaction().begin();
       this.entityManager.persist(entity);
       this.entityManager.getTransaction().commit();

       return entity;
    }

    @Override
    public List<Employee> findAll() {
        this.entityManager.getTransaction().begin();
        List<Employee>employees =
                this.entityManager.createQuery("select e from Employee e",Employee.class).getResultList();
        this.entityManager.getTransaction().commit();
        return employees;
    }

    @Override
    public Employee findById(int s) {
        this.entityManager.getTransaction().begin();
        Employee employee = this.entityManager.
                createQuery("select e from Employee e where e.id =:id", Employee.class).setParameter("id",s)
                .getSingleResult();
        return employee;
    }

    @Override
    public void remove(int id) {
     this.entityManager.getTransaction().begin();
     Query query  = this.entityManager.createQuery("delete from Employee e where e.id =:id")
             .setParameter("id",id);
     query.executeUpdate();
     this.entityManager.getTransaction().commit();

    }
}
