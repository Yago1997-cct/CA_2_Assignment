/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author yagog
 */
public class ValidationService {
    
    public static boolean isNonEmpty(String VS) {
        return VS != null && !VS.trim().isEmpty();
    }
    public static boolean isValidindex(int choice, int size) {
        return choice >=1 && choice <= size;
    }
    // Safely converts sdtring to managerType, return null if invalid
    public static ManagerType parseManagerTypeOrNull(String VS) {
        if(!isNonEmpty(VS))
            return null;
        try {
            return ManagerType.valueOf(VS.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }
    // Safely converts sdtring to departmentType, return null if invalid
    public static DepartmentType parseDepartmentTypeOrNull(String VS) {
        if(!isNonEmpty(VS))
            return null;
        try {
            return DepartmentType.valueOf(VS.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    
    }
}    
