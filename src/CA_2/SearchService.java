/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.List;

/**
 *
 * @author yagog
 */
public class SearchService {
    public static ApplicantRecord searchByNameLinear(List<ApplicantRecord> List, String term) {
        if(List == null || List.isEmpty() || term == null)
            return null;
        String want = term.trim().toLowerCase();
        
        for (ApplicantRecord ar : List) {
            if (ar == null || ar.getFullName() == null)
                continue;
            if (ar.getFullName().trim().toLowerCase().equals(want)) {
                return ar;
            }
        }
        return null;
    }
}
