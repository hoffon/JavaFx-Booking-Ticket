package cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Theatre1 extends Cinema{
    @FXML
    Button backtofirst ;
    @FXML
    ImageView chair0 ;

    @Override
    public void backToFirstPage(ActionEvent event) throws IOException {
        super.backToFirstPage(event);
    }
}
