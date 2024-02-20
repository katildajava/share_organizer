import java.util.ArrayList;

public class Manager {
    private static int nextID = 1;

    private final int managerID;
    private String managerName;
    protected ArrayList<Staff> staffList = new ArrayList<>();
    protected ArrayList<Service> services = new ArrayList<>();
    public Manager(String managerName) {
        this.managerID = nextID++;
        this.managerName = managerName;
    }

    public int getManagerID() {
        return managerID;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    public void addService(Service service){
        services.add(service);
    }
    public void deleteService(Service service){
        services.remove(service);
    }
    public static Service findService(String serviceName){
        System.out.println("Service: " + serviceName);
        return null;
    }
    public Service updatePrice(Service service){
        return findService(service.getServiceName());
    }
    public void addStaff(Staff staff){
        staffList.add(staff);
    }
    public void deleteStaff(Staff staff){
        staffList.remove(staff);
    }

    public static void main(String[] args) {

    }
}
