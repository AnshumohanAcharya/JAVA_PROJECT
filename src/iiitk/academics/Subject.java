package iiitk.academics;

import iiitk.admin.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject {
    private String subjectCode;
    private String subjectName;
    private String name;
    private Map<String, Boolean> attendance;  // Modified to use a Map instead of a List
    private Map<String, List<Integer>> marks;

    public Subject(String subjectCode, String subjectName) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.marks = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Subject(String name) {
        this.name = name;
        this.attendance = new HashMap<>();
        this.marks = new HashMap<>();
    }

    // Modified to return a Map<String, Boolean>
    public Map<String, Boolean> getAttendance() {
        return attendance;
    }

    public void setAttendance(Map<String, Boolean> attendance) {
        this.attendance = attendance;
    }

    public void resetAttendance() {
        for (String studentName : attendance.keySet()) {
            attendance.put(studentName, false);
        }
    }
    public Map<String, List<Integer>> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, List<Integer>> marks) {
        this.marks = marks;
    }
    public void resetMarks() {
        for(String studentName : marks.keySet()) {
            marks.put(studentName, new ArrayList<>());
        }
    }
}

