import java.io.Serializable;

public class Day implements Serializable {
    private String day;

    public Day(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return day;
    }

    public boolean isValidDay() {
        switch (day.toLowerCase()) {
            case "monday":
            case "tuesday":
            case "wednesday":
            case "thursday":
            case "friday":
            case "saturday":
            case "sunday":
                return true;
            default:
                return false;
        }
    }
}
