package iiitk.admin;

import iiitk.academics.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static iiitk.academics.AcademicsApp.subjects;

public class Student {
    private String rollNumber;
    private String name;
    private String branch;
    private double marks;
    private int midSemester1;
    private int midSemester2;
    private int endSemester;
    private Boolean attendance;
    private List<Subject> registeredSubjects;

    public Student(String rollNumber,String name , String branch) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.midSemester1 = 0;
        this.midSemester2 = 0;
        this.endSemester = 0;
        this.branch = branch;
    }

    public Student(Student student) {
        name = student.name;
    }

    public String getRollNumber() {
        return rollNumber;
    }
    public Student(String name,String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

        public Student(String name) {
            this.name = name;
            this.attendance = false;
            this.registeredSubjects = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public boolean getAttendance() {
            return attendance;
        }

        public void setAttendance(boolean attendance) {
            this.attendance = attendance;
        }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getRegisteredSubjects() {
        return registeredSubjects;
    }

    public void viewAttendanceReport(Scanner scanner) {
        System.out.println("Attendance Report for Student: " + name);
//        for (Map.Entry<String, Subject> subject : subjects.entrySet()) {
//            Map<String, Boolean> courseAttendance = (Map<String, Boolean>) subject.getValue();
//            System.out.println("Subject: " + subject.getKey());
//            for (Map.Entry<String, Boolean> entry : courseAttendance.entrySet()) {
//                String studentName = entry.getKey();
//                Boolean attendanceStatus = entry.getValue();
//                if (studentName.equals(name)) {
//                    System.out.println("Attendance: " + (attendanceStatus ? "Present" : "Absent"));
//                    break;
//                }
//            }
//            System.out.println();
//        }
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

    public void viewMarksReport(Scanner scanner) {
        System.out.println("Marks Report for Student: " + name);
//        for (Map.Entry<String,Subject> subject : subjects.entrySet()) {
//            Map<String, List<Integer>> courseMarks = subject.getMarks();
//            System.out.println("Subject: " + subject.getKey());
//            for (Map.Entry<String, List<Integer>> entry : courseMarks.entrySet()) {
//                String studentName = entry.getKey();
//                List<Integer> marksList = entry.getValue();
//                if (studentName.equals(name)) {
//                    System.out.println("Marks for Mid Semester 1: " + marksList.get(0));
//                    System.out.println("Marks for Mid Semester 2: " + marksList.get(1));
//                    System.out.println("Marks for End Semester Exam: " + marksList.get(2));
//                    break;
//                }
//            }
        System.out.println("Enter course ID : ");
        String courseName = scanner.next();
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
            System.out.println();
    }
}