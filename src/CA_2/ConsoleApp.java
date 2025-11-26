/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author yagog
 */
public class ConsoleApp {
    
    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
    
    private Scanner option = new Scanner(System.in);
    private StaffRepository staffRepository = new StaffRepository();
    
    
    public void run(){
            

            boolean running = true;
            while(running){
                System.out.println("\nStorage Menu:");
                System.out.println("1.SORT ");
                System.out.println("2.SEARCH");
                System.out.println("3.ADD_RECORDS");
                System.out.println("4.CREATE_BINARY_TREE ");
                System.out.println("5.EXPORT_TOP_20");
                System.out.println("6. Exit");
                int choice = readInt(option, "Enter your choice: ");
                
                
                switch (choice) {
                    
                    case 1: {
                        handleSort();
                    break;
                    }
                   
                    case 2: {
                       handleSearch();
                    break;   
                    }
                    
                    case 3: {
                       handleAddRecords();
                    break;
                    }
                    
                    case 4: {
                       handleCreateBinaryTree();
                    break;
                    }
                    
                    case 5: {
                        handleExportTop20();
                        break;
                    }
                    case 6: {
                        System.out.println("Exiting program. Goodbye!");
                        running = false;
                    break;
                    
                }
                default:
                    System.out.println("Invalid choice. Try again.");
                }   

            }
    
        }
        
        
        private void handleSort() {
            System.out.println("Enter file path (default: CA_2.data/Applicants_Form.txt):");
            String path = option.nextLine().trim();
            if (path.isEmpty()) {
                path = "CA_2.data/Applicants_Form.txt"; // Path use in project in txt form
            }
            java.util.List<ApplicantRecord> applicants = FileService.readApplicantsFromFile(path);
            
            if (applicants == null || applicants.isEmpty()) {
                System.out.println("No applicants loaded from file. Check the path or try another path.");
                return;
            }
            
            SortService.recursiveSortByName(applicants);
            
            int total = applicants.size();
            int limit = Math.min(20, total);
            
            System.out.println("\nShowing first " + limit + " of " + total + " applicants :");
            for (int i = 0; i < limit; i++) {
                ApplicantRecord ar = applicants.get(i);
                System.out.println((i + 1) + ". " + ar.getFullName() + " | " + ar.getManagerType() + " | " + ar.getDepartmentType());
            }
            
            cachedApplicants = applicants;
            
        }
        
        
        private static int employeeCounter = 1;
        
        private void handleAddRecords() {
            String name;
            do{
                System.out.println("insert name");
                name = option.nextLine().trim();
            } while (name.isEmpty());
            
            ManagerType[] types = ManagerType.values(); // creating manager menu
            ManagerType selectedType = null;
            
            while (selectedType == null){
                System.out.println("\nChoose Manager Type:"); // I choice to put \n to print, because will create a newline
                for (int i = 0; i < types.length; i++) {
                    System.out.println((i + 1) + ". " + types[i]);
                }
                
                int choice = readInt(option, "Choose Manager Type (1-" + types.length + "): ");
                
                if (choice >= 1 && choice <= types.length) {
                    selectedType = types[choice - 1];
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            }
            
            System.out.println("You select: " + selectedType);
            
            DepartmentType [] place = DepartmentType.values(); // creating department menu
            DepartmentType selectedPlace = null;
            
            while (selectedPlace == null){
                System.out.println("\nChoose Department Type:"); 
                for (int i = 0; i < place.length; i++) {
                    System.out.println((i + 1) + ". " + place[i]);
                }
                
                int choice = readInt(option, "Choose Department Type (1-" + place.length + "): ");
                
                if (choice >= 1 && choice <= place.length) {
                    selectedPlace = place[choice - 1];
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            }
            
            System.out.println("You select: " + selectedPlace);
            
            
            Department department = createDepartmentFromType(selectedPlace);
            
            Manager manager = new Manager(employeeCounter++, name, selectedType, department);
            
            staffRepository.addManager(manager);
            
            
            System.out.println("Name: " + name);
            System.out.println("Manager Type: " + selectedType);
            System.out.println("Department: " + selectedPlace); // This part is how is going to be the register
            
            
        }
        
        private List<ApplicantRecord> cachedApplicants = null;
        
        private void handleSearch(){
            if (cachedApplicants == null || cachedApplicants.isEmpty()) {
                System.out.println("Enter file path (default: CA_2.data/Applicants_Form.txt):");
             String path = option.nextLine().trim();
             if (path.isEmpty()) {
                path = "CA_2.data/Applicants_Form.txt";
            }
             List<ApplicantRecord> loaded = FileService.readApplicantsFromFile(path);
             if (loaded == null || loaded.isEmpty()) {
                System.out.println("No applicants loaded from file. Try another path.");
                return;
            }
             SortService.recursiveSortByName(loaded);
             cachedApplicants = loaded;
            }
            
            System.out.println("Put name to search:");
            String term =option.nextLine().trim();
            if (term.isEmpty()) {
                System.out.println("Empty search term, returning to menu.");
            }
            
            ApplicantRecord found = SearchService.searchByNameLinear(cachedApplicants, term);
            
            if (found == null) {
                System.out.println("Not exist");
            } else {
                System.out.println("Found: " + found.getFullName());
                System.out.println("Manager Type: " + found.getManagerType());
                System.out.println("Department Type: " + found.getDepartmentType());
            }
            
            
        }
        
        private void handleCreateBinaryTree (){
            if (cachedApplicants == null || cachedApplicants.isEmpty()) {
                System.out.println("Enter file path (default: CA_2.data/Applicants_Form.txt):");
                String path = option.nextLine().trim();
                if (path.isEmpty()) {
                path = "CA_2.data/Applicants_Form.txt";
                }
            
                java.util.List<ApplicantRecord> loaded = FileService.readApplicantsFromFile(path);
                if (loaded == null || loaded.isEmpty()) {
                System.out.println("No applicants loaded from file. Try another path.");
                return;
                }
                SortService.recursiveSortByName(loaded);
                cachedApplicants = loaded;
            }
            
            EmployeeBinaryTree tree = new EmployeeBinaryTree();
            int toInsert = Math.min( Math.max(20, cachedApplicants.size()), cachedApplicants.size());
            for (int i = 0; i <toInsert; i++) {
                tree.insertLevelOrder(cachedApplicants.get(i));
            }
            
            System.out.println("\nLevel-order tranversal:");
            var lines = tree.levelOrderTraversal();
            for (int i = 0; i <lines.size(); i++) {
                System.out.println((i+1) + ". " + lines.get(i));
            }
            
            System.out.println("Height: " +tree.maximun());
            System.out.println("Node Count: " + tree.nodeCount());
        }
        
        private void handleExportTop20() {
    if (cachedApplicants == null || cachedApplicants.isEmpty()) {
        System.out.println("Enter input file path (default: CA_2.data/Applicants_Form.txt):");
        String inPath = option.nextLine().trim();
        if (inPath.isEmpty()) inPath = "CA_2.data/Applicants_Form.txt";

        java.util.List<ApplicantRecord> loaded = FileService.readApplicantsFromFile(inPath);
        if (loaded == null || loaded.isEmpty()) {
            System.out.println("No data to export. Check the input file.");
            return;
        }
        SortService.recursiveSortByName(loaded);
        cachedApplicants = loaded;
    }

    System.out.println("Enter output path (default: CA_2.data/top20.txt):");
    String outPath = option.nextLine().trim();
    if (outPath.isEmpty()) outPath = "CA_2.data/top20.txt";

    try {
        FileService.writeTopNToFile(cachedApplicants, 20, outPath);
        int total = Math.min(20, cachedApplicants.size());
        System.out.println("Exported " + total + " of 20 to: " + outPath);
    } catch (Exception ex) {
        System.out.println("I/O error during export: " + ex.getMessage());
    }
}
 
        
        
        
        private static int departmentCounter = 1;

        private Department createDepartmentFromType(DepartmentType type) {
    
        Department department = new Department(departmentCounter++, type.name(), type);
        return department;
}
        
}
