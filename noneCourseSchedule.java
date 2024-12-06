import java.io.Serializable;

public class noneCourseSchedule implements Serializable {
    private final TimeSlot timeSlot;
    private final String event;

    public noneCourseSchedule(TimeSlot timeSlot, String event) {
        this.timeSlot = timeSlot;
        this.event = event;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String toString() {
        return event + ", " + timeSlot;
    }
}
