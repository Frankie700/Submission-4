import java.io.Serializable;

public class Group implements Serializable {
    private ListofSchedule<CourseSchedule> courseList;
    private ListofSchedule<noneCourseSchedule> nonCourseList;

    public Group() {
        this.courseList = new ListofSchedule<>();
        this.nonCourseList = new ListofSchedule<>();
    }

    public void addCourseSchedule(CourseSchedule courseSchedule) {
        courseList.add(courseSchedule);
    }

    public void addNonCourseSchedule(noneCourseSchedule nonCourseSchedule) {
        nonCourseList.add(nonCourseSchedule);
    }

    public ListofSchedule<CourseSchedule> getCourseList() {
        return courseList;
    }

    public ListofSchedule<noneCourseSchedule> getNonCourseList() {
        return nonCourseList;
    }

    public void listConflicts() {
        for (CourseSchedule course : courseList.getScheduleList()) {
            for (noneCourseSchedule event : nonCourseList.getScheduleList()) {
                if (conflict(course.getTimeSlot(), event.getTimeSlot())) {
                    System.out.println("Conflict detected between:");
                    System.out.println("Course: " + course);
                    System.out.println("Event: " + event);
                }
            }
        }
    }

    private boolean conflict(TimeSlot t1, TimeSlot t2) {
        if (!t1.getDay().equals(t2.getDay())) {
            return false;
        }
        int start1 = t1.getTime().compareTo(t2.getTime());
        int end1 = t1.getTime().compareTo(t2.getTime());
        return start1 < end1;
    }

    @Override
    public String toString() {
        return "Courses: " + courseList + "\nNon-Course Events: " + nonCourseList;
    }
}
