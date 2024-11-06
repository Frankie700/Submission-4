public class Driver
{
    public static void main(String[] args)
    {
        // Create instructors
        Instructor instructor1 = new Instructor("Dr. Smith", "Smith@unb.ca");
        Instructor instructor2 = new Instructor("Prof. Johnson", "Johnson@unb.ca");

        // Create courses with course code, extra text, instructor, and schedule
        Course course1 = new Course("CS101", "Intro to CS", instructor1, "W 10:30 AM-12:00 PM");
        Course course2 = new Course("CS102", "Data Structures", instructor1, "W 10:30 AM-12:00 PM");
        Course course3 = new Course("CS2043", "Software Engineering", instructor2, "F 1:00 PM-2:30 PM");

        // Create a group and add courses to it
        Group group = new Group("Fall Semester Group");
        group.addCourse(course1);
        group.addCourse(course2);
        group.addCourse(course3);

        // Display the group's weekly schedule
        group.displaySchedule();
        group.checkConflict();
    }
}
