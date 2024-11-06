
/*******************************************************************
 * @author Tchinda Yan  (Project Team work)
 * @date oct - 06 - 2024
 * @version v1
 * 
 * A program to implement a course schedule given time and every detail about an instructor and the class he teaches
 */
public class CourseSchedule
{
   private TimeSlot time;
   private String day;
   private String instructor;
   private String classLecture;
   
   public CourseSchedule(String instructor , String classLecture , String day , TimeSlot time)
   {
       this.instructor = instructor;
       this.classLecture = classLecture;
       this.day = day;
       this.time = time;
   }

   public String getinstructor()
   {
       return instructor ;
   }
   
   public String classLecture()
   {
       return classLecture;
   }
   
   public String getDay()
   {
       return day;
   }

   public TimeSlot getTimeSlot()
   {
       return time;
   }
   
   public String toString()
   {
       String result = "t";
       
       result = result.format("%3s , %3s " , instructor , classLecture ) +time+""+"\n";
       
       return result;
   }
}
