import java.io.Serializable;

public class Course implements Serializable {
    private final String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return courseName;
    }
}
