import java.util.Locale;
import java.util.Scanner;

public class GPAcalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        System.out.print("Please Enter Count OF your courses: ");
        int numOfCourses = scanner.nextInt();
        Course[] courses = new Course[numOfCourses];
        double totalUnits = 0;

        for (int i = 0; i < numOfCourses; i++) {
            String[] valStrings = new String[3];
            System.out.printf(Locale.ENGLISH, "Please enter name,unit,score in same format of your course %d: %n",
                    i + 1);
            String values = scanner.next();
            valStrings = values.split(",");
            int unit = Integer.parseInt(valStrings[1]);
            double score = Double.parseDouble(valStrings[2]);
            String name = valStrings[0];
            courses[i] = new Course(name, unit, score);
            totalUnits += unit;
            System.out.println("------------------------------------------------------");
        }

        scanner.close();

        double totalScores = 0;
        System.out.println("\nName" + "\t" + "Unit" + "\t" + "Score");
        System.out.println("---------------------");
        for (Course course : courses) {
            System.out.println(course.getName() + " \t" + course.getUnit() + " \t" + course.getScore());
            totalScores += course.calculateScore();
        }

        double gpa = totalScores / totalUnits;
        System.out.println("---------------------");
        System.out.printf(Locale.ENGLISH, "GPA: %.2f%n", gpa);
        System.out.println("Total units: " + totalUnits);
    }
}

class Course {
    private final String name;
    private final int unit;
    private final double score;

    public Course(String name, int unit, double score) {
        this.name = name;
        this.unit = unit;
        this.score = score;
    }

    public double getScore() {
        return this.score;
    }

    public double calculateScore() {
        return score * unit;
    }

    public int getUnit() {
        return unit;
    }

    public String getName() {
        return name;
    }
}
