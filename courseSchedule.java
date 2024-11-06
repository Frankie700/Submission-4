public class courseSchedule
{
    private String day;
    private timeSlot time;

    public courseSchedule(String schedule)
    {
        parseSchedule(schedule);
    }

    private void parseSchedule(String schedule)
    {
        String[] parts = schedule.split(" ", 2);
        this.day = parts[0];

        // Assuming format "10:30AM-12:00PM"
        String[] times = parts[1].split("-");
        this.time = new timeSlot(times[0], times[1]);
    }

    public String getDay()
    {
        return day;
    }

    public timeSlot getTime()
    {
        return time;
    }

    @Override
    public String toString()
    {
        return  day  + " " + time;
    }
}
