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

        // go back to dashboard
        JButton goBack = new JButton("Go back");
        goBack.setFocusPainted(false);
        goBack.setOpaque(false);
        goBack.setForeground(Color.BLUE);
        goBack.setBounds(3, 15, 80, 30);
        goBack.setContentAreaFilled(false);
        goBack.setBorderPainted(false);

        int count = 0;
        while(events.size() > count){
            // event title
            JLabel eventTitleLabel = new JLabel((count+1) + ". " + events.get(count).eventTitle);
            int yBoundTitle;
            switch (count){
                case 0: yBoundTitle = 40; break;
                case 1: yBoundTitle = 200;break;
                case 2: yBoundTitle = 340;break;
                default:
                    throw new IllegalStateException("Unexpected value: " + count);
            }
            eventTitleLabel.setBounds(20, yBoundTitle, 150, 50);

            // event Description
            JLabel eventDescription = new JLabel(events.get(count).eventDescription);
            int yBoundDescription;
            switch (count){
                case 0: yBoundDescription = 60; break;
                case 1: yBoundDescription = 220;break;
                case 2: yBoundDescription = 360;break;
                default:
                    throw new IllegalStateException("Unexpected value: " + count);
            }
            eventDescription.setBounds(20, yBoundDescription, 300, 50);
            eventDescription.setForeground(Color.gray);

            // event time
            JLabel eventTime = new JLabel(events.get(count).eventTime);
            int yBoundEventTime;
            switch(count){
                case 0: yBoundEventTime = 140; break;
                case 1: yBoundEventTime = 300;break;
                case 2: yBoundEventTime = 450;break;
                default:
                    throw new IllegalStateException("Unexpected value: " + count);
            }
            eventTime.setBounds(20, yBoundEventTime, 100, 50);
            eventTime.setForeground(Color.gray);

            // event date
            JLabel eventDate = new JLabel(", " + events.get(count).eventDate);
            int yBoundEventDate;
            switch (count){
                case 0: yBoundEventDate = 140; break;
                case 1: yBoundEventDate = 300;break;
                case 2: yBoundEventDate = 450;break;
                default:
                    throw new IllegalStateException("Unexpected value: " + count);
            }
            eventDate.setBounds(82, yBoundEventDate, 100, 50);
            eventDate.setForeground(Color.gray);

            // event Type
            // if it is online event
            if(events.get(count).isOnlineEvent == true){
                JLabel eventType = new JLabel("Online Event");

                eventType.setBounds(20, 100, 80, 50);
                eventType.setForeground(Color.gray);

                JLabel eventURL = new JLabel(events.get(count).eventURL);
                eventURL.setBounds(20, 120, 250, 50);
                eventURL.setForeground(Color.gray);

                // adding components to frame
                eventsFrame.add(eventType);
                eventsFrame.add(eventURL);
            }
            else if(events.get(count).isExcursionEvent == true){// if external event
                JLabel eventType = new JLabel("External Event");
                eventType.setBounds(20, 260, 100, 50);
                eventType.setForeground(Color.gray);

                eventsFrame.add(eventType);
            }
            else if(events.get(count).isInternalEvent == true){// if internal event
                JLabel eventType = new JLabel("Internal Event");

                eventType.setBounds(20, 400, 80, 50);
                eventType.setForeground(Color.gray);

                eventsFrame.add(eventType);
            }

            // check if limited seat is available
            if(events.get(count).isSeatLimited){
                JLabel limitedSeat = new JLabel("Limited Seats: " + events.get(count).limitedSeats);
                int yBoundLimitedSeats;
                switch(count){
                    case 0: yBoundLimitedSeats = 160;break;
                    case 1: yBoundLimitedSeats = 320;break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + count);
                }
                limitedSeat.setBounds(20, yBoundLimitedSeats, 200, 50);
                limitedSeat.setForeground(Color.gray);
                eventsFrame.add(limitedSeat);
            }

            // adding components to the frame
            eventsFrame.add(eventTitleLabel);
            eventsFrame.add(eventDescription);
            eventsFrame.add(eventTime);
            eventsFrame.add(eventDate);
            ++count;
        }

        eventsFrame.add(goBack);
        // frame components
        eventsFrame.setSize(350,580);//width and height
        eventsFrame.setLayout(null);//using no layout managers
        eventsFrame.setVisible(true);//making the frame visible
        eventsFrame.setLocationRelativeTo(null);//make the JFrame appear to center of screen
        eventsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//close frame on close
    }
}
