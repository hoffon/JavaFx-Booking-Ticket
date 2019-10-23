package cinema;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Trailer2 extends Application implements Initializable,backToFirstPage {

    @FXML Button playButton,pauseButton,backToFirstPage ;
    @FXML MediaView vdo ;
    @FXML Label usernameLabel ;

    MediaPlayer mediaPlayer ;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String services = getHostServices().getDocumentBase() ;
        Media media = new Media(services + "/src/vdo/trailer2.mp4");
        mediaPlayer = new MediaPlayer(media);
        vdo.setMediaPlayer(mediaPlayer);
    }

    @FXML public void clickPlay(){
        mediaPlayer.play();
    }
    @FXML public void clickStop(){
        mediaPlayer.pause();
    }
    public void setUsername(String username){
        usernameLabel.setText(username);
    }

    @Override
    public void backToFirstPage(ActionEvent event) throws IOException {
        mediaPlayer.stop();
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mockupmovie.fxml"));
        s.setScene(new Scene(loader.load(),600,573));
        Cinema userName = loader.getController();
        userName.setUsername(usernameLabel.getText());
        s.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
