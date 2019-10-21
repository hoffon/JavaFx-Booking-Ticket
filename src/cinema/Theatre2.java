package cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Theatre2 implements backToFirstPage{
    @FXML Button backtofirst ,booking;
    @FXML Label usernameLabel ;
    @FXML CheckBox d0,d1,d2,d3,d4,d5,d6,c0,c1,c2,c3,c4,c5,c6,b0,b1,b2,b3,b4,b5,b6,a0,a1,a2,a3,a4,a5,a6 ;
    @FXML ImageView chaird0,chaird1,chaird2,chaird3,chaird4,chaird5,chaird6,
            chairc0,chairc1,chairc2,chairc3,chairc4,chairc5,chairc6,
            chairb0,chairb1,chairb2,chairb3,chairb4,chairb5,chairb6,
            chaira0,chaira1,chaira2,chaira3,chaira4,chaira5,chaira6;

    private int sumPrice = 0  ;

    ArrayList<NormalChair> chairs  ;
    ArrayList<String> chairsSelected,checkBoxes ;
    NormalChair chairD0,chairD1,chairD2,chairD3,chairD4,chairD5,chairD6,
            chairC0,chairC1,chairC2,chairC3,chairC4,chairC5,chairC6,
            chairB0,chairB1,chairB2,chairB3,chairB4,chairB5,chairB6,
            chairA0,chairA1,chairA2,chairA3,chairA4,chairA5,chairA6;

    private MyFile fileBookingTheatre2  ;

    @FXML  public void initialize() {
        String fs = File.separator;
        fileBookingTheatre2 = new MyFile(System.getProperty("user.dir") + fs + "bookingchair" + fs + "chairselectedtheatre2", "chairbookingtheatre2.txt");
        chairD0 = new NormalChair(d0,chaird0);
        chairD1 = new NormalChair(d1,chaird1);
        chairD2 = new NormalChair(d2,chaird2);
        chairD3 = new NormalChair(d3,chaird3);
        chairD4 = new NormalChair(d4,chaird4);
        chairD5 = new NormalChair(d5,chaird5);
        chairD6 = new NormalChair(d6,chaird6);
        chairC0 = new NormalChair(c0,chairc0);
        chairC1 = new NormalChair(c1,chairc1);
        chairC2 = new NormalChair(c2,chairc2);
        chairC3 = new NormalChair(c3,chairc3);
        chairC4 = new NormalChair(c4,chairc4);
        chairC5 = new NormalChair(c5,chairc5);
        chairC6 = new NormalChair(c6,chairc6);
        chairB0 = new NormalChair(b0,chairb0);
        chairB1 = new NormalChair(b1,chairb1);
        chairB2 = new NormalChair(b2,chairb2);
        chairB3 = new NormalChair(b3,chairb3);
        chairB4 = new NormalChair(b4,chairb4);
        chairB5 = new NormalChair(b5,chairb5);
        chairB6 = new NormalChair(b6,chairb6);
        chairA0 = new NormalChair(a0,chaira0,200);
        chairA1 = new NormalChair(a1,chaira1,200);
        chairA2 = new NormalChair(a2,chaira2,200);
        chairA3 = new NormalChair(a3,chaira3,200);
        chairA4 = new NormalChair(a4,chaira4,200);
        chairA5 = new NormalChair(a5,chaira5,200);
        chairA6 = new NormalChair(a6,chaira6,200);
        chairs = new ArrayList<>();
        chairsSelected = new ArrayList<>();
        checkBoxes = new ArrayList<>();
        chairs.add(chairD0);
        chairs.add(chairD1);
        chairs.add(chairD2);
        chairs.add(chairD3);
        chairs.add(chairD4);
        chairs.add(chairD5);
        chairs.add(chairD6);
        chairs.add(chairC0);
        chairs.add(chairC1);
        chairs.add(chairC2);
        chairs.add(chairC3);
        chairs.add(chairC4);
        chairs.add(chairC5);
        chairs.add(chairC6);
        chairs.add(chairB0);
        chairs.add(chairB1);
        chairs.add(chairB2);
        chairs.add(chairB3);
        chairs.add(chairB4);
        chairs.add(chairB5);
        chairs.add(chairB6);
        chairs.add(chairA0);
        chairs.add(chairA1);
        chairs.add(chairA2);
        chairs.add(chairA3);
        chairs.add(chairA4);
        chairs.add(chairA5);
        chairs.add(chairA6);
        readFile() ;
    }

    @Override
    public void backToFirstPage(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mockupmovie.fxml"));
        s.setScene(new Scene(loader.load(),600,573));
        Cinema userName = loader.getController();
        userName.setUsername(usernameLabel.getText());
        s.show();
    }
    public void bookingChair(ActionEvent event) throws IOException {
        for (NormalChair chair : chairs){
            if (chair.getBox().isSelected()) {
                chairSelectedPrice(chair);
                checkBoxes.add(chair.getBox().getId());
            }
        }
        Alert td = new Alert(Alert.AlertType.CONFIRMATION);
        td.setTitle("ยืนยันการจอง");
        td.setContentText("ที่นั่งที่จอง "+checkBoxes+"\nยอดที่ต้องจ่าย " +getSumPrice());
        td.showAndWait();
        if (td.getResult().getText().equals("OK")) {
            for (Chair chair : chairs) {
                if (chair.getBox().isSelected()) {
                    chair.getBox().setDisable(true);
                    chair.setStatusBooking(true);
                    chair.getImage().setImage(new Image("image/chairselected.png"));
                    String text = chair.getBox().getId();
                    fileBookingTheatre2.appendWithNewLine(text);
                    fileBookingTheatre2.save();
                }
            }
            Button b = (Button) event.getSource() ;
            Stage s = (Stage) b.getScene().getWindow() ;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mockupmovie.fxml"));
            s.setScene(new Scene(loader.load(),600,573));
            Cinema userName = loader.getController();
            userName.setUsername(usernameLabel.getText());
            s.show();
        }
        else if (td.getResult().getText().equals("Cancel")) {
            setSumPrice(0);
            checkBoxes.clear();
        }
    }
    public void mouseClick(){
        for (Chair chair : chairs){
            if (chairsSelected.contains(chair.getBox().getId()) )
                chair.getImage().setImage(new Image("image/chairselected.png"));
            else if (chair.getBox().isSelected()){
                chair.getImage().setImage(new Image("image/chairselect.png"));
            }
            else chair.getImage().setImage(new Image("image/chair.png"));
        }
    }
    public int getSumPrice() {
        return sumPrice;
    }
    public void chairSelectedPrice(NormalChair price){
        sumPrice += price.getNormalChairPrice();
    }
    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }
    public void setUsername(String username){
        usernameLabel.setText(username);
    }

    public void readFile(){
        try {
            File file = new File(fileBookingTheatre2.getDirectory());
            if (!file.exists()) file.mkdirs();
            FileReader fileReader = new FileReader(fileBookingTheatre2.getFilename());
            BufferedReader buffer = new BufferedReader(fileReader);
            String line ;
            while ((line = buffer.readLine()) != null) {
                chairsSelected.add(line);
            }
            for (Chair chair : chairs) {
                if (chairsSelected.contains(chair.getBox().getId())) {
                    chair.getBox().setDisable(true);
                    chair.getImage().setImage(new Image("image/chairselected.png"));
                }
            }
        }
        catch (FileNotFoundException e){
            System.err.println("Cannot read file "+fileBookingTheatre2.getFilename());
        }
        catch (IOException e){
            System.err.println("Error reading from file");
        }

    }
}
