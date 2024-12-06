import java.io.Serializable;

public class CourseSchedule implements Serializable {
    private TimeSlot timeSlot;
    private Course course;
    private String instructor;

    public CourseSchedule(TimeSlot timeSlot, Course course, String instructor) {
        this.timeSlot = timeSlot;
        this.course = course;
        this.instructor = instructor;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Course getCourse() {
        return course;
    }

    public String getInstructor() {
        return instructor;
    }

    @Override
    public String toString() {
        return course + ", " + instructor + ", " + timeSlot;
    }
}
