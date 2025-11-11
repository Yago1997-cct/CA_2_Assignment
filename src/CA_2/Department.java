/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author yagog
 */
public class Department {
    private int id;
    private String name;
    private DepartmentType type;
    
    public Department(int id, String name, DepartmentType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public DepartmentType getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}
