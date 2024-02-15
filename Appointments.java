import java.util.ArrayList;

public class Appointments {
    private static int nextAppointmentsID = 1;
    private int appointmentsID;
    private ArrayList<Appointment> appointments;
    private Customer customer;

    public Appointments(ArrayList<Appointment> appointments, Customer customer) {
        if (appointments.isEmpty()) {
            throw new IllegalArgumentException("Appointments list cannot be empty.");
        }
        this.appointmentsID = nextAppointmentsID++;
        this.appointments = appointments;
        this.customer = customer;
    }

    // Getters and setters
    public int getAppointmentsID() {
        return appointmentsID;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        if (appointments.isEmpty()) {
            throw new IllegalArgumentException("Appointments list cannot be empty.");
        }
        this.appointments = appointments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
