import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private List<Course> newCourse;

    public Group(String groupName) {
        this.groupName = groupName;
        this.newCourse = new ArrayList<Course>();
    }

    public void addCourse(Course course)
    {
        newCourse.add(course);
    }

    public void displaySchedule()
    {
        // Days of the week
        String[] daysOfWeek = {"M", "T", "W", "Th", "F", "Sa", "Su"};

        for (String day : daysOfWeek)
        {
            System.out.println(day + ":");

            // Flag to check if there are any courses for this day
            boolean hasCourses = false;
            for (Course course : newCourse)
            {
                // Get the day from the course's schedule
                String courseDay = course.getNewSchedule().getDay();

                // Check if the course day matches the current day
                if (courseDay.equalsIgnoreCase(day))
                {
                    System.out.println("    " + course);
                    hasCourses = true;
                }
            }
            if (!hasCourses)
            {
                System.out.println("    No courses scheduled.");
            }

        }

    }

    public void checkConflict()
    {
        boolean conflict = false;
        System.out.println("Checking for conflicts in the group: " + groupName);

        for (int i = 0; i < newCourse.size(); i++)
        {
            for (int j = i + 1; j < newCourse.size(); j++)
            {
                courseSchedule schedule1 = newCourse.get(i).getNewSchedule();
                courseSchedule schedule2 = newCourse.get(j).getNewSchedule();

                if (schedule1.getDay().equals(schedule2.getDay()))
                {
                    if (schedule1.getTime().overlapsWith(schedule2.getTime()))
                    {
                        System.out.println("Conflict detected");
                        System.out.println("    " + newCourse.get(i));
                        System.out.println("    " + newCourse.get(j));
                        conflict = true;
                    }
                }

            }
        }

        if (!conflict)
        {
            System.out.println("No conflict detected");
            displaySchedule();

        }
    }
}



