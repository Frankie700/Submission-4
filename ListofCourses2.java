import java.util.ArrayList;
/*******************************************************************
 * @author Tchinda Yan  (Project Team work)
 * @date oct - 06 - 2024
 * @version v1
 * 
 * A program to have a catalog of course offered by the school system .
 * This gives the user the possibilty to select his course term from a list of courses
 */

public class ListofCourses2<y >
{
   private ArrayList<y> availableCourses;
   
   public ListofCourses2()
   {
       this.availableCourses = new ArrayList<>();
   }
   
   public ArrayList<y> getCourses()
   {
       return availableCourses;
   }
   
   public void addCourse(y c)
   {
       availableCourses.add(c);
   }
   
   public String toString()
   {
       String result;
       
       result = "Courses Available " +availableCourses+ "\n";
       
       return result;
   }
}
