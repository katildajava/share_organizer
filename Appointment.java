import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Appointment {
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
    protected static void createAppointment(Scanner scanner) throws IOException {

//        ZonedDateTime dateAndTime = customerInputDateTime();
//        System.out.println("You entered " + dateAndTime);
        System.out.println("Please choose the service category you need: ");
        System.out.println("1. Coloring");
        System.out.println("2. Men Haircut");
        System.out.println("3. Women Haircut");
        System.out.println("4. For Children");
        String selectedServiceIndex = scanner.nextLine();

        switch (Integer.parseInt(selectedServiceIndex)) {
            case 1:
                System.out.println("You selected coloring services.");
                ArrayList<ServiceCategory.Coloring> categories = new ArrayList<>();
                int categoryI = 1;
                for (ServiceCategory.Coloring selectedColoring : ServiceCategory.Coloring.values()) {
                    System.out.println(categoryI + ". " +selectedColoring + " " + selectedColoring.getPrice());
                    categories.add(selectedColoring);
                    categoryI++;
                }
                System.out.println("Please choose the service you need:");
                String selectedService = scanner.nextLine();
                System.out.println("The price of the selected service is: " + categories.get(Integer.parseInt(selectedService)-1).getPrice());
                break;
            case 2:
                System.out.println("You selected men's haircut services.");
                for (ServiceCategory.MenHaircut selectedMenHaircut : ServiceCategory.MenHaircut.values()) {
                    System.out.println(selectedMenHaircut);
                }
                System.out.println("Please choose the service you need:");
                break;
            case 3:
                System.out.println("You selected women's haircut services.");
                for (ServiceCategory.WomenHaircut selectedWomenHaircut : ServiceCategory.WomenHaircut.values()) {
                    System.out.println(selectedWomenHaircut);
                }
                System.out.println("Please choose the service you need:");
                break;
            case 4:
                System.out.println("You selected services for children.");
                for (ServiceCategory.ForChildren selectedForChildren : ServiceCategory.ForChildren.values()) {
                    System.out.println(selectedForChildren);
                }
                System.out.println("Please choose the service you need:");
                break;
            default:
                System.out.println("Invalid service category.");
                break;
        }
        scanner.nextLine();
        String selectedService = scanner.nextLine();
        System.out.println("You selected service:" + selectedService);

    }
    protected static void makeChanges(Scanner scanner){

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
/*    public static Appointment reservation(int appointmentID, Customer customer, ArrayList<Service> services,
                                          Staff staff, ZonedDateTime appointmentTimestamp ){
        return new Appointment(customer,services,staff,appointmentTimestamp);
    }*/

    protected static ZonedDateTime customerInputDateTime() throws IOException{
        System.out.println("Please enter the date and time (dd/MM/yy HH:mm) when you prefer to make a booking");
        ZonedDateTime zonedDateTime;
        while(true){
            try{
                String[] customerInputArray = scanner.nextLine().replaceAll("[^1-9/: ]","").split("[: /]");
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
/*    private static boolean customerInputChoice(String askCustomer){
        System.out.println(askCustomer);
        String customerInput = choise.nextLine();
        return customerInput.contains("+");
    }*/


}
