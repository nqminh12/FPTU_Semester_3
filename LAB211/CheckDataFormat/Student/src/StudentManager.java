
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class StudentManager {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("nguyen van a", "fu1", 8, 10, 5));
        list.add(new Student("nguyen van b", "fu1", 9, 10, 5));
        list.add(new Student("nguyen van c", "fu1", 10, 7, 5));
        list.add(new Student("nguyen van d", "fu1", 5, 5, 5));
        list.add(new Student("nguyen van e", "fu1", 6, 10, 5));
        System.out.println("====== Management Student Program ======");
        Options op = new Options();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Classes: ");
            String classes = sc.nextLine();
            System.out.print("Maths: ");
            double math = Double.parseDouble(sc.nextLine());
            System.out.print("Chemistry: ");
            double chemistry = Double.parseDouble(sc.nextLine());
            System.out.print("Physical: ");
            double physical = Double.parseDouble(sc.nextLine());
            op.addStudent(list, name, classes, math, physical, chemistry);
            if(op.inputYN().equalsIgnoreCase("N")){
                break;
            }
        }
        op.display(list);
        HashMap<String, Double> mapStudent = op.getPercentTypeStudent(list);
        mapStudent.forEach((key,value)-> System.out.println(key+": "+value+"%"));
    }
}
