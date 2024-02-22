import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Service {
    private static int nextServiceID = 1; // start with 1 and increment for each new service
    private static int serviceID;
    private ServiceCategory serviceCategory;
    private String serviceName;
    private int servicePrice;
    private int serviceMinutes;
    private ArrayList<Integer> serviceBlockers;
    private ArrayList<StaffRole> staffRoles;
    ServiceCategory.Coloring coloring;
    ServiceCategory.MenHaircut menHaircut;
    ServiceCategory.WomenHaircut womenHaircut;
    ServiceCategory.ForChildren forChildren;

    public Service(ServiceCategory serviceCategory, String serviceName, int servicePrice, int serviceMinutes) {
        this.serviceID = nextServiceID++;
        this.serviceCategory = serviceCategory;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.serviceMinutes = serviceMinutes;
    }
    public int getServiceID() {
        return serviceID;
    }

    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public int getServiceMinutes() {
        return serviceMinutes;
    }

    public ArrayList<Integer> getServiceBlockers() {
        return serviceBlockers;
    }

    public ArrayList<StaffRole> getStaffRoles() {
        return staffRoles;
    }

    public void setStaffRoles(ArrayList<StaffRole> staffRoles) {
        this.staffRoles = staffRoles;
    }

    public void update(String serviceName) {
        this.serviceName = getServiceName();
        this.servicePrice = getServicePrice();
    }

    public void setCategory(ServiceCategory category) {
    }



    // Enum for service category
    enum ServiceCategory {
        COLORING,
        MEN_HAIRCUT,
        WOMAN_HAIRCUT,
        FOR_CHILDREN;
        ServiceCategory() {
/*            this.coloring = coloring;
            this.menHaircut = menHaircut;
            this.womenHaircut = womenHaircut;
            this.forChildren = forChildren;*/
        }
        enum Coloring{
            CONSULTING(20), BLONDE_OUTGROWTH(95), BLONDE_SHORT_HAIR(105), BLONDE_MEDIUM_HAIR(125),
            BLONDE_LONG_HAIR(160), COLORING_SHORT_HAIR(65), COLORING_MEDIUM_HAIR(75), COLORING_LONG_HAIR(100),
            TONING(30), MENS_HAIR_COLORING(65);
            private final int price;
            Coloring(int price){
                this.price = price;
            }
            public int getPrice() {
                return price;
            }

        }
        enum MenHaircut{
            MACHINE_CUT(23), SCISSORS_CUT(30), BEARD_AND_MUSTACHE(15), HAIR_TATTOO(20);
            private final int price;
            MenHaircut(int price){
                this.price = price;
            }
            public int getPrice() {
                return price;
            }
        }
        enum WomenHaircut{
            HAIRCUT(45),HOT_SCISSORS_CUT(50),STYLE_CHANGE(50), ENDS(30), BANG(10);
            private final int price;
            WomenHaircut(int price){
                this.price = price;
            }
            public int getPrice() {
                return price;
            }
        }
        enum ForChildren{
            BOYS_HAIRCUT(25),GIRLS_HAIRCUT(30), GIRLS_ENDS_CUT(20);
            private final int price;
            ForChildren(int price){
                this.price = price;
            }
            public int getPrice() {
                return price;
            }
        }

    }

    public static void findServiceCategory(ServiceCategory category){
        findServiceCategory(category);
    }
    public static void findService(ServiceCategory.Coloring coloring){
        ServiceCategory.Coloring.valueOf("");
    }
}
