package iiitk.admin;

import static iiitk.admin.AdminApp.students;

public class Faculty {
    private String employeeId;
    private String name;
    private String course;
    // Add other relevant faculty details as per your requirement

//    public void insertAttendance(String period, boolean[] attendance) {
//        for (Student student : students) {
//            student.setAttendance(period, attendance[Integer.parseInt(student.getRollNumber())-1]);
//        }
//    }
//
//    public void updateAttendance(String period,String RollNum,boolean[] attendance) {
//        for (Student student : students) {
//            if (attendance[Integer.parseInt(student.getRollNumber())-1]) {
//                student.setAttendance(period, false);
//            }
//            else
//                student.setAttendance(period, true);
//        }
//    }
//
//    public void deleteAttendance(String period , String RollNum , boolean[] attendance) {
//        for (Student student : students) {
//            student.deleteAttendance(period);
//        }
//    }
//
//    public void showAttendance(String period) {
//        for (Student student : students) {
//            boolean isPresent = student.getAttendance(period);
//            System.out.println("Name : " + student.getName() + " (Roll Number: " + student.getRollNumber() + ") - " + (isPresent ? "Present" : "Absent"));
//        }
//    }
//
//    public void insertMarks(int midSemester1, int midSemester2, int endSemester) {
//        for (Student student : students) {
//            student.setMarks(midSemester1, midSemester2, endSemester);
//        }
//    }
//
//    public void updateMarks(int midSemester1, int midSemester2, int endSemester) {
//        for (Student student : students) {
//            student.updateMarks(midSemester1, midSemester2, endSemester);
//        }
//    }
//
//    public void deleteMarks() {
//        for (Student student : students) {
//            student.deleteMarks();
//        }
//    }
//
//    public void showMarks() {
//        for (Student student : students) {
//            System.out.println(student.getName() + " (Roll Number: " + student.getRollNumber() + ")");
//            System.out.println("Mid Semester 1: " + student.getMidSemester1());
//            System.out.println("Mid Semester 2: " + student.getMidSemester2());
//            System.out.println("End Semester: " + student.getEndSemester());
//            System.out.println();
//        }
//    }

    public Faculty(String employeeId,String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public Faculty(String employeeId, String name , String course)
    {
        this.employeeId = employeeId;
        this.name = name;
        this.course = course;
    }

    // Add getters and setters for other faculty details as per your requirement

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String setName(String str) {
        return this.name = str;
    }

    public String getCourse() { return course; }

    public String setCourse(String str) { return this.course = str; }
}
