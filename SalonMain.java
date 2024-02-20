import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class SalonMain {

    public static void main(String[] args) throws Exception{
        SalonMain salon = new SalonMain();
        salon.SalonMainExample();



/*        ArrayList<Staff> staff = new ArrayList<Staff>();

        JFrame frame = new JFrame("Органайзер"); // Создание окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Закрытие окна при нажатии кнопки "Отказаться"
        frame.setSize(500, 300); // Установка размеров окна
        new Registration();*/
//        storage.addService("Haircut",30.0);
//        storage.scheduleAppointment("22.04.2024","17:00",stylist,customer);
//        customer.addCustomer(customer);
//        customer.print();
       /* Scanner console = new Scanner(System.in);
        String user, password;
        System.out.println("Enter user name: ");
        user = console.nextLine();
        System.out.println("Enter password: ");
        password = console.nextLine();
        switch (user){
            case "admin":
                if (password.equals("whatagoodday")){
                    System.out.println("Welcome back!");
                }else{
                    System.out.println("Wrong password");
                }
                break;
            case "customer":
                if (password.equals("something")){
                    System.out.println("welcome");
                } else{
                    System.out.println("Wrong password!");
                }
                break;
            case "hairstylist":
                if (password.equals("ilovemyjob")){
                    System.out.println("Welcome back and have a nice day!");
                } else{
                    System.out.println("Wrong password!");
                }
                break;
            default:
                System.out.println("Invalid username or password!");
        }
        console.close();*/



    }
    public void SalonMainExample(){
        ArrayList<StaffRole> roles = new ArrayList<>();

        roles.add(new StaffRole("Colorist"));


        Manager m = new Manager("Alex");

        Staff s0 = new Staff("David",2,new ArrayList<StaffRole>(){{add(new StaffRole("Barber"));}},"English, Russian, Estonian");
        Staff s1 = new Staff("Zara",15,new ArrayList<StaffRole>(){{add(new StaffRole("Colorist"));}},"English, Russian, Azerbaijan");
        s1.setStaffRoles(new ArrayList<StaffRole>(){{add(new StaffRole("Barber"));}});
        Staff s2 = new Staff("Amira",30,new ArrayList<StaffRole>(){{add(new StaffRole("Stylist"));}},"English, Russian, Estonian");
        Staff s3 = new Staff("Nadezda",10,new ArrayList<StaffRole>(){{add(new StaffRole("Hairdresser"));}},"English, Russian");
        Staff s4 = new Staff("Heiki",10,new ArrayList<StaffRole>(){{add(new StaffRole("Hairdresser"));}},"Russian, Estonian");
        Staff s5 = new Staff("Linda",15,new ArrayList<StaffRole>(){{add(new StaffRole("Administrator"));}},"English, Russian, Estonian");



//        Service hairCut = new Service(Service.MenHaircut.MACHINE_CUT);

    }

}
