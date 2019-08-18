package cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Cinema {
    @FXML
    Button booktheatre1 ;

    @FXML public void handleSubmitBtnOnAction(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair1.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
        s.show();
    }
}
