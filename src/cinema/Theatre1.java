package cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;


import java.io.IOException;

public class Theatre1 extends Cinema{
    @FXML
    Button backtofirst ;


    @Override
    public void backToFirstPage(ActionEvent event) throws IOException {
        super.backToFirstPage(event);
    }

}
