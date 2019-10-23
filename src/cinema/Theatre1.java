package cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.*;
import java.util.*;

public class Theatre1 implements backToFirstPage {
    @FXML Button backtofirst ,booking,cancelBookingButton;
    @FXML CheckBox c0,c1,c2,c3,c4,c5,c6,b0,b1,b2,b3,b4,b5,b6,a0,a1,a2,a3,a4,a5,a6 ;
    @FXML ImageView chairc0,chairc1,chairc2,chairc3,chairc4,chairc5,chairc6,
    chairb0,chairb1,chairb2,chairb3,chairb4,chairb5,chairb6,
            chaira0,chaira1,chaira2,chaira3,chaira4,chaira5,chaira6;
    @FXML Label usernameLabel,movieName,theatreName,timeshowLabel;

    private int sumPrice = 0  ;

    ArrayList<NormalChair> chairs  ;
    ArrayList<String> chairsSelected,checkBoxes,chairUser,user ;
    HashMap<String,ArrayList<String>> checkUserBooking ;
    NormalChair chairC0,chairC1,chairC2,chairC3,chairC4,chairC5,chairC6,
            chairB0,chairB1,chairB2,chairB3,chairB4,chairB5,chairB6,
    chairA0,chairA1,chairA2,chairA3,chairA4,chairA5,chairA6;

     private MyFile fileBookingTheatre1  ;


    @FXML  public void initialize(){
        String fs = File.separator;
        fileBookingTheatre1 = new MyFile(System.getProperty("user.dir")+ fs +"bookingchair" + fs + "chairselectedtheatre1" , "chairbookingtheatre1.txt");
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
        chairA0 = new NormalChair(a0,chaira0,100);
        chairA1 = new NormalChair(a1,chaira1,100);
        chairA2 = new NormalChair(a2,chaira2,100);
        chairA3 = new NormalChair(a3,chaira3,100);
        chairA4 = new NormalChair(a4,chaira4,100);
        chairA5 = new NormalChair(a5,chaira5,100);
        chairA6 = new NormalChair(a6,chaira6,100);
        chairs = new ArrayList<>() ;
        chairsSelected = new ArrayList<>();
        checkBoxes = new ArrayList<>();
        checkUserBooking = new HashMap<>();
        chairUser = new ArrayList<>();
        user = new ArrayList<>() ;
        chairs.add(chairC0) ;
        chairs.add(chairC1) ;
        chairs.add(chairC2) ;
        chairs.add(chairC3) ;
        chairs.add(chairC4) ;
        chairs.add(chairC5) ;
        chairs.add(chairC6) ;
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
        readFile();
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
                    chair.setBookingName(usernameLabel.getText());
                    String text = usernameLabel.getText()+","+movieName.getText()+","+timeshowLabel.getText()+
                            ","+theatreName.getText()+","+chair.getBox().getId() ;
                    fileBookingTheatre1.appendWithNewLine(text);
                }
            }
            fileBookingTheatre1.save();
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
    public void cancelBooking(){
        readFileToCancelBooking();
        if (checkUserBooking.containsKey(usernameLabel.getText())) {
            if (!checkUserBooking.get(usernameLabel.getText()).isEmpty()) {
                List<String> choices = new ArrayList<>();
                Collections.sort(checkUserBooking.get(usernameLabel.getText()));
                for (String choice : checkUserBooking.get(usernameLabel.getText()))
                    if(!choices.contains(choice)) choices.add(choice);

                ChoiceDialog<String> dialog = new ChoiceDialog<>(checkUserBooking.get(usernameLabel.getText()).get(0), choices);
                dialog.setTitle("Cancel Booking");
                dialog.setHeaderText("Choose the chair you will cancel.");
                dialog.setContentText("Choose your chair:");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){
                    checkUserBooking.get(usernameLabel.getText()).remove(result.get());
                    chairsSelected.remove(result.get());
                    for (Chair chair : chairs) {
                        if (chair.getBox().getId().equals(result.get())) {
                            chair.getBox().setDisable(false);
                            chair.setStatusBooking(false);
                            chair.setBookingName("-");
                            chair.getImage().setImage(new Image("image/chair.png"));
                        }
                    }
                    writeFileAfterCancelBooking();
                }

            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("ไม่พบประวัติการจอง");
            alert.showAndWait();
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
    public void readFile(){
        try {
            File file = new File(fileBookingTheatre1.getDirectory());
            if (!file.exists()) file.mkdirs();
            FileReader fileReader = new FileReader(fileBookingTheatre1.getFilename());
            BufferedReader buffer = new BufferedReader(fileReader);
            String line ;
            while ((line = buffer.readLine()) != null) {
                String[] data = line.split(",");
                String chairBox = data[4].trim();
                String username = data[0].trim();
                chairsSelected.add(chairBox);
                if(!user.contains(username)) user.add(username);
                for (Chair chair : chairs) {
                    if (chair.getBox().getId().equals(chairBox) ) {
                        chair.getBox().setDisable(true);
                        chair.setBookingName(username);
                        chair.getImage().setImage(new Image("image/chairselected.png"));
                    }
                }
            }

        }
        catch (FileNotFoundException e){
            System.err.println("Cannot read file "+fileBookingTheatre1.getFilename());
        }
        catch (IOException e){
            System.err.println("Error reading from file");
        }
    }
    public void readFileToCancelBooking(){
        try {
            File file = new File(fileBookingTheatre1.getDirectory());
            if (!file.exists()) file.mkdirs();
            FileReader fileReader = new FileReader(fileBookingTheatre1.getFilename());
            BufferedReader buffer = new BufferedReader(fileReader);
            String line ;
            while ((line = buffer.readLine()) != null) {
                String[] data = line.split(",");
                String chairBox = data[4].trim();
                String username = data[0].trim();
                if (username.equals(usernameLabel.getText()))
                    if(!chairUser.contains(chairBox)) chairUser.add(chairBox);
                if(!checkUserBooking.containsKey(username) && usernameLabel.getText().equals(username)){
                    checkUserBooking.put(username,chairUser);
                }
            }
        }
        catch (FileNotFoundException e){
            System.err.println("Cannot read file "+fileBookingTheatre1.getFilename());
        }
        catch (IOException e){
            System.err.println("Error reading from file");
        }
    }
    public void writeFileAfterCancelBooking(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileBookingTheatre1.getFilename());
            PrintWriter out = new PrintWriter(fileWriter);
            for (Chair chair : chairs) {
                if (chair.getBox().isDisable() && chair.getBookingName().equals(usernameLabel.getText())) {
                    chair.getBox().setDisable(true);
                    chair.setStatusBooking(true);
                    chair.getImage().setImage(new Image("image/chairselected.png"));
                    String line = usernameLabel.getText()+","+movieName.getText()+","+timeshowLabel.getText()+
                            ","+theatreName.getText()+","+chair.getBox().getId() ;
                    out.println(line);
                }
                else if(chair.getBox().isDisable() && !chair.getBookingName().equals(usernameLabel.getText())
                && user.contains(chair.getBookingName())){
                    chair.getBox().setDisable(true);
                    chair.setStatusBooking(true);
                    chair.getImage().setImage(new Image("image/chairselected.png"));
                    String line = chair.getBookingName()+","+movieName.getText()+","+timeshowLabel.getText()+
                            ","+theatreName.getText()+","+chair.getBox().getId() ;
                    out.println(line);
                }
            }
            out.flush();
        }
        catch (IOException e){
            System.err.println("Error reading from user");
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
    public void setTimeshowLabel(String timeshow){
       timeshowLabel.setText(timeshow);
    }
}