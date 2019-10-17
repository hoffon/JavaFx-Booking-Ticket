package cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Trailer3 implements Initializable,backToFirstPage {

    @FXML Button playButton,pauseButton,backToFirstPage ;
    @FXML MediaView vdo ;

    MediaPlayer mediaPlayer ;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String vdoUrl = "file:/C:/Users/Natakit/Desktop/Cinema/src/vdo/trailer3.mp4";
        Media media  = new Media((vdoUrl));
        mediaPlayer = new MediaPlayer(media);
        vdo.setMediaPlayer(mediaPlayer);
    }

    @FXML public void clickPlay(){
        mediaPlayer.play();
    }
    @FXML public void clickStop(){
        mediaPlayer.pause();
    }

    @Override
    public void backToFirstPage(ActionEvent event) throws IOException {
        mediaPlayer.stop();
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mockupmovie.fxml"));
        s.setScene(new Scene(loader.load(),600,600));
        s.show();
    }

}
