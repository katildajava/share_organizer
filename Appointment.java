import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Appointment {
    private static final String APPOINTMENT_FILE = "Appointment.json";
    private static int nextAppointmentID = 1;
    private final int appointmentID;
    private Customer customer;
    private ArrayList<Service> services;
    private Staff staff;
    private ZonedDateTime appointmentTimestamp;
    private int appointmentPrice;
    private int appointmentProfitRate;
    private static Scanner scanner = new Scanner(System.in);
    private static Scanner choise = new Scanner(System.in); //add more appointments

    public Appointment(Customer customer, ArrayList<Service> services, Staff staff, ZonedDateTime appointmentTimestamp) {
        this.customer = customer;
        this.appointmentID = nextAppointmentID++;
        this.services = services;
        this.staff = staff;
        this.appointmentTimestamp = appointmentTimestamp;
        this.appointmentPrice = appointmentPrice;
        this.appointmentProfitRate = appointmentProfitRate;
    }

    // Getters and setters
    public int getAppointmentID() {
        return appointmentID;
    }
    public ArrayList<Service> getServices() {
        return services;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public ZonedDateTime getAppointmentTimestamp() {
        return appointmentTimestamp;
    }

    public void setAppointmentTimestamp(ZonedDateTime appointmentTimestamp) {
        this.appointmentTimestamp = appointmentTimestamp;
    }

    public int getAppointmentPrice() {
        if (this.appointmentPrice != 0)
            return this.appointmentPrice;
        for (Service service : services){
            this.appointmentPrice += service.getServicePrice();
        }
        return this.appointmentPrice;
    }

    public void setAppointmentPrice(int appointmentPrice) {
        this.appointmentPrice = appointmentPrice;
    }

    public int getAppointmentProfitRate() {
        return appointmentProfitRate;
    }

    public void setAppointmentProfitRate(int appointmentProfitRate) {
        this.appointmentProfitRate = appointmentProfitRate;
    }
    private static ArrayList<JsonObject> readAppointmentFromFile() throws IOException{
        ArrayList<JsonObject> appointmentsArray = new ArrayList<>(); // create ArrayList to store customers data
        File file = new File(APPOINTMENT_FILE); // create file object for the customers file
        if (file.exists()){ // check if the file exists
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
                JsonArray jsonArray = JsonParser.parseReader(bufferedReader).getAsJsonArray(); // parse file content to a JSON array
                for (var jasonElement : jsonArray){ // iterate through JSON array
                    appointmentsArray.add(jasonElement.getAsJsonObject()); // add each JSON object to the ArrayList
                }
            }
        }
        return appointmentsArray; // return the ArrayList of customer data
    }

    private static void writeCustomerToFile(ArrayList<JsonObject> appointmentsArray) throws IOException{
        try(FileWriter writer = new FileWriter(APPOINTMENT_FILE)){ // Create a FileWriter for the customers file
            writer.write(new GsonBuilder().setPrettyPrinting().create().toJson(appointmentsArray)); // Write the ArrayList of customer data to the file as JSON
        }
    }
    protected static void createAppointment(Scanner scanner) throws IOException {

        ZonedDateTime dateAndTime = customerInputDateTime();
        System.out.println("You entered " + dateAndTime);

        System.out.println("Please choose the service category you need: ");
        System.out.println("1. Coloring \n2. Male services \n3. Female services \n4. Child services");

        String selectedServiceIndex = scanner.nextLine();

        String[] chosenServiceSpecialistRoles = null;

        switch (Integer.parseInt(selectedServiceIndex)) {
            case 1:
                System.out.println("You selected coloring services.");
                ArrayList<ServiceCategory.Coloring> coloringCategories = new ArrayList<>();
                int coloringIndex = 1;
                for (ServiceCategory.Coloring selectedColoring : ServiceCategory.Coloring.values()) {
                    System.out.println(coloringIndex + ". " +selectedColoring + " " + selectedColoring.getPrice());
                    coloringCategories.add(selectedColoring);
                    coloringIndex++;
                }
                System.out.println("Please choose the service you need:");
                String coloringSelectedService = scanner.nextLine();
                System.out.println("The price of the selected service is: " + coloringCategories.get(Integer.parseInt(coloringSelectedService)-1).getPrice());
                chosenServiceSpecialistRoles = coloringCategories.get(Integer.parseInt(coloringSelectedService)-1).getStaffRole();
                break;
            case 2:
                System.out.println("You selected men's haircut services.");
                ArrayList<ServiceCategory.MenHaircut> maleCategories = new ArrayList<>();
                int maleHaircutIndex = 1;
                for (ServiceCategory.MenHaircut selectedMenHaircut : ServiceCategory.MenHaircut.values()) {
                    System.out.println(maleHaircutIndex + ". " + selectedMenHaircut + " " + selectedMenHaircut.getPrice());
                    maleCategories.add(selectedMenHaircut);
                    maleHaircutIndex++;
                }
                System.out.println("Please choose the service you need:");
                String forMenSelectedService = scanner.nextLine();
                System.out.println("The price of the selected service is: " + maleCategories.get(Integer.parseInt(forMenSelectedService)-1).getPrice());
                chosenServiceSpecialistRoles = maleCategories.get(Integer.parseInt(forMenSelectedService)-1).getStaffRole();
                break;
            case 3:
                System.out.println("You selected women's haircut services.");
                ArrayList<ServiceCategory.WomenHaircut> femaleCategories = new ArrayList<>();
                int femaleHaircutIndex = 1;
                for (ServiceCategory.WomenHaircut selectedWomenHaircut : ServiceCategory.WomenHaircut.values()) {
                    System.out.println(femaleHaircutIndex + ". " + selectedWomenHaircut + " " + selectedWomenHaircut.getPrice());
                    femaleCategories.add(selectedWomenHaircut);
                    femaleHaircutIndex++;
                }
                System.out.println("Please choose the service you need:");
                String forWomenSelectedService = scanner.nextLine();
                System.out.println("The price of the selected service is: " + femaleCategories.get(Integer.parseInt(forWomenSelectedService)-1).getPrice());
                chosenServiceSpecialistRoles = femaleCategories.get(Integer.parseInt(forWomenSelectedService)-1).getStaffRole();
                break;
            case 4:
                System.out.println("You selected services for children.");
                ArrayList<ServiceCategory.ForChildren> childServiceCategories = new ArrayList<>();
                int childServiceIndex = 1;
                for (ServiceCategory.ForChildren selectedForChildren : ServiceCategory.ForChildren.values()) {
                    System.out.println(childServiceIndex + ". " + selectedForChildren + " " + selectedForChildren.getPrice());
                    childServiceCategories.add(selectedForChildren);
                    childServiceIndex++;
                }
                System.out.println("Please choose the service you need:");
                String forKidsSelectedService = scanner.nextLine();
                System.out.println("The price of the selected service is: " + childServiceCategories.get(Integer.parseInt(forKidsSelectedService)-1).getPrice());
                chosenServiceSpecialistRoles = childServiceCategories.get(Integer.parseInt(forKidsSelectedService)-1).getStaffRole();
                break;
            default:
                System.out.println("Invalid service category.");
                break;
        }
        System.out.println("Choose a specialist: ");
        try {
            // Read the JSON file
            String content = new String(Files.readAllBytes(Paths.get("Staff.json")));
            Gson gson = new Gson();


            Type staffListType = new TypeToken<ArrayList<Staff>>(){}.getType();
            ArrayList<Staff> staffList = gson.fromJson(content, staffListType);
            assert chosenServiceSpecialistRoles != null;
            for (String role: chosenServiceSpecialistRoles){
                for (Staff staff: staffList){
                    if(staff.getStaffRoles().getStaffRoleName().trim().equalsIgnoreCase(role.trim())){
                        System.out.println(staff.getStaffName());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        };
        String staff = scanner.nextLine();

        System.out.println(staff + " will serve you");

        /*JsonObject appointmentJson = new JsonObject();
        appointmentJson.addProperty("appointmentID", nextAppointmentID);
        appointmentJson.addProperty("customerId", Customer.nextCutomerID);
        appointmentJson.addProperty("date and time", String.valueOf(dateAndTime));
        appointmentJson.addProperty("service category", Arrays.toString(ServiceCategory.values()));
        appointmentJson.addProperty("service",Service.);*/


    }

    protected static void deleteAppointment(Scanner scanner) throws IOException {


    }
    public String bookingInfoForCustomer(){
        return "ID: " + appointmentID + "\nService: " + services +
                "\nStaff: " + staff + "\nDate and time: " + appointmentTimestamp +
                "\nService Price: " + appointmentPrice;
    }
    public String bookingInfoForManager(){
        return  "AppointmentID: " + appointmentID +"\nService: " + services +
                "\nStaff: " + staff + "\nDate and time: " + appointmentTimestamp +
                "\nAppointment Profit Rate: " + appointmentProfitRate;
    }

    protected static ZonedDateTime customerInputDateTime() throws IOException{
        System.out.println("Please enter the date and time (dd/MM/yy HH:mm) when you prefer to make a booking");
        ZonedDateTime zonedDateTime;
        while(true){
            try{
                String[] customerInputArray = scanner.nextLine().replaceAll("[^0-9/: ]","").split("[: /]");
                System.out.println(Arrays.toString(customerInputArray));
                zonedDateTime = ZonedDateTime.of(2000+Integer.parseInt(customerInputArray[2]),
                        Integer.parseInt(customerInputArray[1]),
                        Integer.parseInt(customerInputArray[0]),
                        Integer.parseInt(customerInputArray[3]),
                        Integer.parseInt(customerInputArray[4]), 0, 0, ZoneId.systemDefault());
                if (zonedDateTime.compareTo(ZonedDateTime.now()) < 0){
                    System.out.println("Please enter the date and time: ");
                }else{
                    break;
                }
            }catch (DateTimeParseException e){
                System.out.println("This is not correct date and time, please try again.");
            }
        }
        return zonedDateTime;
    }
    private static boolean customerInputChoice(Scanner scanner){
        System.out.println("Would you like to add one more appointment? ('+' = yes)");
        String customerInput = choise.nextLine();
        return customerInput.contains("+");
    }


}
