package iiitk;
import iiitk.admin.*;
import iiitk.academics.*;
import iiitk.faculty.FacultyAttendanceMarksManagement;
import iiitk.student.StudentUser;
import java.util.*;
public class IIITKApp {
    IIITKApp(){
        System.out.println("\n############################\n");
        System.out.println("\n  WELCOME TO IIIT KOTTAYAM  \n");
        System.out.println("\n############################\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("******************************************");
            System.out.println("IIIT Kottayam Management System");
            System.out.println("1. Admin User");
            System.out.println("2. Academic User");
            System.out.println("3. Faculty User");
            System.out.println("4. Student User");
            System.out.println("5. Exit");
            System.out.println("******************************************");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    AdminApp adminApp = new AdminApp();
                    adminApp.run();
                    break;
                case 2 :
                    AcademicsApp academicsApp = new AcademicsApp();
                    academicsApp.run();
                    break;
                case 3 :
                    FacultyAttendanceMarksManagement facultyUser = new FacultyAttendanceMarksManagement();
                    facultyUser.run();
                    break;
                case 4 :
                    StudentUser studentUser = new StudentUser();
                    studentUser.run();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.println();
        } while (choice != 5);

        scanner.close();
    }
}
