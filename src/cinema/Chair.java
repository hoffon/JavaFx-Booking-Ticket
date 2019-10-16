package cinema;

import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Chair {
    private CheckBox box ;
    private int price ;
    private ImageView image ;
    private boolean statusBooking ;

    public Chair(CheckBox box ,ImageView image){
        this.box =  box ;
        this.price = 50 ;
        this.image = image ;
        this.statusBooking = false ;
    }
    public Chair(CheckBox box ,ImageView image,int price){
        this.box =  box ;
        this.price = price ;
        this.image = image ;
        this.statusBooking = false ;
    }

    public CheckBox getBox() {
        return box;
    }

    public void setBox(CheckBox box) {
        this.box = box;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
}

