import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("           STUDENT GRADE CALCULATOR");
        System.out.println("=================================================");

        int numberOfSubjects = readNumberOfSubjects(scanner);
        int[] marks = new int[numberOfSubjects];

        System.out.println("\nEnter marks (out of 100) for each subject:");
        for (int i = 0; i < numberOfSubjects; i++) {
            marks[i] = readMarksForSubject(scanner, i + 1);
        }

        // Calculate Total Marks
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Grade Calculation
        String grade = calculateGrade(averagePercentage);

        // Display Results
        System.out.println("\n=================================================");
        System.out.println("                  RESULT SUMMARY");
        System.out.println("=================================================");
        System.out.println("Subjects Entered     : " + numberOfSubjects);
        System.out.print("Marks Obtained        : ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Subject " + (i + 1) + " = " + marks[i]
                    + (i < marks.length - 1 ? ", " : ""));
        }
        System.out.println();
        System.out.println("Total Marks           : " + totalMarks + " / " + (numberOfSubjects * 100));
        System.out.printf("Average Percentage    : %.2f%%%n", averagePercentage);
        System.out.println("Grade                 : " + grade);
        System.out.println("=================================================");

        scanner.close();
    }

    /**
     * Reads and validates the number of subjects (must be at least 1).
     */
    private static int readNumberOfSubjects(Scanner scanner) {
        int count = -1;
        while (count < 1) {
            System.out.print("Enter the number of subjects: ");
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
                if (count < 1) {
                    System.out.println("Please enter a number of subjects greater than 0.");
                }
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // discard invalid token
            }
        }
        return count;
    }

    /**
     * Reads and validates marks for a single subject (must be between 0 and 100).
     */
    private static int readMarksForSubject(Scanner scanner, int subjectNumber) {
        int marks = -1;
        while (marks < 0 || marks > 100) {
            System.out.print("  Subject " + subjectNumber + " marks (0-100): ");
            if (scanner.hasNextInt()) {
                marks = scanner.nextInt();
                if (marks < 0 || marks > 100) {
                    System.out.println("  Marks must be between 0 and 100. Try again.");
                }
            } else {
                System.out.println("  Invalid input. Please enter a whole number.");
                scanner.next(); // discard invalid token
            }
        }
        return marks;
    }

    /**
     * Assigns a letter grade based on the average percentage achieved.
     */
    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+ (Outstanding)";
        } else if (averagePercentage >= 80) {
            return "A (Excellent)";
        } else if (averagePercentage >= 70) {
            return "B (Very Good)";
        } else if (averagePercentage >= 60) {
            return "C (Good)";
        } else if (averagePercentage >= 50) {
            return "D (Satisfactory)";
        } else if (averagePercentage >= 40) {
            return "E (Pass)";
        } else {
            return "F (Fail)";
        }
    }
}
