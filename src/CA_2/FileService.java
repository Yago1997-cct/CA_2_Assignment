/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    
    public static void writeTopNToFile(List<ApplicantRecord> list, int n, String outPath) throws IOException {
    int limit = Math.min(n, list == null ? 0 : list.size());
    try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(outPath), StandardCharsets.UTF_8)) {
        bw.write("Name | ManagerType | DepartmentType");
        bw.newLine();
        for (int i = 0; i < limit; i++) {
            ApplicantRecord ar = list.get(i);
            bw.write(ar.getFullName() + " | " + ar.getManagerType() + " | " + ar.getDepartmentType());
            bw.newLine();
        }
    }
}
}
