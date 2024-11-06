import java.util.ArrayList;
import java.util.Scanner;

/*******************************************************************
 * @author Tchinda Yan  (Project Team work)
 * @date oct - 06 - 2024
 * @version v1
 * 
 * A program  to group courses selected by a user from the catalog under a single selection name
 
 * Grouping will permite diffrent instructor and courses to be compare in a same module
 */
public class Group
{
    private String name;
    private ArrayList<Course> arr;
    
    public Group(String name)
    {
        this.name = name;
        this.arr = new ArrayList<>();
    }
    
    
     // Add course to group if no conflict with other courses in the group
    public boolean addToGroup(Course newCourse) 
    {
        
        for (Course existingCourse : arr) 
        {
            // Check if there's a conflict between the new course and an existing course
            if (existingCourse.conflictsWith(newCourse)) 
            {
                System.out.println("Conflict detected: " + newCourse.getCourseName() + 
                                   " cannot be added due to a time conflict with " + existingCourse.getCourseName() + ".");
                return false; 
            }
        }

        // If no conflict, add the course to the group
        arr.add(newCourse);
        
        for (int i = 0; i < arr.size() - 1; i++) 
        {
        
            for (int j = i + 1; j < arr.size(); j++) 
            {
            Course course1 = arr.get(i);
            Course course2 = arr.get(j);

            int dayComparison = course1.getSchedule().getDay().compareTo(course2.getSchedule().getDay());
            
            if (dayComparison > 0 || 
                (dayComparison == 0 && course1.getSchedule().getTimeSlot().compareTo(course2.getSchedule().getTimeSlot()) > 0)) 
            {
                arr.set(i, course2);
                arr.set(j, course1);
            }
        }
      }
        return true;
    }

    public ArrayList<Course> getC()
    {
        return arr;
    }
    
    public String getName()
    {
        return name;
    }
   
     public String toString()
    {
        String result;
        
        result = "Group name : " +name+ "\n courses selected: \n";
        
        result += displayCoursesByDay("Monday");
        result += displayCoursesByDay("Tuesday");
        result += displayCoursesByDay("Wednesday");
        result += displayCoursesByDay("Thursday");
        result += displayCoursesByDay("Friday");
        
        return result;
    }
    
    // A method of group courses inorder of day
    private String displayCoursesByDay(String day)
    {
        String result = "";
        
        boolean dayCourses = false;
        
        for(Course course : arr)
        {
            if(course.getSchedule().getDay().equals(day))
            {
                if(!dayCourses)
                {
                    result +=day +":\n";
                    
                    dayCourses = true;
                }
                
                result += ""+course.getCourseName() + "-" + course.getSchedule().getTimeSlot()+ "\n";
            }
        }
        
        return result;
    }
}
    
    
    