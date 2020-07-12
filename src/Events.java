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
    String organiserID;
    boolean isBookable;

//    getter and setter
    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public boolean isOnlineEvent() {
        return isOnlineEvent;
    }

    public void setOnlineEvent(boolean onlineEvent) {
        isOnlineEvent = onlineEvent;
    }

    public String getEventURL() {
        return eventURL;
    }

    public void setEventURL(String eventURL) {
        this.eventURL = eventURL;
    }

    public boolean isExcursionEvent() {
        return isExcursionEvent;
    }

    public void setExcursionEvent(boolean excursionEvent) {
        isExcursionEvent = excursionEvent;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getOrganisationLocation() {
        return organisationLocation;
    }

    public void setOrganisationLocation(String organisationLocation) {
        this.organisationLocation = organisationLocation;
    }

    public boolean isInternalEvent() {
        return isInternalEvent;
    }

    public void setInternalEvent(boolean internalEvent) {
        isInternalEvent = internalEvent;
    }

    public String getCampusLocation() {
        return campusLocation;
    }

    public void setCampusLocation(String campusLocation) {
        this.campusLocation = campusLocation;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public int getCampusRoomNumber() {
        return campusRoomNumber;
    }

    public void setCampusRoomNumber(int campusRoomNumber) {
        this.campusRoomNumber = campusRoomNumber;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public boolean isSeatLimited() {
        return isSeatLimited;
    }

    public void setSeatLimited(boolean seatLimited) {
        isSeatLimited = seatLimited;
    }

    public int getLimitedSeats() {
        return limitedSeats;
    }

    public void setLimitedSeats(int limitedSeats) {
        this.limitedSeats = limitedSeats;
    }

    public String getOrganiserID() {
        return organiserID;
    }

    public void setOrganiserID(String organiserID) {
        this.organiserID = organiserID;
    }

    public boolean isBookable() {
        return isBookable;
    }

    public void setBookable(boolean bookable) {
        isBookable = bookable;
    }
}
