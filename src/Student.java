import java.util.ArrayList;

public class Student{
//    Attributes for students
    String studentName;
    int studentID;
    boolean isEventOrganiser = false;
    int[] bookedEvents;
    protected String userName;
    protected String password;
    ArrayList<Student> students = new ArrayList<Student>();

    //    set new student
public void setNewStudent(String studentName, int studentID, boolean isEventOrganiser, int[] bookedEvents, String userName, String password){
    this.studentName = studentName;
    this.studentID = studentID;
    this.userName = userName;
    this.password = password;
    this.isEventOrganiser = isEventOrganiser;
    this.bookedEvents = bookedEvents;
}
}
