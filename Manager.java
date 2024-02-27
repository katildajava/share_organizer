
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Manager {
    private static int nextID = 1;
    private final int managerID;
    private String managerName, managerUsername, managerPassword;
    private static final String MANAGER_FILE = "Manager.json";
    private static final String STAFF_FILE = "Staff.json";
    protected ArrayList<Staff> staffList = new ArrayList<>();
    protected ArrayList<Service> services = new ArrayList<>();

    public Manager(String managerName, String managerUsername, String managerPassword) {
        this.managerID = nextID++;
        this.managerName = managerName;
        this.managerUsername = managerUsername;
        this.managerPassword = managerPassword;
    }

    public int getManagerID() {
        return managerID;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerUsername() {
        return managerUsername;
    }

    public void setManagerUsername(String managerUsername) {
        this.managerUsername = managerUsername;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    private static ArrayList<JsonObject> readManagerFromFile() throws IOException {
        ArrayList<JsonObject> managerJ = new ArrayList<>(); //// create ArrayList to store
        File fileManager = new File(MANAGER_FILE); //create file object for MANAGER file
        if (fileManager.exists()) { //check if the file exists
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileManager))) {
                JsonArray jsonArray = JsonParser.parseReader(bufferedReader).getAsJsonArray(); //read content from file and parse it to JSON
                for (var jasonElement : jsonArray) { // iterate through JSON array
                    managerJ.add(jasonElement.getAsJsonObject()); // add each JSON object to the ArrayList
                }
            }
        }
        return managerJ;
    }

    private static void writeManagerToFile(ArrayList<JsonObject> managerJ) throws IOException {
        try (FileWriter writer = new FileWriter(MANAGER_FILE)) {
            writer.write(new Gson().toJson(managerJ));
        }
    }

    public static void loginManager(Scanner scanner) throws IOException {
        try {
            System.out.println("Enter username:");
            String username = scanner.nextLine();
            System.out.println("Enter password");
            String password = scanner.nextLine();
            ArrayList<JsonObject> managerJ = readManagerFromFile();// read existing manager from the file, if it exists

            boolean userExists = false;
            for (JsonObject manager : managerJ) {
                if (manager.has("username") && manager.get("username").getAsString().equals(username)) {// check if the username exists
                    userExists = true;
                    if (manager.has("password") && manager.get("password").getAsString().equals(password)) {// check password matching
                        System.out.println("Logged in successfully!");
                    } else {
                        System.out.println("Incorrect password.");
                    }
                    break;
                }
            }
            if (!userExists) {
                System.out.println("User not found.");
                loginManager(scanner);
            }
        } catch (IOException e) {
            System.out.println("Error reading manager file.");
        }
    }

    public static void createManager(Scanner scanner) throws IOException {
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        scanner.nextLine(); // Consume the newline character

        Manager manager = new Manager(name, username, password); // Create a manager object

        ArrayList<JsonObject> managerJ = readManagerFromFile();//read existing customers from the file if it exists

        JsonObject newManager = new JsonObject();// create Json object for the new customer
        newManager.addProperty("name", name);//add password as a property with the specified value
        newManager.addProperty("username", username); // _____^
        newManager.addProperty("password", password); // _____^

        managerJ.add(newManager); //add new manager to the array

        writeManagerToFile(managerJ);
        System.out.println("Nice to meet you " + manager.getManagerName() + ". Welcome to our team!");
    }

    private static void chooseAnOption() {
        System.out.println("Choose an option:");
    }

    public static void managerMenu(Scanner scanner) throws IOException {
        chooseAnOption();
        System.out.println("1. Add new manager \n2. Add Staff \n3. Remove staff \n4. Add Service \n5. Update Price \n 6. Remove Service \n7. Exit ");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        switch (option) {
            case 1:
                createManager(scanner);
                break;
            case 2:
                createStaff(scanner);
                break;
            case 3:
                deleteStaff(scanner);
                break;
/*            case 4:
                addService(scanner);
                break;
            case 5:
                updatePrice(scanner);
                break;
            case 6:
                deleteService(scanner);
                break;*/
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    private static ArrayList<JsonObject> readStaffFromFile() throws IOException {
        ArrayList<JsonObject> staffArray = new ArrayList<>(); // create ArrayList to store staff data
        File file = new File(STAFF_FILE); // create file object for the staff file
        if (file.exists()) { // check if the file exists
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                JsonArray jsonArray = JsonParser.parseReader(bufferedReader).getAsJsonArray(); // parse file content to a JSON array
                for (var jasonElement : jsonArray) { // iterate through JSON array
                    staffArray.add(jasonElement.getAsJsonObject()); // add each JSON object to the ArrayList
                }
            }
        }
        return staffArray; // return the ArrayList of customer data
    }

    private static void writeStaffToFile(ArrayList<JsonObject> staffArray) throws IOException {
        try (FileWriter writer = new FileWriter(STAFF_FILE)) { // Create a FileWriter for the staff file
            writer.write(new Gson().toJson(staffArray)); // Write the ArrayList of staff data to the file as JSON
        }
    }

    private static void createStaff(Scanner scanner) throws IOException {
        try {
            System.out.println("Enter staff name:");
            String name = scanner.nextLine();

            String sRole = Staff.inputStaffRole(scanner);

            double rate = Staff.getStaffRate(sRole);
            System.out.println("Basic staff rate for " + sRole + " " + name + " is:" + rate);

            System.out.println("Enter staff languages:");
            String languages = scanner.nextLine();

            StaffRole role = new StaffRole(sRole); //create staffRole object
            Staff staff = new Staff(name, rate, role, languages); //create staff object

            ArrayList<JsonObject> staffArray = readStaffFromFile(); //read existing staff from the file, if it exists

            JsonObject newStaff = new JsonObject(); //create Json object for the new customer
            newStaff.addProperty("name", name); //properties with specified value
            newStaff.addProperty("rate", rate);
            newStaff.addProperty("role", sRole);
            newStaff.addProperty("languages", languages);

            staffArray.add(newStaff); //add new staff to array

            writeStaffToFile(staffArray); //write staff data to the file

            System.out.println("Staff created: " + staff.getStaffName());
        } catch (IOException e) {
            System.out.println("Error handling staff data: " + e.getMessage());
        }
        managerMenu(scanner);
    }

    public static void deleteStaff(Scanner scanner) throws IOException {
        try {
            System.out.println("Enter staff name:");
            String name = scanner.nextLine();

            ArrayList<JsonObject> staffArray = readStaffFromFile(); // read staff data from the file

            Iterator<JsonObject> iterator = staffArray.iterator(); // use iterator to remove staff from list
            while (iterator.hasNext()) {
                JsonObject staffJson = iterator.next();
                if (staffJson.get("name").getAsString().equals(name)) {
                    iterator.remove(); //remove the element from the list
                    writeStaffToFile(staffArray); // update file with modified list
                    System.out.println("Staff deleted: " + name);
                    return;
                }
            }
            System.out.println("Staff not found: " + name);
        } catch (IOException e) {
            System.err.println("Error handling staff data: " + e.getMessage());
        }
        managerMenu(scanner);
    }
       /* public static void addService(Scanner scanner) throws IOException{

        System.out.println("Enter Service Category:");
        String inputCategory = in.readLine();

        System.out.println("Enter Service Name:");
        String inputServiceName = in.readLine();

        System.out.println("Enter price:");
        String inputPrice = Integer.parseInt(in.readLine());

        services.setCategory(inputCategory); //set the category for the new service
        services.add(inputServiceName); //add the new service to the list of services
        services.add(inputPrice);

    }
    public static void updatePrice(Scanner scanner) {
    }
    public void deleteService(Scanner scanner) {  // method to delete a service
        if (doesServiceExist(service.getServiceName())) {
            services.remove(service.getServiceName());    // remove the specified service from the list
        }
    }
*/
/*    public static boolean doesServiceExist(String serviceName) { //check if a service exists by name
        for (Service service : services) {
            if (service.getServiceName().equals(serviceName)) {
                return true; // return true if the service exists
            }
        }
        return false; // return false if the service doesn't exist
    }*/


    public List<Service> findServiceCategory(ServiceCategory category) { //find services by category
        List<Service> matchingServices = new ArrayList<>();
        for (Service service : services) {
            if (service.getServiceCategory() == category) {
                matchingServices.add(service); // add the matching service to the list
            }
        }
        return matchingServices; // return the list of matching services
    }

    public Service getServiceByName(String serviceName) { //get a service by name
        for (Service service : services) {
            if (service.getServiceName().equals(serviceName)) {
                return service;  //return the matching service
            }
        }
        return null;  //return null if no matching service is found
    }

    public void updatePrice(Service service, int newServicePrice) {
        service.setServicePrice(newServicePrice); // set new price for the needed service
    }

}