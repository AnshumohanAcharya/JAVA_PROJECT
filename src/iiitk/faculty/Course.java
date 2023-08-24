package iiitk.faculty;

public class Course {
    private static String courseName;
    Course(String courseName)
    {
        this.courseName = courseName;
    }

    String getName()
    {
        return this.courseName;
    }
}
