package cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Bill implements backToFirstPage {

    @FXML
    Label usernameLabel,movieName,theatreName,timeshowLabel,priceLabel;
    @FXML Button backbutton ;

    public void backToFirstPage(ActionEvent event) throws IOException {// back to mockupmovie.fxml
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mockupmovie.fxml"));
        s.setScene(new Scene(loader.load(),600,573));//set Scene size
        Cinema userName = loader.getController();
        userName.setUsername(usernameLabel.getText());//send username to Cinema
        s.show();
    }
    public void setUsername(String username){
        usernameLabel.setText(username);
    }
    public void setTimeshowLabel(String timeshow){
        timeshowLabel.setText(timeshow);
    }
    public void setMovieNameLabel(String moviename){
        movieName.setText(moviename);
    }
    public void setPriceLabelLabel(String price){
        priceLabel.setText(price);
    }
    public void setTheatreLabel(String theatre){
        theatreName.setText(theatre);
    }

}
