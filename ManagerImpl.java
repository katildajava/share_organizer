import java.util.ArrayList;

public class ManagerImpl  implements ManagerRepository{
    protected ArrayList<Staff> staffList = new ArrayList<>();
    protected ArrayList<Service> services = new ArrayList<>();


    @Override
    public void addService(Service service){
        services.add(service);
    }
    @Override
    public void deleteService(Service service){
        services.remove(service);
    }
    @Override
    public void addStaff(Staff staff){
        staffList.add(staff);
    }

    @Override
    public void deleteStaff(Staff staff){
        staffList.remove(staff);

    }
    @Override
    public void scheduleAppointment(String date, String time, Staff staff, Customer customer){

    }
}
