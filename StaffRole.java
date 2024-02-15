public class StaffRole {
    private static int nextID = 1;

    private final int staffRoleID;
    private String staffRoleName;

    public StaffRole(String staffRoleName) {
        this.staffRoleID = nextID++;
        this.staffRoleName = staffRoleName;
    }

    // Getters and setters

    public int getStaffRoleID() {
        return staffRoleID;
    }

    public String getStaffRoleName() {
        return staffRoleName;
    }

    public void setStaffRoleName(String staffRoleName) {
        this.staffRoleName = staffRoleName;
    }
}
