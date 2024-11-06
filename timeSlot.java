import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class timeSlot
{
    private LocalTime startTime;
    private LocalTime endTime;

    public timeSlot(String startTime, String endTime)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mma"); // Format for "10:30AM"
        this.startTime = LocalTime.parse(startTime, formatter);
        this.endTime = LocalTime.parse(endTime, formatter);
    }

    public boolean overlapsWith(timeSlot other) {
        return this.startTime.isBefore(other.endTime) && this.endTime.isAfter(other.startTime);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mma");
        return startTime.format(formatter) + " - " + endTime.format(formatter);
    }
}
