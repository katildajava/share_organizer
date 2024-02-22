package Example;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SalonMain {
    public static void main(String[] args) throws IOException {

        Service service1 = new Service(ServiceCategory.COLORING, "Service 1", 10, 30,
                new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(new StaffRole("Colorist"), new StaffRole(""))));

        // Serialize Service object to JSON
        Gson gson = new Gson();
        String jsonService = gson.toJson(service1);

        System.out.println("Serialized Service object:\n" + jsonService);
        FileWriter writer = new FileWriter("serviceExample.json");
        try {
            writer.write(jsonService);
        } finally {
            writer.close();
        }

        // Deserialize JSON to Service object
        Service deserializedService = gson.fromJson(jsonService, Service.class);

        System.out.println("Deserialized Service object:\n" + deserializedService.getServiceName());

//        ArrayList<Service> services = new ArrayList<>();
//        services.add(new Service(ServiceCategory.COLORING, "Service 1", 10, 30,
//                new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(StaffRole.ROLE_A, StaffRole.ROLE_B))));
//        services.add(new Service(ServiceCategory.FOR_CHILDREN, "Service 2", 20, 60,
//                new ArrayList<>(Arrays.asList(3, 4)), new ArrayList<>(Arrays.asList(StaffRole.ROLE_C, StaffRole.ROLE_D))));
//
//        // Serialize ArrayList<Service> to JSON
//        Gson gson = new Gson();
//        String jsonServices = gson.toJson(services);
//
//        System.out.println("Serialized ArrayList<Service>:\n" + jsonServices);
//
//        // Deserialize JSON to ArrayList<Service>
//        ArrayList<Service> deserializedServices = gson.fromJson(jsonServices, new TypeToken<ArrayList<Service>>() {}.getType());
//
//        System.out.println("Deserialized ArrayList<Service>:");
//        for (Service service : deserializedServices) {
//            System.out.println(service);
//        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Create a new Customer");
        System.out.println("2. Create a new Staff");
        System.out.println("3. Create a new Appointment");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (option) {
            case 1:
                createCustomer(scanner);
                break;
            case 2:
                createStaff(scanner);
                break;
            case 3:
                createAppointment(scanner);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

        scanner.close();
    }

    private static void createCustomer(Scanner scanner) {
        System.out.println("Enter customer username:");
        String username = scanner.nextLine();

        System.out.println("Enter customer password:");
        String password = scanner.nextLine();

        System.out.println("Enter customer name:");
        String name = scanner.nextLine();

        System.out.println("Enter customer phone number:");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Create a CreditCard object
//                String customerInput = scanner.nextLine().replaceAll("[^1-9/]", "");


        CreditCard creditCard = new CreditCard(1234123412341234L, "qwerty qwerty", 123, ZonedDateTime.of(2000 + Integer.parseInt("24"), Integer.parseInt("12"), 1, 0, 0, 0, 0, ZoneId.systemDefault()), "Street 1-1", 12345);

        // Create a Customer object
        Customer customer = new Customer(username, password, name, phoneNumber, creditCard);

        // Use the customer object as needed
        // ...

        System.out.println("Customer created: " + customer.getCustomerName());
    }

    private static void createStaff(Scanner scanner) {
//                System.out.println("Enter staff name:");
//                String name = scanner.nextLine();
//
//                System.out.println("Enter staff rate:");
//                int rate = scanner.nextInt();
//                scanner.nextLine(); // Consume the newline character
//
//                System.out.println("Enter staff languages:");
//                String languages = scanner.nextLine();
//
//                // Create a Staff object
//                Staff staff = new Staff(name, rate, /* staff roles */, languages);
//
//                // Use the staff object as needed
//                // ...
//
//                System.out.println("Staff created: " + staff.getStaffName());
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
