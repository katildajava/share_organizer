package Example;

public class StaffRole {
    private static int nextStaffRoleId = 1;  // as an example only, fix this when working with existing data.
    private int staffRoleId;
    private String staffRoleName;

    public StaffRole(String staffRoleName) {
        this.staffRoleId = nextStaffRoleId++;
        this.staffRoleName = staffRoleName;
    }

    public int getStaffRoleId() {
        return staffRoleId;
    }

    public String getStaffRoleName() {
        return staffRoleName;
    }
}