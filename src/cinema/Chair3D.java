package cinema;

import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;

public class Chair3D extends Chair {

    private int chair3DPrice ;

    public Chair3D(CheckBox box, ImageView image) {
        super(box, image);
        this.chair3DPrice = 150 ;
    }

    public Chair3D(CheckBox box, ImageView image, int price) {
        super(box, image);
        this.chair3DPrice = price ;
    }

    public int getChair3DPrice() {
        return chair3DPrice;
    }

    public void setChair3DPrice(int chair3DPrice) {
        this.chair3DPrice = chair3DPrice;
    }
}
