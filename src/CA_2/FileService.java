/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yagog
 */
public class FileService {
    public static List<ApplicantRecord> readApplicantsFromFile(String filePath) {
        List<ApplicantRecord> applicants = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // This code will skip header

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    String fullname = parts[0].trim();
                    ManagerType managerType = ManagerType.valueOf(parts[1].trim().toUpperCase());
                    DepartmentType departmentType = DepartmentType.valueOf(parts[2].trim().toUpperCase());
                    applicants.add(new ApplicantRecord(fullname, managerType, departmentType));
                }
            }
        } catch (IOException e) {
            System.out.println("Error to read the file " + e.getMessage());
        }

        return applicants;
    } 
}
