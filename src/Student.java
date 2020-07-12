public class Student extends Events {
//    Attributes for students
    String studentName;
    int studentID;
    boolean isEventOrganiser = false;
    int[] bookedEvents;
    protected String userName;
    protected String password;

//    getter and setters
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public boolean isEventOrganiser() {
        return isEventOrganiser;
    }

    public void setEventOrganiser(boolean eventOrganiser) {
        isEventOrganiser = eventOrganiser;
    }

    public int[] getBookedEvents() {
        return bookedEvents;
    }

    public void setBookedEvents(int[] bookedEvents) {
        this.bookedEvents = bookedEvents;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
