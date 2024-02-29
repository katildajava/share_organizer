
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.management.relation.Role;
import java.io.*;
import java.util.*;

public class SalonMain {
    private static final String CUSTOMERS_FILE = "Customers.json";
    private static final String MANAGER_FILE = "Manager.json";
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option: \n1. Log in \n2. Create an Account \n3. Settings");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (option) {
            case 1:
                Customer.login(scanner);
                break;
            case 2:
                Customer.createCustomer(scanner);
                break;
            case 3:
                System.out.println("The settings are accessible only to the salon manager. If you are the manager, please Login:");
                Manager.loginManager(scanner);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        scanner.close();


       /* Service service1 = new Service(ServiceCategory.COLORING, "Consulting", ServiceCategory.Coloring.CONSULTING.getPrice(), 20,
                new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(new StaffRole("Colorist"), new StaffRole(""))));

        Gson gson = new Gson(); // Serialize Service object to JSON
        String jsonService = gson.toJson(service1);

//        System.out.println("Serialized Service object:\n" + jsonService);
        FileWriter writer = new FileWriter("Services.json");
        try {
            writer.write(jsonService);
        } finally {
            writer.close();
        }

        Service deserializedService = gson.fromJson(jsonService, Service.class);// Deserialize JSON to Service object


        System.out.println("Deserialized Service object:\n" + deserializedService.getServiceName());

        ArrayList<Service> services = new ArrayList<>();
        services.add(new Service(ServiceCategory.COLORING, "Service 1", 10, 30,
                new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(StaffRole.ROLE_A, StaffRole.ROLE_B))));
        services.add(new Service(ServiceCategory.FOR_CHILDREN, "Service 2", 20, 60,
                new ArrayList<>(Arrays.asList(3, 4)), new ArrayList<>(Arrays.asList(StaffRole.ROLE_C, StaffRole.ROLE_D))));

        // Serialize ArrayList<Service> to JSON
        Gson gson = new Gson();
        String jsonServices = gson.toJson(services);

        System.out.println("Serialized ArrayList<Service>:\n" + jsonServices);

        // Deserialize JSON to ArrayList<Service>
        ArrayList<Service> deserializedServices = gson.fromJson(jsonServices, new TypeToken<ArrayList<Service>>() {}.getType());

        System.out.println("Deserialized ArrayList<Service>:");
        for (Service service : deserializedServices) {
            System.out.println(service);
        }*/

    }
    private static void chooseAnOption(){
        System.out.println("Choose an option:");
    }







    private static void createAppointment(Scanner scanner) {
//                // Get the necessary details for creating an appointment
//                // ...
//
//                // Create a Service object
//                Service service = new Service(/* service details */);
//
//                // Create a Staff object
//                Staff staff = new Staff(/* staff details */);
//
//                // Create an Appointment object
//                Appointment appointment = new Appointment(service, staff, /* appointment details */);
//
//                // Use the appointment object as needed
//                // ...

//                System.out.println("Appointment created: " + appointment.getAppointmentID());
    }

}
