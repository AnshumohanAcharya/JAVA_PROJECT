package iiitk.admin;

import java.util.*;

public class AdminApp {
    public static List<Student> students = new ArrayList<>();
    public static List<Faculty> faculty = new ArrayList<>();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("******************************************");
            System.out.println("IIIT Kottayam Management System");
            System.out.println("1. Create students");
            System.out.println("2. Create faculty");
            System.out.println("3. Insert/Update/Delete student details");
            System.out.println("4. Insert/Update/Delete faculty details");
            System.out.println("5. Display student/faculty details");
            System.out.println("6. Return to Main Menu");
            System.out.println("******************************************");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createStudents(scanner);
                    break;
                case 2:
                    createFaculty(scanner);
                    break;
                case 3:
                    manageStudentDetails(scanner);
                    break;
                case 4:
                    manageFacultyDetails(scanner);
                    break;
                case 5:
                    displayDetails();
                    break;
                case 6:
                    return ;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.println();
        } while (choice != 6);

        scanner.close();
    }

    public static void createStudents(Scanner scanner) {
        System.out.print("Enter the number of students to create: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Roll Number: ");
            String rollNumber = scanner.next();
            System.out.print("Branch : ");
            String branch = scanner.next();
            Student student = new Student(rollNumber, name , branch);
            students.add(student);
        }

        System.out.println(n + " students created successfully!");
    }

    public static void createFaculty(Scanner scanner) {
        System.out.print("Enter the number of faculty to create: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for faculty " + (i + 1) + ":");
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Employee ID: ");
            String employeeId = scanner.next();


            Faculty facultyMember = new Faculty(employeeId, name);
            faculty.add(facultyMember);
        }

        System.out.println(n + " faculty members created successfully!");
    }

    public static void manageStudentDetails(Scanner scanner) {
        System.out.println("Student Details Management");
        System.out.println("1. Insert student details");
        System.out.println("2. Update student details");
        System.out.println("3. Delete student details");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                insertStudentDetails(scanner);
                break;
            case 2:
                updateStudentDetails(scanner);
                break;
            case 3:
                deleteStudentDetails(scanner);
                break;
            default:
                System.out.println("Invalid choice! Returning to main menu.");
        }
    }

    public static void insertStudentDetails(Scanner scanner) {
        System.out.println("Inserting Student Details");
        System.out.print("Name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Roll Number: ");
        String rollNumber = scanner.next();
        System.out.print("Branch : ");
        String branch = scanner.next();


        Student student = new Student(rollNumber, name , branch);
        students.add(student);

        System.out.println("Student details inserted successfully!");
    }

    public static void updateStudentDetails(Scanner scanner) {
        System.out.println("Updating Student Details");
        System.out.print("Enter the roll number of the student to update: ");
        String rollNumber = scanner.next();

        boolean found = false;
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                System.out.print("Enter the updated name: ");
                scanner.nextLine();
                String name = scanner.nextLine();

                student.setName(name);
                found = true;
                System.out.println("Student details updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Student with roll number " + rollNumber + " not found!");
        }
    }

    public static void deleteStudentDetails(Scanner scanner) {
        System.out.println("Deleting Student Details");
        System.out.print("Enter the roll number of the student to delete: ");
        String rollNumber = scanner.next();

        boolean removed = false;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getRollNumber().equals(rollNumber)) {
                students.remove(i);
                removed = true;
                System.out.println("Student details deleted successfully!");
                break;
            }
        }

        if (!removed) {
            System.out.println("Student with roll number " + rollNumber + " not found!");
        }
    }

    public static void manageFacultyDetails(Scanner scanner) {
        System.out.println("Faculty Details Management");
        System.out.println("1. Insert faculty details");
        System.out.println("2. Update faculty details");
        System.out.println("3. Delete faculty details");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                insertFacultyDetails(scanner);
                break;
            case 2:
                updateFacultyDetails(scanner);
                break;
            case 3:
                deleteFacultyDetails(scanner);
                break;
            default:
                System.out.println("Invalid choice! Returning to main menu.");
        }
    }

    public static void insertFacultyDetails(Scanner scanner) {
        System.out.println("Inserting Faculty Details");
        System.out.print("Employee ID: ");
        String employeeId = scanner.next();
        System.out.print("Name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        Faculty facultyMember = new Faculty(employeeId, name);
        faculty.add(facultyMember);

        System.out.println("Faculty details inserted successfully!");
    }

    public static void updateFacultyDetails(Scanner scanner) {
        System.out.println("Updating Faculty Details");
        System.out.print("Enter the employee ID of the faculty to update: ");
        String employeeId = scanner.next();

        boolean found = false;
        for (Faculty facultyMember : faculty) {
            if (facultyMember.getEmployeeId().equals(employeeId)) {
                System.out.print("Enter the updated name: ");
                String name = scanner.next();

                facultyMember.setName(name);
                found = true;
                System.out.println("Faculty details updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Faculty with employee ID " + employeeId + " not found!");
        }
    }

    public static void deleteFacultyDetails(Scanner scanner) {
        System.out.println("Deleting Faculty Details");
        System.out.print("Enter the employee ID of the faculty to delete: ");
        String employeeId = scanner.next();

        boolean removed = false;
        for (int i = 0; i < faculty.size(); i++) {
            Faculty facultyMember = faculty.get(i);
            if (facultyMember.getEmployeeId().equals(employeeId)) {
                faculty.remove(i);
                removed = true;
                System.out.println("Faculty details deleted successfully!");
                break;
            }
        }

        if (!removed) {
            System.out.println("Faculty with employee ID " + employeeId + " not found!");
        }
    }

    public static void displayDetails() {
        System.out.println("Student Details:");
        for (Student student : students) {
            System.out.println("Roll Number: " + student.getRollNumber() + ", Name: " + student.getName());
        }

        System.out.println();

        System.out.println("Faculty Details:");
        for (Faculty facultyMember : faculty) {
            System.out.println("Employee ID: " + facultyMember.getEmployeeId() + ", Name: " + facultyMember.getName());
        }
    }
}