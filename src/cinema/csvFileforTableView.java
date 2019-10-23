package cinema;

import javafx.beans.property.SimpleStringProperty;

public class csvFileforTableView {
    private SimpleStringProperty username ;
    private SimpleStringProperty moviename;
    private SimpleStringProperty time ;
    private SimpleStringProperty theatre ;
    private SimpleStringProperty booking ;

    public csvFileforTableView(String username, String moviename, String time, String theatre, String booking) {
        this.username = new SimpleStringProperty(username);
        this.moviename = new SimpleStringProperty(moviename);
        this.time = new SimpleStringProperty(time);
        this.theatre = new SimpleStringProperty(theatre);
        this.booking= new SimpleStringProperty(booking);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getMoviename() {
        return moviename.get();
    }

    public SimpleStringProperty movienameProperty() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename.set(moviename);
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getTheatre() {
        return theatre.get();
    }

    public SimpleStringProperty theatreProperty() {
        return theatre;
    }

    public void setTheatre(String theatre) {
        this.theatre.set(theatre);
    }

    public String getBooking() {
        return booking.get();
    }

    public SimpleStringProperty bookingProperty() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking.set(booking);
    }
}
