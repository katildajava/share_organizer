import java.util.Arrays;

public class Staff implements StaffRepository{
    private int id;
    private String name;
    private Role role;
    private String[] languages;

    public Staff(int id, String name, Role role, String[] languages) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.languages = languages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
    public String toString() {
        return "Name: " + this.getName() + " Role: " + this.role + " Spoken languages: " + Arrays.toString(this.languages);
    }


/*--------------------------------------------------------------------------------------------------*/


    @Override
    public void performHaircut(Customer customer){

    }

}
