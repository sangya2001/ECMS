import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Dashboard extends LoginRegistration {
    public void Dashboard(ArrayList<Student> students, int count){
//    public void Dashboard(){
        JFrame DashboardFrame = new JFrame("Dashboard");

        JLabel greetingLabel = new JLabel("Welcome, " + students.get(count).studentName + "!");// greet user with his name
//        JLabel greetingLabel = new JLabel("Welcome, " + "!");// greet user with his name
        greetingLabel.setBounds(20, 10, 300, 40);

        JButton viewEvents, myBookedEvents, logout;

        // view event button
        viewEvents = new JButton("VIEW ALL EVENTS");
        viewEvents.setBounds(20, 50, 280, 40);
        viewEvents.setBackground(Color.gray);
        viewEvents.setOpaque(true);
        viewEvents.setBorderPainted(false);
        viewEvents.setForeground(Color.WHITE);
        viewEvents.setFocusPainted(false);

        // view my booked events
        myBookedEvents = new JButton("BOOKED EVENTS");
        myBookedEvents.setBounds(20, 100, 280, 40);
        myBookedEvents.setBackground(Color.gray);
        myBookedEvents.setOpaque(true);
        myBookedEvents.setBorderPainted(false);
        myBookedEvents.setForeground(Color.WHITE);
        myBookedEvents.setFocusPainted(false);

        // logout button
        logout = new JButton("Logout");
        logout.setBounds(-5, 140, 100, 30);
        logout.setOpaque(false);
        logout.setFocusPainted(false);
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        logout.setForeground(Color.BLUE);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardFrame.dispose();
                LoginRegistration login = new LoginRegistration();
                login.currentStudent = students;
                login.LoginForm();
            }
        });

        // adding components to frame
        DashboardFrame.add(greetingLabel);
        DashboardFrame.add(viewEvents);
        DashboardFrame.add(myBookedEvents);
        DashboardFrame.add(logout);

        // frame components
        DashboardFrame.setSize(340,220);//width and height
        DashboardFrame.setLayout(null);//using no layout managers
        DashboardFrame.setVisible(true);//making the frame visible
        DashboardFrame.setLocationRelativeTo(null);//make the JFrame appear to center of screen
        DashboardFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//close the program on close
    }
}
