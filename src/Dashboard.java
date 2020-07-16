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
                DashboardFrame.dispose();
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
        myBookedEvents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bookedEvents.size() == 0){
                    errorDialogBox("No Events Booked!");
                    return;
                }
                BookedEventsFrame(bookedEvents);
                DashboardFrame.dispose();
            }
        });

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

    //  this is error box frame
    static void errorDialogBox(String errMsg){
        JFrame errorDialog = new JFrame("Error");

        JLabel messageLabel = new JLabel(errMsg);
        messageLabel.setBounds(20, 20, 300, 40);

        JButton errorButton = new JButton("OK");
        errorButton.setBounds(100, 75, 100, 40);
        errorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorDialog.dispose();
            }
        });
        errorButton.setFocusPainted(false);

        // adding components to frame
        errorDialog.add(messageLabel);
        errorDialog.add(errorButton);

        errorDialog.setSize(320,170);//width and height
        errorDialog.setLayout(null);//using no layout managers
        errorDialog.setVisible(true);//making the frame visible
        errorDialog.setLocationRelativeTo(null);//make the JFrame appear to center of screen
        errorDialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//close frame on close
    }

    // success box frame
    static void successFrame(String successMsg){
        JFrame successDialog = new JFrame("Success");

        JLabel messageLabel = new JLabel(successMsg);
        messageLabel.setBounds(20, 20, 300, 40);

        JButton successButton = new JButton("OK");
        successButton.setBounds(100, 75, 100, 40);
        successButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                successDialog.dispose();
            }
        });
        successButton.setFocusPainted(false);

        // adding components to frame
        successDialog.add(messageLabel);
        successDialog.add(successButton);

        successDialog.setSize(320,170);//width and height
        successDialog.setLayout(null);//using no layout managers
        successDialog.setVisible(true);//making the frame visible
        successDialog.setLocationRelativeTo(null);//make the JFrame appear to center of screen
        successDialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//close frame on close
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
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventsFrame.dispose();
                Dashboard();
            }
        });

        int count = 0;
        while(events.size() > count){
            // event title
            JLabel eventTitleLabel = new JLabel((count+1) + ". " + events.get(count).eventTitle);
            int yBoundTitle;
            switch (count){
                case 0: yBoundTitle = 40; break;
                case 1: yBoundTitle = 240;break;
                case 2: yBoundTitle = 440;break;
                default:
                    throw new IllegalStateException("Unexpected value: " + count);
            }
            eventTitleLabel.setBounds(20, yBoundTitle, 150, 50);

            // event Description
            JLabel eventDescription = new JLabel(events.get(count).eventDescription);
            int yBoundDescription;
            switch (count){
                case 0: yBoundDescription = 60; break;
                case 1: yBoundDescription = 260;break;
                case 2: yBoundDescription = 460;break;
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
                case 1: yBoundEventTime = 320;break;
                case 2: yBoundEventTime = 520;break;
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
                case 1: yBoundEventDate = 320;break;
                case 2: yBoundEventDate = 520;break;
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
                eventType.setBounds(20, 300, 100, 50);
                eventType.setForeground(Color.gray);

                JLabel organisationName = new JLabel(events.get(count).organisationName);
                organisationName.setBounds(20, 360, 150, 50);
                organisationName.setForeground(Color.gray);

                JLabel organisationLocation = new JLabel(", " + events.get(count).organisationLocation);
                organisationLocation.setBounds(95, 360, 150, 50);
                organisationLocation.setForeground(Color.gray);

                eventsFrame.add(eventType);
                eventsFrame.add(organisationName);
                eventsFrame.add(organisationLocation);
            }
            else if(events.get(count).isInternalEvent == true){// if internal event
                JLabel eventType = new JLabel("Internal Event");

                eventType.setBounds(20, 500, 80, 50);
                eventType.setForeground(Color.gray);

                JLabel campusName = new JLabel(events.get(count).campusName);
                campusName.setBounds(20, 540, 150, 50);
                campusName.setForeground(Color.gray);

                JLabel campusLocation = new JLabel(", " + events.get(count).campusName);
                campusLocation.setBounds(125, 540, 150, 50);
                campusLocation.setForeground(Color.gray);

                eventsFrame.add(eventType);
                eventsFrame.add(campusName);
                eventsFrame.add(campusLocation);
            }

            // check if limited seat is available
            if(events.get(count).isSeatLimited){
                JLabel limitedSeat = new JLabel("Limited Seats: " + events.get(count).limitedSeats);
                int yBoundLimitedSeats;
                switch(count){
                    case 0: yBoundLimitedSeats = 160;break;
                    case 1: yBoundLimitedSeats = 340;break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + count);
                }
                limitedSeat.setBounds(20, yBoundLimitedSeats, 200, 50);
                limitedSeat.setForeground(Color.gray);
                eventsFrame.add(limitedSeat);
            }

            // check if booking is required
            if(events.get(count).isBookable){
                JButton bookSeat = new JButton("Book Event");
                int yBoundBookSeat;
                switch (count){
                    case 0: yBoundBookSeat = 210;break;
                    case 1: yBoundBookSeat = 410;break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + count);
                }
                bookSeat.setBounds(20, yBoundBookSeat, 100, 30);
                bookSeat.setBackground(Color.gray);
                bookSeat.setOpaque(true);
                bookSeat.setBorderPainted(false);
                bookSeat.setForeground(Color.WHITE);
                bookSeat.setFocusPainted(false);

                // multiple nesting is not quite possible due to hosting so final Count is used
                int finalCount = count;
                bookSeat.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int loopEvents = 0;
                        while(bookedEvents.size() > loopEvents){
                            // check if event is already booked
                            if(bookedEvents.get(loopEvents).eventID == events.get(finalCount).eventID){
                                errorDialogBox("Event already booked!");
                                return;
                            }
                            ++loopEvents;
                        }
                        bookedEvents.add(events.get(finalCount));
                        successFrame("Event Booked Successfully.");
                    }
                });

                eventsFrame.add(bookSeat);
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
        eventsFrame.setSize(350,650);//width and height
        eventsFrame.setLayout(null);//using no layout managers
        eventsFrame.setVisible(true);//making the frame visible
        eventsFrame.setLocationRelativeTo(null);//make the JFrame appear to center of screen
        eventsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//close frame on close
    }

    // booked events frame
    public void BookedEventsFrame(ArrayList<Events> events){
        JFrame eventsFrame = new JFrame("Booked Events");

        // go back to dashboard
        JButton goBack = new JButton("Go back");
        goBack.setFocusPainted(false);
        goBack.setOpaque(false);
        goBack.setForeground(Color.BLUE);
        goBack.setBounds(3, 15, 80, 30);
        goBack.setContentAreaFilled(false);
        goBack.setBorderPainted(false);
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventsFrame.dispose();
                Dashboard();
            }
        });

        int count = 0;
        while(events.size() > count){
            // event title
            JLabel eventTitleLabel = new JLabel((count+1) + ". " + events.get(count).eventTitle);
            int yBoundTitle;
            switch (count){
                case 0: yBoundTitle = 40; break;
                case 1: yBoundTitle = 240;break;
                default:
                    throw new IllegalStateException("Unexpected value: " + count);
            }
            eventTitleLabel.setBounds(20, yBoundTitle, 150, 50);

            // event Description
            JLabel eventDescription = new JLabel(events.get(count).eventDescription);
            int yBoundDescription;
            switch (count){
                case 0: yBoundDescription = 60; break;
                case 1: yBoundDescription = 260;break;
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
                case 1: yBoundEventTime = 320;break;
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
                case 1: yBoundEventDate = 320;break;
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
                eventType.setBounds(20, 300, 100, 50);
                eventType.setForeground(Color.gray);

                JLabel organisationName = new JLabel(events.get(count).organisationName);
                organisationName.setBounds(20, 360, 150, 50);
                organisationName.setForeground(Color.gray);

                JLabel organisationLocation = new JLabel(", " + events.get(count).organisationLocation);
                organisationLocation.setBounds(95, 360, 150, 50);
                organisationLocation.setForeground(Color.gray);

                eventsFrame.add(eventType);
                eventsFrame.add(organisationName);
                eventsFrame.add(organisationLocation);
            }

            // check if limited seat is available
            if(events.get(count).isSeatLimited){
                JLabel limitedSeat = new JLabel("Limited Seats: " + events.get(count).limitedSeats);
                int yBoundLimitedSeats;
                switch(count){
                    case 0: yBoundLimitedSeats = 160;break;
                    case 1: yBoundLimitedSeats = 340;break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + count);
                }
                limitedSeat.setBounds(20, yBoundLimitedSeats, 200, 50);
                limitedSeat.setForeground(Color.gray);
                eventsFrame.add(limitedSeat);
            }

            // check if booking is required
            if(events.get(count).isBookable){
                JButton cancelBookedSeat = new JButton("Cancel Event");
                int yBoundBookSeat;
                switch (count){
                    case 0: yBoundBookSeat = 210;break;
                    case 1: yBoundBookSeat = 410;break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + count);
                }
                cancelBookedSeat.setBounds(20, yBoundBookSeat, 150, 30);
                cancelBookedSeat.setBackground(Color.gray);
                cancelBookedSeat.setOpaque(true);
                cancelBookedSeat.setBorderPainted(false);
                cancelBookedSeat.setForeground(Color.WHITE);
                cancelBookedSeat.setFocusPainted(false);

                // multiple nesting is not quite possible due to hosting so final Count is used
                int finalCount = count;
                cancelBookedSeat.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        successFrame("Event Cancelled Successfully.");
                    }
                });

                eventsFrame.add(cancelBookedSeat);
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
        eventsFrame.setSize(350,520);//width and height
        eventsFrame.setLayout(null);//using no layout managers
        eventsFrame.setVisible(true);//making the frame visible
        eventsFrame.setLocationRelativeTo(null);//make the JFrame appear to center of screen
        eventsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//close frame on close
    }
}
