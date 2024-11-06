import java.util.Scanner;

/*******************************************************************
 * @author Tchinda Yan  (Project Team work)
 * @date oct - 06 - 2024
 * @version v1
 * 
 * A program to implement a course selection planner
 */
public class UI
{
   
    public static void main (String[]args)
    {
        Scanner input = new Scanner(System.in);
        
        String groupName;
        
        TimeSlot c1 = new TimeSlot(11 , 00 , "AM" , 12 , 45 , "PM" );
        TimeSlot c2 = new TimeSlot(10 , 25 , "AM" , 12 , 45 , "PM" );
        TimeSlot c3 = new TimeSlot(10 , 25 , "AM" , 12 , 45 , "PM" );
        TimeSlot c4 = new TimeSlot(8 , 30 , "AM" , 10 , 45 , "AM" );
        
        ListofCourses2<Course> catalog = new ListofCourses2<>();
        catalog.addCourse(new Course ("cs 1083", new CourseSchedule("J.Tasse" , "LEC" , "Monday", c1)));
        catalog.addCourse(new Course ("Mechine levels", new CourseSchedule("Jeffery McNally" , "LAB","Tuesday", c2 )));
        catalog.addCourse(new Course ("Data Structure & Algorithms", new CourseSchedule("J.Tasse" , "LEC" , "Wednesday", c3)));
        catalog.addCourse(new Course ("cs 1003", new CourseSchedule("Dr. Mahanti" , "LEC" , "Monday", c1)));
        catalog.addCourse(new Course ("Stat 2", new CourseSchedule("P. Muz" , "LEC" , "Monday", c4)));
        catalog.addCourse(new Course ("Calculus 1", new CourseSchedule("Dr. Neil" , "LEC" , "Monday", c2)));
        catalog.addCourse(new Course ("cs 2803", new CourseSchedule("Dr. Janet" , "LAB" , "Tuesday", c1)));
        
        System.out.println("Please enter a name for your group");
        groupName = input.nextLine();
        Group userGroup = new Group(groupName);
        
        System.out.println("Enter (done) to exit");
        System.out.println("Please enter your course names");
        
         while (true) 
         {
            String courseName = input.nextLine();
            if (courseName.equalsIgnoreCase("done")) break;


            boolean found = false;
            for (Course course : catalog.getCourses()) 
            {
                if (course.getCourseName().equalsIgnoreCase(courseName)) 
                {
                    userGroup.addToGroup(course);
                    System.out.println(courseName + " added to group " + groupName);
                    found = true;
                    break;
                }
            }
            
            if (!found) 
            {
                System.out.println("Course not found. Please enter a valid course name.");
            }
        }
        
        
        System.out.println("\n" +userGroup);
        input.close();
    }
}
