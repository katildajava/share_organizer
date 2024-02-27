
import java.util.ArrayList;

public class Appointments {
    private static int nextAppointmentsID = 1;
    private final int appointmentsID;
    private ArrayList<Appointment> appointments;
    private Customer customer;

    public Appointments(Customer customer) {
        this.appointmentsID = nextAppointmentsID++;
        this.appointments = new ArrayList<>();
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

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }    // Add an appointment to the list


    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }// Remove an appointment from the list

    // Generate a unique appointments ID
}
