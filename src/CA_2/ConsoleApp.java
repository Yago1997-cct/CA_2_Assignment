/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

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
                System.out.println("5. Exit");
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
            System.out.println("Enter file path (default: CA_2.data/Applicants_Form.txt");
            String path = option.nextLine().trim();
            if (path.isEmpty()) {
                path: "CA_2.data/Applicants_Form.txt"; // Path use in project in txt form
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
                System.out.println((i + 1) + ". " + ar.getfullname() + " | " + ar.getmanagerType() + " | " + ar.getdepartmentType());
            }
            
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
        private void handleSearch(){
            System.out.println("Search select");
        }
        
        private void handleCreateBinaryTree (){
            
        }
 
        
        
        
        private static int departmentCounter = 1;

        private Department createDepartmentFromType(DepartmentType type) {
    
        Department department = new Department(departmentCounter++, type.name(), type);
        return department;
}
        
}
