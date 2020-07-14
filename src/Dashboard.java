import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Dashboard extends LoginRegistration {
    ArrayList<Events> bookedEvents = new ArrayList<Events>();

    //    public void Dashboard(ArrayList<Student> students, int count){
    public void Dashboard(){
        JFrame DashboardFrame = new JFrame("Dashboard");

//        JLabel greetingLabel = new JLabel("Welcome, " + students.get(count).studentName + "!");// greet user with his name
        JLabel greetingLabel = new JLabel("Welcome, " + "!");// greet user with his name
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
        viewEvents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Events events = new Events();

                // set online event
                Events onlineEvent = new Events();
                onlineEvent.setBookableSeatLimitedOnlineEvent(1, "Virtual Hackathon", "Virtual Hackathon 2020", "https://www.hackathon.com", "11AM-8PM", "July 26, 2020", 50, 1);

                // set excursion event
                Events excursionEvent = new Events();
                excursionEvent.setSeatLimitedExcursionEvent(2,"Ideathon", "Ideathon 2020","Xperts Media", "Ramhiti, Kathmandu", "11AM-4PM", "July 26, 2020", 11, 2);

                // set internal event
                Events internalEvent = new Events();
                internalEvent.setInternalEvent(3, "Github Workshop", "Workshop on github 2020", "Harvard University", "California",505, "11AM-5PM", "July 26, 2020", 3);

                // add events to array
                events.events.add(onlineEvent);
                events.events.add(excursionEvent);
                events.events.add(internalEvent);

                EventsFrame(events.events);
            }
        });

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
//                LoginRegistration login = new LoginRegistration();
//                login.currentStudent = students;
//                login.LoginForm();
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

    // events frame
    public void EventsFrame(ArrayList<Events> events){
        JFrame eventsFrame = new JFrame("Events");

        int count = 0;
        while(events.size() > count){
            // event title
            JLabel eventTitleLabel = new JLabel(events.get(count).eventTitle);

            int yBoundTitle;

            if(count == 0){
                yBoundTitle = count * 50 + 40;
            }
//            else if(events.size()-1 == count){
//                yBoundTitle = (events.size() - 1) * 50 + 80;
//            }
            else{
                yBoundTitle = count * 50 + 80;
            }

            eventTitleLabel.setBounds(20, yBoundTitle, 105, 50);

            // adding components to the frame
            eventsFrame.add(eventTitleLabel);
            ++count;
        }
        // frame components
        eventsFrame.setSize(350,380);//width and height
        eventsFrame.setLayout(null);//using no layout managers
        eventsFrame.setVisible(true);//making the frame visible
        eventsFrame.setLocationRelativeTo(null);//make the JFrame appear to center of screen
        eventsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//close frame on close
    }
}
