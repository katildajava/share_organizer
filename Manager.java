public class Manager {
    private static int nextID = 1;

    private int managerID;
    private String managerName;

    public Manager(String managerName) {
        this.managerID = nextID++;
        this.managerName = managerName;
    }

    // Getters and setters

    public int getManagerID() {
        return managerID;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

}
