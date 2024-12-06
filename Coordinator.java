import java.util.*;

public class Coordinator {
    private Map<String, Group> groups;
    private Scanner scanner;

    public Coordinator() {
        this.groups = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Multi-Group Schedule Manager!");
        boolean running = true;

        while (running) {
            System.out.println("Options: 1-Create Group, 2-Add Course to Group, 3-Add Event to Group, 4-View All Schedules, 5-Save Group, 6-Load Group, 7-Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createGroup();
                    break;
                case 2:
                    addCourseToGroup();
                    break;
                case 3:
                    addEventToGroup();
                    break;
                case 4:
                    viewAllSchedules();
                    break;
                case 5:
                    saveGroup();
                    break;
                case 6:
                    loadGroup();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("Goodbye!");
    }

    private void createGroup() {
        System.out.println("Enter Group Name:");
        String groupName = scanner.nextLine();
        groups.put(groupName, new Group());
        System.out.println("Group '" + groupName + "' created.");
    }

    private void addCourseToGroup() {
        System.out.println("Enter Group Name:");
        String groupName = scanner.nextLine();
        Group group = groups.get(groupName);

        if (group != null) {
            System.out.println("Enter Course Name:");
            String courseName = scanner.nextLine();
            System.out.println("Enter Day (e.g., Monday):");
            String dayName = scanner.nextLine();
            System.out.println("Enter Time Slot (e.g., 10:00 am - 11:00 am):");
            String timeSlot = scanner.nextLine();
            System.out.println("Enter Instructor Name:");
            String instructor = scanner.nextLine();

            Day day = new Day(dayName);
            if (!day.isValidDay()) {
                System.out.println("Invalid day entered. Please enter a valid day.");
                return;
            }

            TimeSlot time = new TimeSlot(day, new Time(timeSlot));
            CourseSchedule course = new CourseSchedule(time, new Course(courseName), instructor);
            group.addCourseSchedule(course);

            System.out.println("Course added to group '" + groupName + "'.");
            displayAndCheckConflicts(group);
        } else {
            System.out.println("Group '" + groupName + "' does not exist.");
        }
    }

    private void addEventToGroup() {
        System.out.println("Enter Group Name:");
        String groupName = scanner.nextLine();
        Group group = groups.get(groupName);

        if (group != null) {
            System.out.println("Enter Event Name:");
            String eventName = scanner.nextLine();
            System.out.println("Enter Day (e.g., Monday):");
            String dayName = scanner.nextLine();
            System.out.println("Enter Time Slot (e.g., 2:00 pm - 3:00 pm):");
            String timeSlot = scanner.nextLine();

            Day day = new Day(dayName);
            if (!day.isValidDay()) {
                System.out.println("Invalid day entered. Please enter a valid day.");
                return;
            }

            TimeSlot time = new TimeSlot(day, new Time(timeSlot));
            noneCourseSchedule event = new noneCourseSchedule(time, eventName);
            group.addNonCourseSchedule(event);
            System.out.println("Event added to group '" + groupName + "'.");
        } else {
            System.out.println("Group '" + groupName + "' does not exist.");
        }
    }

    private void viewAllSchedules() {
        System.out.println("Enter Group Name:");
        String groupName = scanner.nextLine();
        Group group = groups.get(groupName);

        if (group != null) {
            System.out.println(group);
        } else {
            System.out.println("Group '" + groupName + "' does not exist.");
        }
    }

    private void saveGroup() {
        System.out.println("Enter Group Name to Save:");
        String groupName = scanner.nextLine();
        Group group = groups.get(groupName);

        if (group != null) {
            System.out.println("Enter filename to save:");
            String filename = scanner.nextLine();
            GroupPersistence.saveGroup(group, filename);
            System.out.println("Group '" + groupName + "' saved.");
        } else {
            System.out.println("Group '" + groupName + "' does not exist.");
        }
    }

    private void loadGroup() {
        System.out.println("Enter filename to load:");
        String filename = scanner.nextLine();
        Group loadedGroup = GroupPersistence.loadGroup(filename);

        if (loadedGroup != null) {
            System.out.println("Enter name for the loaded group:");
            String groupName = scanner.nextLine();
            groups.put(groupName, loadedGroup);
            System.out.println("Group loaded as '" + groupName + "'.");
        }
    }

    private void displayAndCheckConflicts(Group group) {
        Map<String, List<CourseSchedule>> scheduleByDay = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        for (CourseSchedule course : group.getCourseList().getScheduleList()) {
            String day = course.getTimeSlot().getDay().getDay();
            scheduleByDay.computeIfAbsent(day, k -> new ArrayList<>()).add(course);
        }

        for (Map.Entry<String, List<CourseSchedule>> entry : scheduleByDay.entrySet()) {
            String day = entry.getKey();
            List<CourseSchedule> courses = entry.getValue();

            // Sort courses by time on the day
            courses.sort(Comparator.comparing(cs -> cs.getTimeSlot().getTime()));

            System.out.println(day + ":");
            for (CourseSchedule course : courses) {
                System.out.println(course);
            }

            // Check for conflicts
            checkInstructorConflicts(courses);
        }
    }

    private void checkInstructorConflicts(List<CourseSchedule> courses) {
        for (int i = 0; i < courses.size(); i++) {
            CourseSchedule cs1 = courses.get(i);
            for (int j = i + 1; j < courses.size(); j++) {
                CourseSchedule cs2 = courses.get(j);
                if (cs1.getInstructor().equals(cs2.getInstructor()) && hasTimeOverlap(cs1.getTimeSlot(), cs2.getTimeSlot())) {
                    System.out.println("Conflict detected for instructor '" + cs1.getInstructor() + "': " +
                            cs1 + " overlaps with " + cs2);
                }
            }
        }
    }

    private boolean hasTimeOverlap(TimeSlot t1, TimeSlot t2) {
        return t1.getDay().equals(t2.getDay()) && t1.getTime().compareTo(t2.getTime()) == 0;
    }
}
