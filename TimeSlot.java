/*******************************************************************
 * @author Tchinda Yan  (Project Team work)
 * @date oct - 06 - 2024
 * version v1
 * 
 * A program to implement the time slots of a particular course
 */

public class TimeSlot 
{
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;
    private String startPeriod; // "AM" or "PM"
    private String endPeriod;   // "AM" or "PM"

    public TimeSlot(int startHour, int startMinute, String startPeriod, int endHour, int endMinute, String endPeriod) 
    {
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.startPeriod = startPeriod;
        this.endHour = endHour;
        this.endMinute = endMinute;
        this.endPeriod = endPeriod;
    }

    public String getStartTime() 
    {
        return String.format("%02d:%02d %s", startHour, startMinute, startPeriod);
    }

    public String getEndTime() 
    {
        return String.format("%02d:%02d %s", endHour, endMinute, endPeriod);
    }

    // A method to evaluate complict between two time slots
    public boolean conflictsWith(TimeSlot other) 
    {
        int thisStart = to24HourFormat(startHour, startMinute, startPeriod);
        int thisEnd = to24HourFormat(endHour, endMinute, endPeriod);
        int otherStart = to24HourFormat(other.startHour, other.startMinute, other.startPeriod);
        int otherEnd = to24HourFormat(other.endHour, other.endMinute, other.endPeriod);

        return (thisStart < otherEnd && thisEnd > otherStart);
    }

    public int compareTo(TimeSlot other)
    {
          if (!this.startPeriod.equals(other.startPeriod)) 
        {
            return this.startPeriod.equals("AM") ? -1 : 1;
        }
        
        if (this.startHour != other.startHour) 
        {
            return Integer.compare(this.startHour, other.startHour);
        }
        
        return Integer.compare(this.startMinute, other.startMinute);
    }
    
    // A method to read time in a 12H format
    private int to24HourFormat(int hour, int minute, String period) 
    {
        if (period.equals("PM") && hour != 12) 
        {
            hour += 12;
        } 
        else if (period.equals("AM") && hour == 12) 
        {
            hour = 0;
        }
        return hour * 60 + minute; 
    }

    @Override
    public String toString() 
    {
        return getStartTime() + " - " + getEndTime();
    }
}
