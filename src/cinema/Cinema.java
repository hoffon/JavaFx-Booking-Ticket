package cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Cinema {

    @FXML
    Button booktheatre1,booktheatre2,booktheatre3,booktheatre4,
            gototrailer1,gototrailer2,gototrailer3,gototrailer4 ;
    @FXML Label usernameLabel,usernameLabel1,usernameLabel2;


    @FXML public void bookingTheatre1(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair1.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
        Theatre1 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());
        s.show();
    }
    @FXML public void bookingTheatre2(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair2.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
        Theatre2 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());
        s.show();
    }
    @FXML public void bookingTheatre3(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair3.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
        Theatre3 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());
        s.show();
    }
    @FXML public void bookingTheatre4(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair4.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
        Theatre4 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());
        s.show();
    }
    @FXML public void bookingTheatre5(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair5.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
//        Theatre5 userName = loader.getController();
//        userName.setUsername(usernameLabel.getText());
        s.show();
    }
    @FXML public void bookingTheatre6(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair6.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
//        Theatre6 userName = loader.getController();
//        userName.setUsername(usernameLabel.getText());
        s.show();
    }
    public void clickGoToTrailer1(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("trailer1.fxml"));
        s.setScene(new Scene(loader.load(),600,400));
        Trailer1 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());
        s.show();
    }
    public void clickGoToTrailer2(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("trailer2.fxml"));
        s.setScene(new Scene(loader.load(),600,400));
        Trailer2 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());
        s.show();
    }
    public void clickGoToTrailer3(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("trailer3.fxml"));
        s.setScene(new Scene(loader.load(),600,400));
        Trailer3 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());
        s.show();
    }
    public void clickGoToTrailer4(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("trailer4.fxml"));
        s.setScene(new Scene(loader.load(),600,400));
        Trailer4 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());
        s.show();
    }
    public void setUsername(String username){
        usernameLabel.setText(username);
        usernameLabel1.setText(username);
        usernameLabel2.setText(username);
    }
}
