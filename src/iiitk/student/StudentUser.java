package iiitk.student;

import iiitk.admin.Student;

import java.util.Scanner;

public class StudentUser {

    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Student Attendance report");
        System.out.println("2. Student Examination report");
        System.out.println("3. Return");
        System.out.println("Enter your choice : ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> viewAttendanceDetails(scanner);
            case 2 -> viewMarksDetails(scanner);
            case 3 -> {
                return;
            }
            default -> System.out.println("Invalid choice!");
        }
    }

    private static void viewMarksDetails(Scanner scanner) {
        String name = scanner.nextLine();
        Student ob = new Student(name);
        ob.viewMarksReport(scanner);
    }

    private static void viewAttendanceDetails(Scanner scanner) {
        String name = scanner.nextLine();
        Student ob = new Student(name);
        ob.viewAttendanceReport(scanner);
    }
}
