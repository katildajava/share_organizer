import java.util.List;
import java.util.Objects;

public class Appointment extends Service{
    private Integer bookingNumber;
    private Customer customer;
    private List<Service> services;
    private double totalPrice;
    private String date;
    private List<Appointment> appointments;

    Appointment(Coloring coloring) {
        super(coloring);
    }

    Appointment(MenHaircut menHaircut) {
        super(menHaircut);
    }

    Appointment(WomenHaircut womenHaircut) {
        super(womenHaircut);
    }

    Appointment(ForChildren forChildren) {
        super(forChildren);
    }

    @Override
    void makeBooking() {

    }
/*    @Override



    public Appointment(Customer customer, List<Service> services, String date, Integer bookingNumber) {

        this.customer = customer;
        this.services = services;
        this.date = date;
        this.bookingNumber = bookingNumber;
        this.totalPrice = 0.0;
        this.totalPrice = getTotalPrice();
        appointments = new ArrayList<>();
    }*/

/*    public double getTotalPrice() {
        if (this.totalPrice != 0.0)
            return this.totalPrice;
        for (Service service : services){
            this.totalPrice += service.getPrice();
        }
        return this.totalPrice;
    }*/
/*    public static Appointment registers(Integer bookingNumber,Customer customer,List<Service> services, String date){
        return new Appointment(customer,services,date,bookingNumber);
    }
    @Override
    public String toString(){
        String str = "Customer: " + this.customer.getUsername() + "\n" + "Booking number: " + this.bookingNumber.toString() + "\n" +
                "Total price is: " + this.totalPrice + "\n" + "Appointment: " + this.date;
        return str;
    }*/

}
