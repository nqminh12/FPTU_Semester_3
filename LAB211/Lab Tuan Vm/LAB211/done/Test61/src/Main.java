
import java.util.Scanner;


public class Main {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        //1. Input the rectangle data
        Rectangle rectangle = inputRectangle();
        //2. Input the circle data
        Circle circle = inputCircle();
        //3. Input the trigle data
        Triangle trigle = inputTriangle();
        //5. Display the shape information. 
        display(trigle, rectangle, circle);
    }
    
    private static double checkInputDouble() {
        String input;
        double output;
        do {            
            input = sc.nextLine();
            // check if user not enter data
            if(input.isEmpty()) {
                System.out.println("Input can not empty");
            } else {
                try {
                    output = Double.parseDouble(input.trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Re-input: ");
                }
            }
            
        } while (true);
        return output;
    }
    
    private static Rectangle inputRectangle() {
        System.out.println("Please input side width of Rectangle: ");
        double width = checkInputDouble();
        System.out.println("Please input length of Rectangle: ");
        double length = checkInputDouble();
        return new Rectangle(width, length);
    }

    private static Circle inputCircle() {
        System.out.println("Please input radius of Circle: ");
        double radius = checkInputDouble();
        return new Circle(radius);
    }

    private static Triangle inputTriangle() {
        while (true) {
            System.out.println("Please input side A of Triangle: ");
            double a = checkInputDouble();
            System.out.println("Please input side B of Triangle: ");
            double b = checkInputDouble();
            System.out.println("Please input side C of Triangle: ");
            double c = checkInputDouble();
            // check if the 3 sides entered by the user form a triangle or not
            if (a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Re-input");
            }
        }
    }

    private static void display(Triangle trigle, Rectangle rectangle, Circle circle) {
        rectangle.printResult();
        circle.printResult();
        trigle.printResult();
    }
}
