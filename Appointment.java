import java.time.LocalDateTime;

public class Appointment {
    private static int nextAppointmentID = 1;
    private int appointmentID;
    private Service service;
    private Staff staff;
    private LocalDateTime appointmentTimestamp;
    private int appointmentPrice;
    private int appointmentProfitRate;

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

    public LocalDateTime getAppointmentTimestamp() {
        return appointmentTimestamp;
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
}
