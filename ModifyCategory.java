
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModifyCategory {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        try {
            addService(scanner);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void addService(Scanner scanner) throws IOException{

        String fileName = "ServiceCategory.java";
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Enter Service Category:");
        String inputCategory = scanner.nextLine();

        System.out.println("Enter Service Name:");
        String inputServiceName = scanner.nextLine();

        System.out.println("Enter price:");
        int inputPrice = Integer.parseInt(scanner.nextLine());
        // Print the contents of the ArrayList
        for (int i = 1; i<lines.size(); i++){
            if(lines.get(i-1).contains("enum " + inputCategory)){
                lines.set(i, lines.get(i)+  inputServiceName(inputPrice));
            }

        }
        System.out.println(lines);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);

                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String inputServiceName(int inputPrice) {
        System.out.println("Enter Service Name:");
        return ServiceCategory.Coloring.scanner.nextLine();
    }
}
