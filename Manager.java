import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void addService(Service.ServiceCategory category, Service plusOneService) {
        plusOneService.setCategory(category); //set the category for the new service
        services.add(plusOneService); //add the new service to the list of services
    }
    public void deleteService(Service service) {  // method to delete a service
        services.remove(service);    // remove the specified service from the list
    }
    public List<Service> findServiceCategory(Service.ServiceCategory category) { //find services by category
        List<Service> matchingServices = new ArrayList<>();
        for (Service service : services) {
            if (service.getServiceCategory() == category) {
                matchingServices.add(service); // add the matching service to the list
            }
        }
        return matchingServices; // return the list of matching services
    }
    public boolean doesServiceExist(String serviceName) { //check if a service exists by name
        for (Service service : services) {
            if (service.getServiceName().equals(serviceName)) {
                return true; // return true if the service exists
            }
        }
        return false; // return false if the service doesn't exist
    }
    public Service getServiceByName(String serviceName) { //get a service by name
        for (Service service : services) {
            if (service.getServiceName().equals(serviceName)) {
                return service;  //return the matching service
            }
        }
        return null;  //return null if no matching service is found
    }

    public void updatePrice(Service service, int newServicePrice){
        service.setServicePrice(newServicePrice); // set new price for the needed service
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
