/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author yagog
 */
public class TreeNode {
    private final String FullName; // using 'private final' will make sure that the name that are insert will not possible to change
    private final ManagerType ManagerType;
    private final DepartmentType DepartmentType;
    
    // this comands will help to strucuture of the tree, give the possibility to change
    TreeNode left;
    TreeNode right;
    
    public TreeNode(String FullName, ManagerType ManagerType, DepartmentType DepartmentType) {
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
        return FullName + " | " + ManagerType + " | " + DepartmentType;
    }
    
}
