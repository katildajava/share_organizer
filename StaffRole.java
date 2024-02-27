import java.util.Scanner;

public class StaffRole {
    private static int nextStaffRoleID = 1;
    private final int staffRoleID;
    private String staffRoleName;
    private static Scanner scanner = new Scanner(System.in);

    public StaffRole(String staffRoleName) {
        this.staffRoleID = nextStaffRoleID++;
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
