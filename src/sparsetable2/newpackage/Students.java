package sparsetable2.newpackage;

public class Students {
   
    //students linkedlist
    Student firststudent; //head
    
    // students nodes
    public class Student{
      //students linkedlist
    Student firststudent; //head

    
      int student_id;
      String student_name;
      Student next;
      Node FirstCourseNode; //اول كورس الطالب مسجله
      
      //constructor
      public Student(int student_id, String student_name) {
            this.student_id = student_id;
            this.student_name = student_name;
        }

        private Student() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
      
        public int getStudent_id() {
        return this.student_id;
    }
        
        public Node getFirstCourseNode() {
            return this.FirstCourseNode;
        }
         public void setFirstCourseNode(Node FirstClassNode) {
            this.FirstCourseNode = FirstClassNode;
        }
        public String getStudent_name() {
            return this.student_name;
        }
    }
    //method to add new student
      public Student addStudent(int student_id, String student_name){
          Student newStudent=new Student(student_id, student_name);
          //first node
          if(firststudent==null){
              firststudent=newStudent;
              firststudent.next=null;
          }else{
              Student pointerStudent=firststudent;
              //add node to tail
              while(pointerStudent.next!=null){
                  pointerStudent=pointerStudent.next;
              }
              pointerStudent.next=newStudent;
          }
          return newStudent;
      }
       public Student PrintAllStudents(){
        Student i=firststudent;
        while(i!=null){
            System.out.println(i.student_name);
            i=i.next;
        }
        return i;
    }
      public boolean checkID(int ID){
        Student i=firststudent;
        boolean flag=false;
        while(i!=null){
           if(i.student_id==ID){
               flag=true;
               break;
           }
            i=i.next;
        }return flag;
          
        }
       public void searchStudent(int ID){
        Student i=firststudent;
        boolean found=false;
        while(i!=null){
           found =false;
           if(i.student_id==ID){
             
            System.out.println(i.getStudent_name()+" with ID "+i.getStudent_id()+" -------> "); 
               
             if(i.getFirstCourseNode()==null){
            System.out.println("No courses for "+i.getStudent_name()+" with ID "+i.getStudent_id());
        } else{
            Node j=i.getFirstCourseNode();
            System.out.println(i.getStudent_name()+" with ID "+i.getStudent_id()+" enrolled in courses: ");
            while(j!=null){
                System.out.println(j.getCourse_name()); 
                j=j.getNextDown(); }
          
        }
               break;
           }else {
              found =true;
              
           }
               i=i.next; 
        }
        
        
        if(found){
            System.out.println("not found!");
        }
       }
         public void delete(int ID){

Student i=firststudent; //head
 boolean found=false;
Student j=i.next; //head


while(j!=null){
     if(j.getStudent_id()==ID){
     found =false;
     if(j.student_id==ID){
         System.out.println(j.getStudent_name()+" with ID "+j.getStudent_id()+" is removed"); 
         i.next=j.next;
         j.next=null;
         
     }
    
 }
else {
     found =true;
}
 j=j.next;
     i=i.next;
 }
 if(found==true){
  System.out.println("not found!");}

 }}