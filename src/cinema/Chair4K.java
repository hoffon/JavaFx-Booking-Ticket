package cinema;

import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;

public class Chair4K extends Chair {

    private int chair4KPrice ;

    public Chair4K(CheckBox box, ImageView image) {
        super(box, image);
        this.chair4KPrice = 200 ;
    }
    public Chair4K(CheckBox box, ImageView image,int chair4KPrice) {
        super(box, image);
        this.chair4KPrice = chair4KPrice ;
    }

    public int getChair4KPrice() {
        return chair4KPrice;
    }

    public void setChair4KPrice(int chair4KPrice) {
        this.chair4KPrice = chair4KPrice;
    }
}
