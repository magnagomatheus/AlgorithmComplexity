package service;

import model.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {
    
    public List<Student> readStudentsFromFile(String fileName) {
        List<Student> students = new ArrayList<>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int qttElem = Integer.parseInt(reader.readLine().trim());
            System.out.println("Number of elements: " + qttElem);

            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int grade = (int) Float.parseFloat(parts[2]);
                
                students.add(new Student(id, name, grade));
            }
        } catch(IOException e) {
            System.err.println("Error when reading the file: " + e.getMessage());
        } catch(NumberFormatException e) {
            System.err.println("Error when processing a numeric value: " + e.getMessage());
        }
        
        return students;
    }
}
