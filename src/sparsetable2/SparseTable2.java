package sparsetable2;
import sparsetable2.newpackage.Node;
import sparsetable2.newpackage.Courses;
import sparsetable2.newpackage.Students;
import sparsetable2.newpackage.Courses.Course;
import sparsetable2.newpackage.Students.Student;
import java.util.*;
public class SparseTable2 {


    
public void addStudentinCourse(Student student, Course course){
    String studentname=student.getStudent_name();
    int studentid=student.getStudent_id();
    String coursename=course.getCourse_name(); //عشان اخزنهم في Node 
    
    Node newnode=new Node(studentname,studentid,coursename); //هخزنهم هنا
    
    //first student in course
    if(course.getFirstStudentNode()==null){
        course.setFirstStudentNode(newnode);
    }else{
        //add to tail
        Node i=course.getFirstStudentNode();
        while(i.getNextRight()!=null){
            i=i.getNextRight();
        }
        i.setNextRight(newnode);
    }
    
    //first course for a student
    if(student.getFirstCourseNode()==null){
        student.setFirstCourseNode(newnode);
    }
    else{
        //add to tail
        Node i=student.getFirstCourseNode();
        while(i.getNextDown()!=null){
            i=i.getNextDown();
        }
        i.setNextDown(newnode);
    }
}

//print courses for a student
    public void PrintCourses(Student student){
        //no courses
        if(student.getFirstCourseNode()==null){
            System.out.println("No courses for "+student.getStudent_name()+" with ID "+student.getStudent_id());
        }
        else{
            Node i=student.getFirstCourseNode();
            System.out.println(student.getStudent_name()+" with ID "+student.getStudent_id()+" enrolled in courses: ");
            while(i !=null){
                System.out.println(i.getCourse_name()); 
                i=i.getNextDown();
            }
        }
    }
    //print students enrolled in a course
    public void PrintStudents(Course course){
        //no students
        if(course.getFirstStudentNode()==null){
            System.out.println("No Students Enrolled in "+course.getCourse_name());
        }
        else{
            Node i=course.getFirstStudentNode();
            System.out.println("Students enrolled in "+course.getCourse_name()+" :");
            while(i !=null){
                System.out.println(i.getStudent_name()+" with ID "+i.getStudent_id());
                i=i.getNextRight();
            }
        }
    }
   

    
  public static void main(String[] args) {
Scanner in =new Scanner(System.in);
       Students students=new Students();
       Courses courses=new Courses();
       
       Student rowan=students.addStudent(22010340, "Rowan");
       Student lina=students.addStudent(22010380, "Lina");
       Student mari=students.addStudent(22010240, "Marihan");
       Student losy=students.addStudent(22010440, "Losy");

       
       
       Course DSA=courses.addCourse("DSA");
       Course DS=courses.addCourse("DS");
       Course calc=courses.addCourse("Calculus");
       Course DB=courses.addCourse("DB");
   
       SparseTable2 sparsetable= new SparseTable2();
       
       sparsetable.addStudentinCourse(lina, DS);
       sparsetable.addStudentinCourse(rowan, DS);
       sparsetable.addStudentinCourse(lina, DB);
       sparsetable.addStudentinCourse(mari, calc);
       sparsetable.addStudentinCourse(losy, calc);
       sparsetable.addStudentinCourse(rowan, DSA);
       
      
       System.out.print("click (1) to enable services : ");
       int services=in.nextInt();
       if(services==1){
           while(services==1){
         System.out.println("Enter (1) if you want to add new student with courses : ");
         System.out.println("Enter (2) if you want to Print all courses : ");
         System.out.println("Enter (3) if you want to Print all Students : ");
         System.out.println("Enter (4) if you want to Search about spesfic student : ");
         System.out.println("Enter (5) if you want to Search about spesfic course :");
         System.out.println("Enter (6) if you want to delete  spesfic student :");
         System.out.println("");
         System.out.print("Enter your choice : ");
         int Option =in.nextInt();
         System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
         switch(Option){
             case 1:
             {
                //------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("Do you want to add student? (y/n)");
        String choice=in.next();
        
        Student obj1 = null;
        ArrayList<Integer> test =new ArrayList();
        boolean flag=false;
        
        while(choice.equalsIgnoreCase("y")){
        if(choice.equalsIgnoreCase("y")){
            System.out.println("add student name: ");
            String name=in.next();
            System.out.println("add student id: ");
            int id=in.nextInt();
            if(students.checkID(id)==true){
          while(students.checkID(id)==true){
                 System.out.println("this ID has already added to another student! \n PLEASE TRY TO ENTER ANOTHER ID");
             System.out.println("add another id: ");
             id=in.nextInt();
             if(students.checkID(id)==false){                 
                  break;
             }
            }}
             obj1=students.addStudent(id, name);
            System.out.println("choose courses you want to add: ");
            System.out.println("(1)DSA \t (2)DS \t (3)DB \t (4)calculus");
            int CourseChoice =in.nextInt();
       
            test.add(CourseChoice);

            switch(CourseChoice){
                case 1:
                    sparsetable.addStudentinCourse(obj1, DSA);
                    break;
                    case 2:
                    sparsetable.addStudentinCourse(obj1, DS);
                    break;
                    case 3:
                    sparsetable.addStudentinCourse(obj1, DB);
                    break;
                    case 4:
                    sparsetable.addStudentinCourse(obj1, calc);
                    break;
                    default:
                         System.out.println("SORRY WE DON'T UNDERSTND YOUR CHOICE");
            }
            
            
            System.out.println("Do you want to add another course (Y Or N )");
          
            String  ChoiceCourse =in.next();
           
            while(ChoiceCourse.equalsIgnoreCase("Y"))
            {
                System.out.println("Enter the number of course : ");
            CourseChoice =in.nextInt();
            
             //=======================================================================================================

for(int i=0;i<test.size();i++){
    if(test.get(i)==(CourseChoice)){
        System.out.println("this course has already added...");
        flag=true;
        break;
}}
         //if(flag==true) break;
         test.add(CourseChoice);
            //============================================================================================================
           if(flag==false){
            switch(CourseChoice){
                case 1:
                    sparsetable.addStudentinCourse(obj1, DSA);
                    break;
                    case 2:
                    sparsetable.addStudentinCourse(obj1, DS);
                    break;
                    case 3:
                    sparsetable.addStudentinCourse(obj1, DB);
                    break;
                    case 4:
                    sparsetable.addStudentinCourse(obj1, calc);
                    break;
                    default:
                         System.out.println("SORRY WE DON'T UNDERSTND YOUR CHOICE");
            }
           }
            System.out.println("Do you want to add another course (Y Or N )");
              ChoiceCourse =in.next();

            }
                sparsetable.PrintCourses(obj1);
            System.out.println("Do you want to add any student else? (y/n)");
               choice=in.next();
        }
        }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
             }
             case 2:
             {
              courses.PrintAllCourses();
              break;
             }
             case 3:
             {
                 students.PrintAllStudents();
                 break;
             }
             case 4:
             {
                 System.out.print("Enter the student id that you want to search :");
                 int id =in.nextInt();
                students.searchStudent(id);
                 break;
             }
             case 5:
             {
                 System.out.print("Enter the course name that you want to search : ");
                 String coursename=in.next();
                 courses.SearchCourse(coursename);
                 break;
             }
             case 6 :{
                 System.out.println("Enter the student id that you want to remove : ");
                 int ID =in.nextInt();
               students.delete(ID);  
                 
               break;
             }
             default:
                 System.out.println("SOORY WE DONT UNDERSTAND YOUR CHOICE !");
         }
               System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
         System.out.println("Do you want any services else ? click (1) if yes & (2) if No ");
            services=in.nextInt();
            if(services==2){
                System.out.println("Ok,Thank you... ");
                break;
            }
           }
  }else System.out.println("SORRY WE DON'T UNDERSTND YOUR CHOICE");

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        

        }

}