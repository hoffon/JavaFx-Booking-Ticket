package cinema;

import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Chair {
    private CheckBox box ;
    private ImageView image ;
    private boolean statusBooking ;
    private String bookingName ;

    public Chair(CheckBox box ,ImageView image){
        this.box =  box ;
        this.image = image ;
        this.statusBooking = false ;
        this.bookingName = "-" ;
    }
    public CheckBox getBox() {
        return box;
    }

    public void setBox(CheckBox box) {
        this.box = box;
    }

    public ImageView getImage() {
        return image;
    }

    public boolean isStatusBooking() {
        return statusBooking;
    }

    public void setStatusBooking(boolean statusBooking) {
        this.statusBooking = statusBooking;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }
}

