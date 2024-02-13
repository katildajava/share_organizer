public interface ManagerRepository {

    void addService(Service service);

    void scheduleAppointment(String date, String time, Staff staff, Customer customer);

    void deleteService(Service service);

    void addStaff(Staff staff);

    void deleteStaff(Staff staff);
}
