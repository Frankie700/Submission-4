import java.io.Serializable;

public class TimeSlot implements Serializable {
    private Day myDay;
    private Time myTime;

    public TimeSlot(Day day, Time time) {
        this.myDay = day;
        this.myTime = time;
    }

    public Time getTime() {
        return myTime;
    }

    public Day getDay() {
        return myDay;
    }

    public void setTime(Time time) {
        this.myTime = time;
    }

    public void setDay(Day day) {
        this.myDay = day;
    }

    @Override
    public String toString() {
        return myDay + " " + myTime;
    }
}
