package Example;

import java.util.ArrayList;

public class Service {
    private static int nextServiceID = 1;  // as an example only, fix this when working with existing data.
    private final int serviceID;
    private ServiceCategory serviceCategory;
    private String serviceName;
    private int servicePrice;
    private int serviceMinutes;
    private ArrayList<Integer> serviceBlockers;
    private ArrayList<StaffRole> staffRoles;

    public Service(ServiceCategory serviceCategory, String serviceName, int servicePrice, int serviceMinutes, ArrayList<Integer> serviceBlockers, ArrayList<StaffRole> staffRoles) {
        this.serviceID = nextServiceID++;
        this.serviceCategory = serviceCategory;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.serviceMinutes = serviceMinutes;
        this.serviceBlockers = serviceBlockers;
        this.staffRoles = staffRoles;
    }

    // Getters and setters

    public int getServiceID() {
        return serviceID;
    }

    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public int getServiceMinutes() {
        return serviceMinutes;
    }

    public void setServiceMinutes(int serviceMinutes) {
        this.serviceMinutes = serviceMinutes;
    }

    public ArrayList<Integer> getServiceBlockers() {
        return serviceBlockers;
    }

    public void setServiceBlockers(ArrayList<Integer> serviceBlockers) {
        this.serviceBlockers = serviceBlockers;
    }

    public ArrayList<StaffRole> getStaffRoles() {
        return staffRoles;
    }

    public void setStaffRoles(ArrayList<StaffRole> staffRoles) {
        this.staffRoles = staffRoles;
    }
}