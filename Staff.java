import java.util.ArrayList;

public class Staff {
    private static int nextID = 1;

    private final int staffID;
    private String staffName;
    private int staffRate;
    private ArrayList<StaffRole> staffRoles;
    private String staffLanguages;

    public Staff(String staffName, int staffRate, ArrayList<StaffRole> staffRoles, String staffLanguages) {
        this.staffID = nextID++;
        this.staffName = staffName;
        this.staffRate = staffRate;
        this.staffRoles = staffRoles;
        this.staffLanguages = staffLanguages;
    }

    // Getters and setters

    public int getStaffID() {
        return staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getStaffRate() {
        return staffRate;
    }

    public void setStaffRate(int staffRate) {
        this.staffRate = staffRate;
    }

    public ArrayList<StaffRole> getStaffRoles() {
        return staffRoles;
    }

    public void setStaffRoles(ArrayList<StaffRole> staffRoles) {
        this.staffRoles = staffRoles;
    }

    public String getStaffLanguages() {
        return staffLanguages;
    }

    public void setStaffLanguages(String staffLanguages) {
        this.staffLanguages = staffLanguages;
    }
}
