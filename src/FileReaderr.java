import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderr {
    private static final String NAME_FILE = "orderedStudents.txt";

    public static void readFile() {
        try(BufferedReader reader = new BufferedReader(new FileReader(NAME_FILE))) {
            int qttElem = Integer.parseInt(reader.readLine().trim());
            System.out.println("Number of elements: " + qttElem);

            String line;

            while((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                float grade = Float.parseFloat(parts[2]);

                System.out.printf("ID: %d | Name: %s | Grade: %.2f%n", id, name, grade);
            }
        } catch(IOException e) {
            System.err.println("Error when read the file: " + e.getMessage());
        } catch(NumberFormatException e) {
            System.err.println("Error when processing an numeric value: " + e.getMessage());
        }
    }
}
