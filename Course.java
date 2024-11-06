
/*******************************************************************
 * @author Tchinda Yan  (Project Team work)
 * @date oct - 06 - 2024
 * @version v1
 * 
 * A program to have a complete information about a course with a higher level of abstraction
 */

public class Course 
{
    private String courseName;
    private CourseSchedule schedule;

    
    public Course(String courseName, CourseSchedule schedule) 
    {
        this.courseName = courseName;
        this.schedule = schedule;
    }

    public String getCourseName() 
    {
        return courseName;
    }

    public CourseSchedule getSchedule() 
    {
        return schedule;
    }

    // Method to check if the current course conflicts with another course
    public boolean conflictsWith(Course otherCourse) 
    {
        // Check if the day matches
        if (this.schedule.getDay().equalsIgnoreCase(otherCourse.getSchedule().getDay())) 
        {
            // If days match, check if the time slots overlap
            if (this.schedule.getTimeSlot().conflictsWith(otherCourse.getSchedule().getTimeSlot())) 
            {
                return true; 
            }
        }
        return false;
    }
   
    @Override
    public String toString() 
    {
        return courseName + ": " + schedule.toString();
    }
}
