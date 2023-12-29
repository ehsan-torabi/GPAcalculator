import java.util.Locale;
import java.util.Scanner;

public class GPAcalculator {
    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        
        // Prompt the user to enter the number of courses
        System.out.print("Please Enter Count OF your courses: ");
        int numOfCourses = scanner.nextInt();
        
        // Initialize an array of Course objects
        Course[] courses = new Course[numOfCourses];
        
        // Loop through each course
        for (int i = 0; i < numOfCourses; i++) {
            try {
                // Prompt the user to enter the course details
                System.out.printf(Locale.ENGLISH, "Please enter name,unit,score in same format of your course %d: %n", i + 1);
                
                // Split the user input into name, unit, and score
                String[] courseDetails = scanner.next().split(",");
                
                // Parse the unit and score as integers and double respectively
                int unit = Integer.parseInt(courseDetails[1]);
                double score = Double.parseDouble(courseDetails[2]);
                
                // Create a new Course object and add it to the courses array
                courses[i] = new Course(courseDetails[0], unit, score);
                
                System.out.println("------------------------------------------------------");
            } catch (ArrayIndexOutOfBoundsException e) {
                // Handle the exception if the user input is not in the correct format
                System.out.println("Please Enter to below format:\n name,unit,score");
                i--;
            }
        }

        // Close the scanner
        scanner.close();

        // Initialize variables for total units and total scores
        double totalUnits = 0;
        double totalScores = 0;
        
        // Print the table header
        System.out.println("\nName" + "\t" + "Unit" + "\t" + "Score");
        System.out.println("---------------------");
        
        // Loop through each course and print its details
        for (Course course : courses) {
            System.out.println(course.getName() + " \t" + course.getUnit() + " \t" + course.getScore());
            
            // Add the course's weighted score and unit to the total scores and total units
            totalScores += course.calculateScore();
            totalUnits += course.getUnit();
        }

        // Calculate the GPA
        double gpa = totalScores / totalUnits;
        
        // Print the GPA and total units
        System.out.println("---------------------");
        System.out.printf(Locale.ENGLISH, "GPA: %.2f%n", gpa);
        System.out.println("Total units: " + totalUnits);
    }
}

class Course {
    private final String name;
    private final int unit;
    private final double score;

    // Constructor for the Course class
    public Course(String name, int unit, double score) {
        this.name = name;
        this.unit = unit;
        this.score = score;
    }

    // Getter for the score
    public double getScore() {
        return this.score;
    }

    // Method to calculate the weighted score
    public double calculateScore() {
        return score * unit;
    }

    // Getter for the unit
    public int getUnit() {
        return unit;
    }

    // Getter for the name
    public String getName() {
        return name;
    }
}
