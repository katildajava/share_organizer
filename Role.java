public class Role{
    private String role;

    public Role(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String toString(){
        return "Role: " + this.role;
    }


}