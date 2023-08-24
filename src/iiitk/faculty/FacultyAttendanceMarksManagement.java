package iiitk.faculty;
import java.util.*;
import static iiitk.academics.AcademicsApp.*;
import static iiitk.admin.AdminApp.students;
import iiitk.academics.Subject;
import iiitk.admin.Student;
public class FacultyAttendanceMarksManagement {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAttendance Manager");
            System.out.println("==================");
            System.out.println("1. View Subjects");
            System.out.println("2. Update Attendance");
            System.out.println("3. Delete Attendance");
            System.out.println("4. View Attendance");
            System.out.println("5. Update Marks");
            System.out.println("6. View Marks");
            System.out.println("7. Return");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> viewSubjects();
                case 2 -> updateAttendance(scanner);
                case 3 -> deleteAttendance(scanner);
                case 4 -> viewAttendance(scanner);
                case 5 -> updateMarks(scanner);
                case 6 -> viewMarks(scanner);
                case 7 -> {
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void viewSubjects() {
        System.out.println("Available Subjects:");
        for (Map.Entry<Student, List<Subject>> entry : studentSubjects.entrySet()) {
            List<Subject> subjects = entry.getValue();
            System.out.println("Available Subjects:");
            for (Subject subject : subjects) {
                System.out.println("Subject Code: " + subject.getSubjectCode() + " Subject Name: " + subject.getSubjectName());
            }
            System.out.println();
        }
    }

    private static void updateAttendance(Scanner scanner) {
        System.out.print("Enter the course ID: ");
        String courseName = scanner.nextLine();

        if (!subjects.containsKey(courseName)) {
            System.out.println("Invalid course name! Please select a course from the available subjects list.");
            return;
        }
        Subject course = subjects.get(courseName);
        if (course.getAttendance() == null) {
            course.setAttendance(new HashMap<>());
        }
        Map<String, Boolean> courseAttendance = course.getAttendance();
        if (courseAttendance.isEmpty()) {
            for (Student student : students) {
                courseAttendance.put(student.getName(), false);
            }
        }

        System.out.println("Update Attendance for Course ID: " + courseName);
        for (Map.Entry<String, Boolean> entry : courseAttendance.entrySet()) {
            String studentName = entry.getKey();
            Boolean attendanceStatus = entry.getValue();

            System.out.print("\nStudent Name: " + studentName);
            System.out.print("\nPresent (P) / Absent (A) ?: ");
            String input = scanner.nextLine().toUpperCase();
            if (input.equals("P")) {
                courseAttendance.put(studentName, true);
            } else if (input.equals("A")) {
                courseAttendance.put(studentName, false);
            } else {
                System.out.println("Invalid input! Attendance not updated for this student.");
            }
        }
    }

    private static void deleteAttendance(Scanner scanner) {
        System.out.print("Enter the course ID: ");
        scanner.nextLine();
        String courseName = scanner.nextLine();
        System.out.print("Enter the course ID: ");
        String courseId = scanner.next();


        if (!subjects.containsKey(courseId)) {
            System.out.println("Invalid course name! Please select a course from the available subjects list.");
            return;
        }

        subjects.get(courseName).resetAttendance();
        System.out.println("Attendance for " + courseName + " deleted successfully!");
    }

    private static void viewAttendance(Scanner scanner) {
        System.out.print("Enter the course ID: ");
        String courseName = scanner.nextLine();

        if (!subjects.containsKey(courseName)) {
            System.out.println("Invalid course name! Please select a course from the available subjects list.");
            return;
        }

        Subject course = subjects.get(courseName);
        Map<String, Boolean> courseAttendance = course.getAttendance();
        System.out.println("Attendance for Course: " + courseName);
        for (Map.Entry<String, Boolean> student : courseAttendance.entrySet()) {
            System.out.println("\nStudent Name: " + student.getKey());
            System.out.println("Attendance: " + (student.getValue() ? "Present" : "Absent"));
        }
    }

    private static void updateMarks(Scanner scanner) {
        System.out.print("Enter the course ID: ");
        String courseName = scanner.nextLine();

        if (!subjects.containsKey(courseName)) {
            System.out.println("Invalid course name! Please select a course from the available subjects list.");
            return;
        }

        Subject course = subjects.get(courseName);
        Map<String, List<Integer>> courseMarks = course.getMarks();
        if (courseMarks.isEmpty()) {
            for (Student student : students) {
                courseMarks.put(student.getName(), new ArrayList<>());
            }
        }

        System.out.println("Update Marks for Course ID: " + courseName);
        for (Map.Entry<String, List<Integer>> entry : courseMarks.entrySet()) {
            String studentName = entry.getKey();
            List<Integer> marksList = entry.getValue();

            System.out.print("\nStudent Name: " + studentName);
            System.out.println("\nEnter marks for Mid Semester 1: ");
            int midSemester1 = scanner.nextInt();
            marksList.add(midSemester1);

            System.out.println("Enter marks for Mid Semester 2: ");
            int midSemester2 = scanner.nextInt();
            marksList.add(midSemester2);

            System.out.println("Enter marks for End Semester Exam: ");
            int endSemester = scanner.nextInt();
            marksList.add(endSemester);
        }
    }

    private static void viewMarks(Scanner scanner) {
        System.out.print("Enter the course ID: ");
        String courseName = scanner.nextLine();

        if (!subjects.containsKey(courseName)) {
            System.out.println("Invalid course name! Please select a course from the available subjects list.");
            return;
        }

        Subject course = subjects.get(courseName);
        Map<String, List<Integer>> courseMarks = course.getMarks();
        System.out.println("Marks for Course: " + courseName);
        for (Map.Entry<String, List<Integer>> entry : courseMarks.entrySet()) {
            String studentName = entry.getKey();
            List<Integer> marksList = entry.getValue();

            System.out.println("\nStudent Name: " + studentName);
            System.out.println("Mid Semester 1 Marks: " + marksList.get(0));
            System.out.println("Mid Semester 2 Marks: " + marksList.get(1));
            System.out.println("End Semester Exam Marks: " + marksList.get(2));
        }
    }
}
