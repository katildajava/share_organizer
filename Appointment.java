import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm");
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
    public static Appointment reservation(int appointmentID, Customer customer, ArrayList<Service> services,
                                          Staff staff, ZonedDateTime appointmentTimestamp ){
        return new Appointment(customer,services,staff,appointmentTimestamp);
    }
    private static String customerInputString(String askCustomer){
        System.out.println(askCustomer);
        return scanner.nextLine();
    }

    private static ZonedDateTime customerInputDateTime(String askCustomer){
        System.out.println(askCustomer);
        ZonedDateTime zonedDateTime;
        while(true){
            try{
                String customerInput = scanner.nextLine().replaceAll("[^0-9]","");
                zonedDateTime = ZonedDateTime.parse(customerInput, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
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
    private static boolean customerInputChoice(String askCustomer){
        System.out.println(askCustomer);
        String customerInput = choise.nextLine();
        return customerInput.contains("+");
    }


}
