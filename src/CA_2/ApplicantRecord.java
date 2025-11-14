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
    
    private String fullname;
    private ManagerType managerType;
    private DepartmentType departmentType;
    
    public ApplicantRecord(String fullname, ManagerType managerType, DepartmentType departmentType) {
        this.fullname = fullname;
        this.managerType = managerType;
        this.departmentType = departmentType;
    }
    
    public String getfullname() {
        return fullname;
    }
    
    public ManagerType getmanagerType() {
        return managerType;
    }
    
    public DepartmentType getdepartmentType() {
        return departmentType;
    }
    
    @Override
    public String toString() {
        return "ApplicantRecord {" + "Full Name='" + fullname + '\'' + ", Manager Type=" + managerType + ", Department Type=" + departmentType + '}';
    }
    
    
    
}
