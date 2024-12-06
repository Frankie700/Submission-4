import java.io.Serializable;
import java.util.Scanner;

public class Time implements Comparable<Time>, Serializable {
    private String timeRange;

    public Time(String timeRange) {
        this.timeRange = validateTimeRange(timeRange);
    }

    public String getTime() {
        return timeRange;
    }

    public void setTime(String timeRange) {
        this.timeRange = validateTimeRange(timeRange);
    }

    public int getStartMinutes() {
        return convertToMinutes(timeRange.split("-")[0].trim());
    }

    public int getEndMinutes() {
        return convertToMinutes(timeRange.split("-")[1].trim());
    }

    public String timeLine() {
        if (timeRange.contains("-")) {
            String[] times = timeRange.split("-");
            String startTime = times[0].trim();
            String endTime = times[1].trim();

            try {
                int startMinutes = convertToMinutes(startTime);
                int endMinutes = convertToMinutes(endTime);

                if (startMinutes < endMinutes) {
                    return startTime + " - " + endTime;
                } else {
                    return "Start time must be smaller than end time.";
                }
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            }
        } else {
            return "Please enter a time range in the format: 'hh:mm am/pm - hh:mm am/pm'.";
        }
    }

    private int convertToMinutes(String time) throws IllegalArgumentException {
        try {
            int hours = Integer.parseInt(time.substring(0, 2).trim());
            int minutes = Integer.parseInt(time.substring(3, 5).trim());
            String period = time.substring(5).trim().toLowerCase();

            if (period.equals("pm") && hours != 12) {
                hours += 12;
            } else if (period.equals("am") && hours == 12) {
                hours = 0;
            }

            return hours * 60 + minutes;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid time format. Please use 'hh:mm am/pm'.");
        }
    }

    private String validateTimeRange(String timeRange) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;

        do {
            try {
                String[] times = timeRange.split("-");
                if (times.length == 2) {
                    int startMinutes = convertToMinutes(times[0].trim());
                    int endMinutes = convertToMinutes(times[1].trim());

                    if (startMinutes >= endMinutes) {
                        throw new IllegalArgumentException("Start time must be smaller than end time.");
                    }

                    if (checkInstructorConflict(startMinutes, endMinutes)) {
                        throw new IllegalArgumentException("Time range conflicts with the instructor's schedule.");
                    }

                    valid = true;
                } else {
                    throw new IllegalArgumentException("Invalid time range format.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter a valid time range (e.g., '08:00 am - 09:00 am'):");
                timeRange = scanner.nextLine();
            }
        } while (!valid);

        return timeRange;
    }

    private boolean checkInstructorConflict(int startMinutes, int endMinutes) {
       
        return false;
    }

    @Override
    public int compareTo(Time other) {
        int thisStartMinutes = getStartMinutes();
        int otherStartMinutes = other.getStartMinutes();
        return Integer.compare(thisStartMinutes, otherStartMinutes);
    }

    @Override
    public String toString() {
        return "Time Range: " + timeRange;
    }
}
