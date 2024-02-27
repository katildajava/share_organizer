import java.util.ArrayList;
import java.util.Scanner;

public class Staff {
    private static int nextStaffID = 1;
    private final int staffID;
    private String staffName;
    private double staffRate;
    private StaffRole staffRoles;
    private String staffLanguages;

    public Staff(String staffName, double staffRate, StaffRole staffRoles, String staffLanguages) {
        this.staffID = nextStaffID++;
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
    public double getStaffRate() {
        return staffRate;
    }
    public void setStaffRate(double staffRate) {
        this.staffRate = staffRate;
    }
    public StaffRole getStaffRoles() {
        return staffRoles;
    }
    public void setStaffRoles(StaffRole staffRoles) {
        this.staffRoles = staffRoles;
    }
    public String getStaffLanguages() {
        return staffLanguages;
    }
    public void setStaffLanguages(String staffLanguages) {
        this.staffLanguages = staffLanguages;
    }
    public static double getStaffRate(String staffRole) {
        double basicRate;
        return switch (staffRole) {
            case "barber" -> {
                basicRate = 30.0;
                yield basicRate;
            }
            case "hairdresser" -> {
                basicRate = 20.0;
                yield basicRate;
            }
            case "stylist" -> {
                basicRate = 50.0;
                yield basicRate;
            }
            case "colorist" -> {
                basicRate = 40.0;
                yield basicRate;
            }
            default -> {
                System.out.println("Invalid staff role. Please choose from the provided options.");
                yield 0.0;
            }
        };
    }
    protected static String inputStaffRole (Scanner scanner){
        System.out.println("Enter role( barber/hairdresser/colorist/stylist):");
        return scanner.nextLine().toLowerCase();
    }
}
