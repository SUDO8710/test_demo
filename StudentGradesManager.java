package build.debug.outDebug;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradesManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Prompt the user for the number of students
            System.out.print("Enter the number of students: ");
            int numStudents = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            // Initialize parallel arrays to store student names and marks
            String[] studentNames = new String[numStudents];
            double[] studentMarks = new double[numStudents];

            // Use a for loop to get the name and mark for each student
            for (int i = 0; i < numStudents; i++) {
                System.out.println("\nEnter details for Student " + (i + 1) + ":");
                
                // Get student name
                System.out.print("Name: ");
                studentNames[i] = sc.nextLine();

                // Get student mark with input validation
                System.out.print("Mark: ");
                studentMarks[i] = sc.nextDouble();
                sc.nextLine(); // Consume the newline character
            }

            // Calculate the total and average mark
            double totalMarks = 0;
            for (double mark : studentMarks) {
                totalMarks += mark;
            }
            double averageMark = totalMarks / numStudents;

            // Display the results in a formatted report
            System.out.println("\n--- Student Grades Report ---");
            System.out.println("-----------------------------");
            for (int i = 0; i < numStudents; i++) {
                System.out.printf("%-20s: %.2f\n", studentNames[i], studentMarks[i]);
            }
            System.out.println("-----------------------------");
            System.out.printf("Class Average: %.2f\n", averageMark);
            System.out.println("-----------------------------");

        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input. Please enter a valid number for the mark.");
        } catch (NegativeArraySizeException e) {
            System.err.println("Error: The number of students cannot be negative.");
        } finally {
            // Close the scanner to prevent resource leaks
            sc.close();
        }
    }
}