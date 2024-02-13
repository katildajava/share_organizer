import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Customer extends CustomerImpl{
    String username;
    private String password;
    private String customerName;
    private String phoneNumber;
    private boolean serviceSelected;



// methods: view services, book appointment
    // Конструктор класса Customer
    public Customer( String username, String password, String customerName, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.serviceSelected = true;

    }
    public Customer(String username,String password){
        this(username,password, "", "");
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){return password;}

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    Customer customer0 = new Customer("mari123","123456","Mari","58963963");
    Customer customer1 = new Customer("tiina123","112233","Tiina", "58003658");





//------------------------------------------------------------------------------------
/*

    @Override
    public void print(){
        System.out.println("Customers: ");
        customers.forEach(System.out::println);
    }*/



    private LocalDateTime parseDateTime(String date, String time){
        // Implement parsing logic (convert date and time strings to LocalDateTime)
        // Example: LocalDateTime.parse(date + "T" + time);
        // You can use DateTimeFormatter for more robust parsing.
        // For simplicity, assume successful parsing here.
        return LocalDateTime.now();
    }
    public void bookAppointment(String date, String time, Staff staff){
        LocalDateTime appointmentDateTime = parseDateTime(date, time);
/*        if (isAppointmentAvailable(appointmentDateTime,new Hairstylist(stylist))){
            Appointment newAppointment = new Appointment(appointmentDateTime,stylist,this);
            appointments.add(newAppointment);
            System.out.println("Appointment booked successfully");
        }else{
            System.out.println("Sorry, teh selected slot is not available");
        }*/
    }
    private boolean isAppointmentAvailable(LocalDateTime appointmentDateTime, Staff staff){
        // Implement availability check:
        // - Compare with existing appointments
        // - Ensure it's in the future
        // - Consider stylist availability (e.g., working hours)
        // For demonstration, assume all slots are available initially.
        return true;
    }

    public boolean isServiceSelected() {
        return serviceSelected;
    }

    public void setServiceSelected(boolean serviceSelected) {
        this.serviceSelected = serviceSelected;
    }
/*    public String toString(){
        return "Role: " + this.role + " Name: " + this.getCustomerName() + " Phone number: " + this.getPhoneNumber();
    }*/
}