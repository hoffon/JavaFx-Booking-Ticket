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
    Button booktheatre1,booktheatre2,booktheatre3,booktheatre4 ;

    @FXML public void bookingTheatre1(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair1.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
        s.show();
    }
    @FXML public void bookingTheatre2(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair2.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
        s.show();
    }
    @FXML public void bookingTheatre3(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair3.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
        s.show();
    }
    @FXML public void bookingTheatre4(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair4.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
        s.show();
    }
    @FXML public void bookingTheatre5(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair5.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
        s.show();
    }
    @FXML public void bookingTheatre6(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair6.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
        s.show();
    }
    @FXML public void backToFirstPage(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mockupmovie.fxml"));
        s.setScene(new Scene(loader.load(),600,658));
        s.show();
    }
}
