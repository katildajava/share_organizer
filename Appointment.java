import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Appointment {
    private static int nextAppointmentID = 1;
    private final int appointmentID;
    private Service service;
    private Staff staff;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm");
    private LocalDateTime appointmentTimestamp;
    private int appointmentPrice;
    private int appointmentProfitRate;
    private static Scanner scanner = new Scanner(System.in);
    private static Scanner choise = new Scanner(System.in); //add more appointments

    public Appointment(Service service, Staff staff, LocalDateTime appointmentTimestamp, int appointmentPrice, int appointmentProfitRate) {
        this.appointmentID = nextAppointmentID++;
        this.service = service;
        this.staff = staff;
        this.appointmentTimestamp = appointmentTimestamp;
        this.appointmentPrice = appointmentPrice;
        this.appointmentProfitRate = appointmentProfitRate;
    }

    // Getters and setters
    public int getAppointmentID() {
        return appointmentID;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getAppointmentTimestamp() {
        return formatter.format(appointmentTimestamp);
    }

    public void setAppointmentTimestamp(LocalDateTime appointmentTimestamp) {
        this.appointmentTimestamp = appointmentTimestamp;
    }

    public int getAppointmentPrice() {
        return appointmentPrice;
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
    public String toStringForCustomer(){
        return "ID: " + appointmentID + "\nService: " + service +
                "\nStaff: " + staff + "\nDate and time: " + appointmentTimestamp +
                "\nService Price: " + appointmentPrice;
    }
    public String toStringForManager(){
        return  "AppointmentID: " + appointmentID +"\nService: " + service +
                "\nStaff: " + staff + "\nDate and time: " + appointmentTimestamp +
                "\nAppointment Profit Rate: " + appointmentProfitRate;
    }
    private static String customerInputString(String askCustomer){
        System.out.println(askCustomer);
        return scanner.nextLine();
    }

    private static LocalDateTime customerInputDateTime(String askCustomer){
        System.out.println(askCustomer);
        LocalDateTime localDateTime;
        while(true){
            try{
                String customerInput = scanner.nextLine().replaceAll("[^0-9]","");
                localDateTime = LocalDateTime.parse(customerInput, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));
                if (localDateTime.isBefore(LocalDateTime.now())){
                    System.out.println("Please enter the date and time: ");
                }else{
                    break;
                }
            }catch (DateTimeParseException e){
                System.out.println("This is not correct date and time, please try again.");
            }
        }
        return localDateTime;
    }
    private static boolean customerInputChoice(String askCustomer){
        System.out.println(askCustomer);
        String customerInput = choise.nextLine();
        return customerInput.contains("+");
    }

}
