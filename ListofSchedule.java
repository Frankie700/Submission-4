import java.io.Serializable;
import java.util.ArrayList;

public class ListofSchedule<T> implements Serializable {
    private ArrayList<T> scheduleList;

    public ListofSchedule() {
        this.scheduleList = new ArrayList<>();
    }

    public void add(T item) {
        scheduleList.add(item);
    }

    public ArrayList<T> getScheduleList() {
        return scheduleList;
    }

    @Override
    public String toString() {
        return scheduleList.toString();
    }
}
