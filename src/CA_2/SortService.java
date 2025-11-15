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
public class SortService {

    public static void recursiveSortByName(List<ApplicantRecord> list) {
        if (list == null || list.size() < 2)
            return;
        
        List<ApplicantRecord> aux =new ArrayList<>(list);
        mergeSort(list, aux, 0, list.size() - 1);   
    }
    
    // Using 'merge system' because give stability and organization of the list nad auxiliar list 
    private static void mergeSort(List<ApplicantRecord> app, List<ApplicantRecord> aux, int n1, int n2) {
        if (n1 >= n2)
            return;
        
        int mid = (n1 + n2) >>> 1;
        
        mergeSort(app, aux, n1, mid);
        mergeSort(app, aux, mid + 1, n2);
        merge(app, aux, n1, mid, n2);
    }
    // this part math will be involved math to discover each num is higher than other
    private static void merge(List<ApplicantRecord> app, List<ApplicantRecord> aux, int n1, int mid, int n2) {
        for (int i = n1; i <= n2; i++) {
            aux.set(i, app.get(i));
        }
    
        int i = n1;
        int j = mid + 1;

        for (int k = n1; k <= n2; k++) {
            if (i > mid) {
                app.set(k, aux.get(j++));
            } else if (j > n2) {
                app.set(k, aux.get(i++));
            } else if (compareByName(aux.get(i), aux.get(j)) <= 0) {
                app.set(k, aux.get(i++));
            } else {
                app.set(k, aux.get(j++));
            }
        }
    // will compare per name(case-insensitive, null-safe).
    private static int compareByName(ApplicantRecord x, ApplicantRecord y) {
        String appx = norm(x == null ? null : x.getFullName());
        String appy = norm(y == null ? null : y.getFullName());
        return appx.compareToIgnoreCase(appy);
        }


    private static String norm(String s) {
        return s == null ? "" : s.trim();
    }
}
