import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
        ManagerImpl managerRepository = new ManagerImpl();

        Role barber = new Role("Barber");
        Role hairdresser = new Role("Hairdresser");
        Role colorist = new Role("Colorist");
        Role admin = new Role("Administrator");
        Role manager = new Role("Manager");

        Manager m = new Manager("Alex", manager);

        Staff s0 = new Staff(1,"David",admin,new String[]{"English","Russian","Estonian"});
        Staff s1 = new Staff(2,"Zara",barber,new String[]{"English","Russian","Azerbaijan"});
        Staff s2 = new Staff(3,"Linda",colorist,new String[]{"English","Estonian"});
        Staff s3 = new Staff(4,"Nadezda",hairdresser,new String[]{"English","Russian"});
        Staff s4 = new Staff(5,"Heiki",hairdresser,new String[]{"Russian","Estonian"});

        managerRepository.addStaff(s0);
        managerRepository.addStaff(s1);
        managerRepository.addStaff(s2);
        managerRepository.addStaff(s3);
        managerRepository.addStaff(s4);


//        Service hairCut = new Service(Service.MenHaircut.MACHINE_CUT);

    }

}
