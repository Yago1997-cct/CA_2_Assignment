/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author yagog
 */
public class Employee {
    private int id;
    private String name;
    private DepartmentType department;
    
    public Employee(int id, String name, DepartmentType department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public DepartmentType getDepartment() {
        return department;
    }
    
    @Override
    public String toString() {
        return name + " - " + department.getName();
    }
}
