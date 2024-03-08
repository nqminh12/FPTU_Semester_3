
import java.util.HashMap;
import java.util.List;

class MarkCalculation {

    public static Student createStudent(String name, String classes, double maths, double chemistry, double physics) {
        return new Student(name, classes, maths, chemistry, physics);
    }

    // A method to classify students and return a list of students with their types
    public static List<Student> averageStudent(List<Student> students) {
        // Loop through the list of students and set their types
        for (Student student : students) {
            student.type = student.getType();
        }
        return students; // Return the modified list
    }

    // A method to calculate the percentage of each type of students and return a hashmap with the keys A,B,C,D and values as percentages
    public static HashMap<String, Double> getPercentTypeStudent(List<Student> students) {
        HashMap<String, Double> result = new HashMap<>(); // Create a hashmap to store the result
        int countA = 0; // A counter for type A students
        int countB = 0;
        int countC = 0;
        int countD = 0; 
        int total = students.size();

        // Loop through the list of students and increment the counters based on their types
        for (Student student : students) {
            if (student.type.equals("A")) {
                countA++;
            } else if (student.type.equals("B")) {
                countB++;
            } else if (student.type.equals("C")) {
                countC++;
            } else {
                countD++;
            }
        }

        result.put("A", (double) countA / total * 100);
        result.put("B", (double) countB / total * 100);
        result.put("C", (double) countC / total * 100);
        result.put("D", (double) countD / total * 100);

        return result; // Return the hashmap
    }
}
