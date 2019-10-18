package cinema;

import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;

public class NormalChair extends Chair {

    private int normalChairPrice ;

    public NormalChair(CheckBox box, ImageView image) {
        super(box, image);
        this.normalChairPrice = 50 ;
    }

    public NormalChair(CheckBox box, ImageView image, int price) {
        super(box, image);
        this.normalChairPrice = price ;
    }

    public int getNormalChairPrice() {
        return normalChairPrice;
    }

    public void setNormalChairPrice(int normalChairPrice) {
        this.normalChairPrice = normalChairPrice;
    }
}
