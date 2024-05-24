package sparsetable2.newpackage;

import sparsetable2.newpackage.Courses;
import sparsetable2.newpackage.Students;
import sparsetable2.newpackage.Courses.Course;
import sparsetable2.newpackage.Students.Student;

public class Node {
    
     int student_id;
    String course_name;
    String student_name;
    Node nextRight;
    Node nextDown;
//    Course firstcourse;
    
    //constructor
    public Node(String student_name,int student_id,String course_name){
        this.student_name=student_name;
        this.student_id=student_id;
        this.course_name=course_name;
    }

    public Node(String coursename, String studentname, int studentid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Node getNextRight() {
        return nextRight;
    }

    public void setNextRight(Node nextRight) {
        this.nextRight = nextRight;
    }

    public Node getNextDown() {
        return nextDown;
    }

    public void setNextDown(Node nextDown) {
        this.nextDown = nextDown;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getStudent_name() {
        return student_name;
    }
    
}