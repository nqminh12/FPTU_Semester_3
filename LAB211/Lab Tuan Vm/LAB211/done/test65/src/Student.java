
class Student {

    String name;
    String classes;
    double maths;
    double chemistry;
    double physics;
    double average;
    String type;

    public Student() {
    }

    public Student(String name, String classes, double maths, double chemistry, double physics) {
        this.name = name;
        this.classes = classes;
        this.maths = maths;
        this.chemistry = chemistry;
        this.physics = physics;
        this.average = (maths + chemistry + physics) / 3; 
        this.type = getType();
    }
    
    public String getType() {
        if (average > 7.5) {
            return "A";
        } else if (average >= 6 && average <= 7.5) {
            return "B";
        } else if (average >= 4 && average < 6) {
            return "C";
        } else {
            return "D";
        }
    }

    public void displayInfo() {
        System.out.println("Name:" + name);
        System.out.println("Classes:" + classes);
        System.out.println("AVG:" + average);
        System.out.println("Type:" + type);
    }
}
