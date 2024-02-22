package Example;

import java.util.ArrayList;

public class Staff {
    private static int nextStaffId = 1;  // as an example only, fix this when working with existing data.
    private int staffId;
    private String staffName;
    private int staffRate;
    private ArrayList<StaffRole> staffRoles;
    private String staffLanguages;

    public Staff(String staffName, int staffRate, ArrayList<StaffRole> staffRoles, String staffLanguages) {
        this.staffId = nextStaffId++;
        this.staffName = staffName;
        this.staffRate = staffRate;
        this.staffRoles = staffRoles;
        this.staffLanguages = staffLanguages;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public int getStaffRate() {
        return staffRate;
    }

    public ArrayList<StaffRole> getStaffRoles() {
        return staffRoles;
    }

    public String getStaffLanguages() {
        return staffLanguages;
    }
}