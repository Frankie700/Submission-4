import java.util.*;
public class Course
{
    private String courseCode;
    private String extraText;
    private Instructor instructor;
    private courseSchedule newSchedule;

    public Course(String courseCode, String extraText, Instructor instructor, String newSchedule)
    {
        this.courseCode = courseCode;
        this.extraText = extraText;
        this.instructor = instructor;
        this.newSchedule = new courseSchedule(newSchedule);

    }

    public courseSchedule getNewSchedule()
    {
        return newSchedule;
    }

    public String getCourseCode()
    {
        return courseCode;
    }

    public String getExtraText()
    {
        return extraText;
    }

    @Override

    public  String toString()
    {
        return courseCode + " " + extraText + " " + instructor.toString() + " " + newSchedule.toString();
    }
}