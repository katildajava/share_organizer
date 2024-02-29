/*
package Example;

import java.io.*;
import java.util.ArrayList;

public class ModifyCategory {
    public static void main(String[] args) throws IOException {
        String fileName = "Example/ServiceCategory.java"; // Replace with the actual file path
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the contents of the ArrayList
        for (int i = 1; i<lines.size(); i++){
            if(lines.get(i-1).contains("enum Coloring")){
               lines.set(i, lines.get(i)+ " BLONDE_EXTREMELY_LONG_HAIR(180),");
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
}
*/
