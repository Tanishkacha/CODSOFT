import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numSubjects = 0;

        System.out.print("Enter number of subjects: ");
        while (true) {
            if (scanner.hasNextInt()) {
                numSubjects = scanner.nextInt();
                if (numSubjects > 0) {
                    break;
                } else {
                    System.out.print("Number must be greater than 0. Try again: ");
                }
            } else {
                System.out.print("Invalid input. Enter a valid number: ");
                scanner.next(); // consume invalid input
            }
        }

        int totalMarks = 0;

        for (int i = 1; i <= numSubjects; i++) {
            int marks = -1;
            System.out.print("Enter marks for subject " + i + ": ");
            while (true) {
                if (scanner.hasNextInt()) {
                    marks = scanner.nextInt();
                    if (marks >= 0 && marks <= 100) {
                        break;
                    } else {
                        System.out.print("Marks must be between 0 and 100. Try again: ");
                    }
                } else {
                    System.out.print("Invalid input. Enter a number between 0 and 100: ");
                    scanner.next(); // clear junk input
                }
            }
            totalMarks += marks;
        }

        double average = (double) totalMarks / numSubjects;
        String grade;

        if (average >= 90) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\n------ RESULT ------");
        System.out.println("Total Marks: " + totalMarks + "/" + (numSubjects * 100));
        System.out.printf("Average: %.2f%%\n", average);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}


