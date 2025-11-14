/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author yagog
 */
public class ApplicantRecord {
    
    private String FullName;
    private ManagerType ManagerType;
    private DepartmentType DepartmentType;
    
    public ApplicantRecord(String FullName, ManagerType ManagerType, DepartmentType DepartmentType) {
        this.FullName = FullName;
        this.ManagerType = ManagerType;
        this.DepartmentType = DepartmentType;
    }
    
    public String getFullName() {
        return FullName;
    }
    
    public ManagerType getManagerType() {
        return ManagerType;
    }
    
    public DepartmentType getDepartmentType() {
        return DepartmentType;
    }
    
    @Override
    public String toString() {
        return "ApplicantRecord {" + "Full Name='" + FullName + '\'' + ", Manager Type=" + ManagerType + ", Department Type=" + DepartmentType + '}';
    }
    
    
    
}
