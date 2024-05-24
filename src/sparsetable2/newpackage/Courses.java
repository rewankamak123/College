package sparsetable2.newpackage;

public class Courses {
  //class linkedlist
    Course firstcourse; //head
    
    //class nodes
    public class Course{
    String course_name;
    Course next;
    Node FirstStudentNode; //اول طالب سجل في الكورس ده
    
    //constructor
    public  Course(String course_name){
        this.course_name=course_name;
    }

        public Node getFirstStudentNode() {
            return this.FirstStudentNode;
        }

        public void setFirstStudentNode(Node FirstStudentNode) {
            this.FirstStudentNode = FirstStudentNode;
        }

        public String getCourse_name() {
            return this.course_name;
        }
    }

    public Course getFirstcourse() {
        return this.firstcourse;
    }
    
        //method to add new course
    public Course addCourse(String course_name){
        Course newCourse=new Course(course_name);
        //first node
        if(firstcourse==null){
            firstcourse=newCourse;
            firstcourse.next=null;
        }
        //add to tail
        else{
            Course pointerCourse=firstcourse;
            while(pointerCourse.next!=null){
                pointerCourse=pointerCourse.next;
            }
            pointerCourse.next=newCourse;
        }
        return newCourse;
    }
    public Course PrintAllCourses(){
        Course i=firstcourse;
        while(i!=null){
            System.out.println(i.course_name);
            i=i.next;
        }
        return i;
    }
    public void SearchCourse(String name){
        Course i=firstcourse;
         boolean found=false;
         while(i!=null){
            found=false;

             if(i.course_name.equalsIgnoreCase(name)){
                 System.out.println(i.getCourse_name()+" taken by "+" -------> "); 
                 if(i.getFirstStudentNode()==null){
            System.out.println("No students for "+i.getCourse_name());
        }
                 else{
            Node j=i.getFirstStudentNode();
            while(j!=null){
                System.out.println(j.getStudent_name()+" with ID "+j.student_id); 
                j=j.getNextRight(); }
            
        }
                 break;
             }else {
              found =true;
              
           }
             i=i.next;
         }
         if(found){
            System.out.println("Course not found!");
        }
    }
    
}