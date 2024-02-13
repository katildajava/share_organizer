import java.util.ArrayList;

public class Manager{
    private String name;
    private Role role;


    public Manager(String name, Role role) {
        this.name = name;
        this.role = role;
    }
    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String toString(){
        return "Name: " + this.getName() + " Role: " + this.role;
    }
}
