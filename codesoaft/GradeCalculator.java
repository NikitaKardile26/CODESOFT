import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        if (numSubjects <= 0) {
            System.out.println("Please enter a valid number of subjects.");
            scanner.close();
            return;
        }
        
        int totalMarks = 0;
        
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = scanner.nextInt();
            
            if (marks < 0 || marks > 100) {
                System.out.println("Marks should be between 0 and 100. Please enter a valid value.");
                i--; // Decrement i to re-enter marks for the same subject.
                continue;
            }
            
            totalMarks += marks;
        }
        
        double averagePercentage = (double) totalMarks / numSubjects;
        String grade;
        
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}
/*output
 Enter the number of subjects: 5
Enter marks obtained in subject 1: 20
Enter marks obtained in subject 2: 40
Enter marks obtained in subject 3: 60
Enter marks obtained in subject 4: 80
Enter marks obtained in subject 5: 70
Total Marks: 270
Average Percentage: 54.0%
Grade: D
 */