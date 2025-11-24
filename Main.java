import edu.ccrm.domain.Person;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Teacher;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.Semester;
import edu.ccrm.domain.Grade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Scanner;
import edu.ccrm.domain.Student;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Manage a list of students ---
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Aarush Kumar", "aarush1009@gmail.com", "Student", "Computer Science", 9.1));
        studentList.add(new Student(2, "Rahul Verma", "rahul@example.com", "Student", "Information Technology", 8.5));
        studentList.add(new Student(3, "Simran Kaur", "simran@example.com", "Student", "Electronics", 8.8));

        // --- Teachers list ---
        List<Teacher> teacherList = new ArrayList<>();
        Teacher teacher1 = new Teacher(1, "Dr. Meera Singh", "meera@example.com", "Teacher", "Mathematics", 12);
        teacherList.add(teacher1);
        teacherList.add(new Teacher(2, "Dr. Rajesh Kumar", "rajesh@example.com", "Teacher", "Computer Science", 15));

        // --- Courses list ---
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("CS101", "Data Structures", 4, teacher1, Semester.SPRING, "Computer Science"));
        courseList.add(new Course("CS102", "Algorithms", 4, teacher1, Semester.FALL, "Computer Science"));
        courseList.add(new Course("MATH101", "Calculus", 3, teacher1, Semester.SUMMER, "Mathematics"));

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Campus Course & Records Manager ===");
            System.out.println("1. List all students");
            System.out.println("2. List all teachers");
            System.out.println("3. List all courses");
            System.out.println("4. Enroll student in course");
            System.out.println("5. Record grade");
            System.out.println("6. Print student transcript");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n=== All Students ===");
                    for (Student s : studentList) {
                        System.out.println(s);
                    }
                    break;

                case 2:
                    System.out.println("\n=== All Teachers ===");
                    for (Teacher t : teacherList) {
                        System.out.println(t);
                    }
                    break;

                case 3:
                    System.out.println("\n=== All Courses ===");
                    for (Course c : courseList) {
                        System.out.println(c);
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Enter course index (0-based): ");
                    int cid = sc.nextInt();

                    Student selectedStudent = studentList.stream()
                            .filter(s -> s.getId() == sid)
                            .findFirst()
                            .orElse(null);

                    if (selectedStudent != null && cid >= 0 && cid < courseList.size()) {
                        selectedStudent.enrollCourse(courseList.get(cid));
                        System.out.println("Enrolled successfully!");
                    } else {
                        System.out.println("Invalid student or course.");
                    }
                    break;

                case 5:
                    System.out.print("Enter student ID: ");
                    int sidGrade = sc.nextInt();
                    System.out.print("Enter course index (0-based): ");
                    int cidGrade = sc.nextInt();
                    System.out.print("Enter grade (A/B/C/D/F): ");
                    String gradeStr = sc.next();

                    Student gradeStudent = studentList.stream()
                            .filter(s -> s.getId() == sidGrade)
                            .findFirst()
                            .orElse(null);

                    if (gradeStudent != null && cidGrade >= 0 && cidGrade < courseList.size()) {
                        try {
                            Grade grade = Grade.valueOf(gradeStr.toUpperCase());
                            gradeStudent.recordGrade(courseList.get(cidGrade), grade);
                            System.out.println("Grade recorded!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid grade input.");
                        }
                    } else {
                        System.out.println("Invalid student or course.");
                    }
                    break;

                case 6:
                    System.out.print("Enter student ID: ");
                    int sidTranscript = sc.nextInt();
                    Student transcriptStudent = studentList.stream()
                            .filter(s -> s.getId() == sidTranscript)
                            .findFirst()
                            .orElse(null);

                    if (transcriptStudent != null) {
                        transcriptStudent.printTranscript();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 0:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}