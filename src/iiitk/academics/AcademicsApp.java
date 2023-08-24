package iiitk.academics;
import iiitk.admin.*;
import java.util.*;

import static iiitk.admin.AdminApp.faculty;
import static iiitk.admin.AdminApp.students;

public class AcademicsApp {
    public static Map<String, Subject> subjects = new HashMap<>();
    public static Map<Student, List<Subject>> studentSubjects = new HashMap<>();
    public static Map<Faculty, List<Subject>> facultySubjects = new HashMap<>();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("IIIT Kottayam Management System");
            System.out.println("1. Create subjects/courses");
            System.out.println("2. Register student for semester courses");
            System.out.println("3. Assign teaching subjects to faculty");
            System.out.println("4. Display student registered subjects");
            System.out.println("5. Display faculty teaching subjects");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createSubjects(scanner);
                    break;
                case 2:
                    registerStudentCourses(scanner);
                    break;
                case 3:
                    assignTeachingSubjects(scanner);
                    break;
                case 4:
                    displayStudentSubjects();
                    break;
                case 5:
                    displayFacultySubjects();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.println();
        } while (choice != 8);

        scanner.close();
    }

    public static void createSubjects(Scanner scanner) {
        System.out.print("Enter the number of subjects/courses to create: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for subject " + (i + 1) + ":");
            System.out.print("Subject Name: ");
//            scanner.nextLine();
            scanner.nextLine();
            String subjectName = scanner.nextLine();
            System.out.print("Subject Code: ");
//            scanner.nextLine();
            String subjectCode = scanner.next();
            Subject subject = new Subject(subjectCode, subjectName);
            subjects.put(subjectCode, subject);
        }

        System.out.println(n + " subjects/courses created successfully!");
    }

    public static void registerStudentCourses(Scanner scanner) {
        System.out.println("Choose a student to register courses:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName());
        }
        System.out.println("Enter your choice : ");
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= students.size()) {
            Student student = students.get(choice - 1);
            System.out.println("Student: " + student.getName());
            System.out.println("1. Insert course");
            System.out.println("2. Update course");
            System.out.println("3. Delete course");
            System.out.println("Choose an option:");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    insertCourseForStudent(scanner, student);
                    break;
                case 2:
                    updateCourseForStudent(scanner, student);
                    break;
                case 3:
                    deleteCourseForStudent(scanner, student);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } else {
            System.out.println("Invalid choice!");
        }
    }

    public static void insertCourseForStudent(Scanner scanner, Student student) {
        System.out.print("Enter the subject code: ");
        String subjectCode = scanner.next();

        if (subjects.containsKey(subjectCode)) {
            Subject subject = subjects.get(subjectCode);

            List<Subject> courses = studentSubjects.getOrDefault(student, new ArrayList<>());
            courses.add(subject);
            studentSubjects.put(student, courses);

            System.out.println("Course registered successfully for student " + student.getName());
        } else {
            System.out.println("Subject code not found!");
        }
    }

    public static void updateCourseForStudent(Scanner scanner, Student student) {
        System.out.print("Enter the subject code to update: ");
        String subjectCode = scanner.next();

        if (subjects.containsKey(subjectCode)) {
            Subject subject = subjects.get(subjectCode);

            List<Subject> courses = studentSubjects.get(student);
            if (courses != null && courses.contains(subject)) {
                System.out.println("Subject already registered for the student.");
                return;
            }

            courses.add(subject);
            studentSubjects.put(student, courses);

            System.out.println("Course updated successfully for student " + student.getName());
        } else {
            System.out.println("Subject code not found!");
        }
    }

    public static void deleteCourseForStudent(Scanner scanner, Student student) {
        System.out.print("Enter the subject code to delete: ");
        String subjectCode = scanner.next();

        if (subjects.containsKey(subjectCode)) {
            Subject subject = subjects.get(subjectCode);

            List<Subject> courses = studentSubjects.get(student);
            if (courses != null && courses.contains(subject)) {
                courses.remove(subject);
                System.out.println("Course deleted successfully for student " + student.getName());
            } else {
                System.out.println("Course not found for the student.");
            }
        } else {
            System.out.println("Subject code not found!");
        }
    }

    public static void assignTeachingSubjects(Scanner scanner) {
        System.out.println("Choose a faculty to assign teaching subjects:");
        for (int i = 0; i < faculty.size(); i++) {
            System.out.println((i + 1) + ". " + faculty.get(i).getName());
        }
        System.out.println("Enter your choice : ");
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= faculty.size()) {
            Faculty facultyMember = faculty.get(choice - 1);
            System.out.println("Faculty: " + facultyMember.getName());
            System.out.println("1. Insert teaching subject");
            System.out.println("2. Update teaching subject");
            System.out.println("3. Delete teaching subject");
            System.out.println("Choose an option:");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    insertTeachingSubject(scanner, facultyMember);
                    break;
                case 2:
                    updateTeachingSubject(scanner, facultyMember);
                    break;
                case 3:
                    deleteTeachingSubject(scanner, facultyMember);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } else {
            System.out.println("Invalid choice!");
        }
    }

    public static void insertTeachingSubject(Scanner scanner, Faculty facultyMember) {
        System.out.print("Enter the subject code: ");
        String subjectCode = scanner.next();

        if (subjects.containsKey(subjectCode)) {
            Subject subject = subjects.get(subjectCode);

            List<Subject> teachingSubjects = facultySubjects.getOrDefault(facultyMember, new ArrayList<>());
            teachingSubjects.add(subject);
            facultySubjects.put(facultyMember, teachingSubjects);

            System.out.println("Teaching subject assigned successfully to faculty " + facultyMember.getName());
        } else {
            System.out.println("Subject code not found!");
        }
    }

    public static void updateTeachingSubject(Scanner scanner, Faculty facultyMember) {
        System.out.print("Enter the subject code to update: ");
        String subjectCode = scanner.next();

        if (subjects.containsKey(subjectCode)) {
            Subject subject = subjects.get(subjectCode);

            List<Subject> teachingSubjects = facultySubjects.get(facultyMember);
            if (teachingSubjects != null && teachingSubjects.contains(subject)) {
                System.out.println("Subject already assigned to the faculty.");
                return;
            }

            teachingSubjects.add(subject);
            facultySubjects.put(facultyMember, teachingSubjects);

            System.out.println("Teaching subject updated successfully for faculty " + facultyMember.getName());
        } else {
            System.out.println("Subject code not found!");
        }
    }

    public static void deleteTeachingSubject(Scanner scanner, Faculty facultyMember) {
        System.out.print("Enter the subject code to delete: ");
        String subjectCode = scanner.next();

        if (subjects.containsKey(subjectCode)) {
            Subject subject = subjects.get(subjectCode);

            List<Subject> teachingSubjects = facultySubjects.get(facultyMember);
            if (teachingSubjects != null && teachingSubjects.contains(subject)) {
                teachingSubjects.remove(subject);
                System.out.println("Teaching subject deleted successfully for faculty " + facultyMember.getName());
            } else {
                System.out.println("Teaching subject not found for the faculty.");
            }
        } else {
            System.out.println("Subject code not found!");
        }
    }

    public static void displayStudentSubjects() {
        System.out.println("Student Registered Subjects:");
        for (Map.Entry<Student, List<Subject>> entry : studentSubjects.entrySet()) {
            Student student = entry.getKey();
            List<Subject> subjects = entry.getValue();

            System.out.println("Student: " + student.getName());
            System.out.println("Subjects:");
            for (Subject subject : subjects) {
                System.out.println("Subject Code: " + subject.getSubjectCode() + ", Subject Name: " + subject.getSubjectName());
            }
            System.out.println();
        }
    }

    public static void displayFacultySubjects() {
        System.out.println("Faculty Teaching Subjects:");
        for (Map.Entry<Faculty, List<Subject>> entry : facultySubjects.entrySet()) {
            Faculty facultyMember = entry.getKey();
            List<Subject> subjects = entry.getValue();

            System.out.println("Faculty: " + facultyMember.getName());
            System.out.println("Subjects:");
            for (Subject subject : subjects) {
                System.out.println("Subject Code: " + subject.getSubjectCode() + ", Subject Name: " + subject.getSubjectName());
            }
            System.out.println();
        }
    }
}
