/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yagog
 */
public class StaffRepository {
    private List<Manager> managers;
    private List<Employee> employees;
    
    public StaffRepository() {
        this.managers = new ArrayList<>();
        this.employees = new ArrayList<>();
    }
    
    public void addManager(Manager m) {
        managers.add(m);
    }
    
    public void addEmployee(Employee e) {
        employees.add(e);
    }
    
    public List<Manager> getAllManagers() {
        return managers;
    }
    
    public List<Employee> getAllEmployees() {
        return employees;
    }
    
    
}
