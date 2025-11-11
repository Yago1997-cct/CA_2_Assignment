/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author yagog
 */
public class Manager extends Employee{
    
    private ManagerType type;
    
    public Manager(int id, String name, ManagerType type, Department department) {
        super(id, name, department);
        this.type = type;
    }
    
    public ManagerType getType() {
        return type;
    
    }    
    @Override
    public String toString() {
        return getName() + "(" + type + ") -" + getDepartment().getName();
    }
    
}
