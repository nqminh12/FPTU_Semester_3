import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        //1. users input Student data
        getStudentData(students);
        //2. classifies students 
        classifyStudents(students);
        //3. gives student rank statistics by %.
        calculatePercentType(students);
    }

    private static void getStudentData(List<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====== Management Student Program ======");
        
        //loop until user enter N
        do{
            String name = Input.inputString("Name: "); 
            String classes = Input.inputString("Classes: "); 
            System.out.print("Maths: "); 
            double maths = Input.inputMark("Maths"); 
            System.out.print("Chemistry: "); 
            double chemistry = Input.inputMark("Chemistry");
            System.out.print("Physics: "); 
            double physics = Input.inputMark("Physics"); 
            // Create a student object using the input data and the createStudent method
            Student student = MarkCalculation.createStudent(name, classes, maths, chemistry, physics);
            // Add the student object to the list of students
            students.add(student);
        } while (Input.checkYN());
    }

    private static void classifyStudents(List<Student> students) {
        students = MarkCalculation.averageStudent(students);
        
        int i = 0;
        // Loop through the list of students
        for (Student student : students) {
            System.out.println("----- Student" + (++i) + " info -----");
            student.displayInfo();
        }
    }

    private static void calculatePercentType(List<Student> students) {
        // Calculate the percentage of each type of students using the getPercentTypeStudent method and store the result in a hashmap
        HashMap<String, Double> percentType = MarkCalculation.getPercentTypeStudent(students);

        System.out.println("--------Classification Info -----"); // Print a header for classification info

        // Loop through the hashmap
        for (Map.Entry<String, Double> entry : percentType.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "%");
        }
    }
}
