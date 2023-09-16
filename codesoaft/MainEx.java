import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null; // Student not found
    }

    public List<Student> getAllStudents() {
        return students;
    }
}

public class MainEx {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    Student newStudent = new Student(name, rollNumber, grade);
                    sms.addStudent(newStudent);
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.print("Enter the roll number of the student to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    sms.removeStudent(removeRollNumber);
                    System.out.println("Student removed successfully.");
                    break;
                case 3:
                    System.out.print("Enter the roll number of the student to search: ");
                    int searchRollNumber = scanner.nextInt();
                    Student foundStudent = sms.searchStudent(searchRollNumber);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    List<Student> allStudents = sms.getAllStudents();
                    System.out.println("All Students:");
                    for (Student student : allStudents) {
                        System.out.println(student);
                    }
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
/*OUTPUT
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Enter your choice: 1
Enter student name: NIKITA
Enter roll number: 101
Enter grade: A
Student added successfully.
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Enter your choice: 1
Enter student name: KOMAL
Enter roll number: 102
Enter grade: B
Student added successfully.
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Enter your choice: 3
Enter the roll number of the student to search: 103
Student not found.
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Enter your choice: 3
Enter the roll number of the student to search: 101
Student found: Name: NIKITA, Roll Number: 101, Grade: A
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Enter your choice: 2
Enter the roll number of the student to remove: 103
Student removed successfully.
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Enter your choice: 4
All Students:
Name: NIKITA, Roll Number: 101, Grade: A
Name: KOMAL, Roll Number: 102, Grade: B
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Enter your choice: 2
Enter the roll number of the student to remove: 102
Student removed successfully.
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Enter your choice: 4
All Students:
Name: NIKITA, Roll Number: 101, Grade: A
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Enter your choice:
 */