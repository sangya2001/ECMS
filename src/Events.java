import java.util.ArrayList;

public class Events {
    //  Attributes for event
    int eventID;
    String eventTitle;
    String eventDescription;
    boolean isOnlineEvent;
    String eventURL;
    boolean isExcursionEvent;
    String organisationName;
    String organisationLocation;
    boolean isInternalEvent;
    String campusLocation;
    String campusName;
    int campusRoomNumber;
    String eventTime;
    String eventDate;
    boolean isSeatLimited;
    int limitedSeats;
    int organiserID;
    boolean isBookable;
    ArrayList<Events> events = new ArrayList<Events>();

    // Online event, needs booking for event, limited seats
    public void setBookableSeatLimitedOnlineEvent(int eventID, String eventTitle, String eventDescription, String eventURL, String eventTime, String eventDate, int limitedSeats, int organiserID){
        this.eventID = eventID;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventURL = eventURL;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        this.limitedSeats = limitedSeats;
        this.organiserID = organiserID;
        this.isOnlineEvent = true;
        this.isSeatLimited = true;
        this.isBookable = true;
    }

    // excursion event & limited seats & needs booking for event
    public void setSeatLimitedExcursionEvent(int eventID, String eventTitle, String eventDescription, String organisationName, String organisationLocation, String eventTime, String eventDate, int limitedSeats, int organiserID){
        this.eventID = eventID;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        this.limitedSeats = limitedSeats;
        this.organiserID = organiserID;
        this.isSeatLimited = true;
        this.isBookable = true;
        this.isExcursionEvent = true;
        this.organisationName = organisationName;
        this.organisationLocation = organisationLocation;
    }

    // internal event
    public void setInternalEvent(int eventID, String eventTitle, String eventDescription, String campusName, String campusLocation, int campusRoomNumber, String eventTime, String eventDate, int organiserID){
        this.eventID = eventID;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        this.organiserID = organiserID;
        this.isInternalEvent = true;
        this.campusName = campusName;
        this.campusLocation = campusLocation;
        this.campusRoomNumber = campusRoomNumber;
    }
}
