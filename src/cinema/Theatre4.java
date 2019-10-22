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

public class Theatre4 implements backToFirstPage{
    @FXML Button backtofirst ,booking,cancelBookingButton;
    @FXML CheckBox c0,c1,c2,c3,c4,c5,c6,b0,b1,b2,b3,b4,b5,b6,a0,a1,a2,a3,a4,a5,a6 ;
    @FXML ImageView chairc0,chairc1,chairc2,chairc3,chairc4,chairc5,chairc6,
            chairb0,chairb1,chairb2,chairb3,chairb4,chairb5,chairb6,
            chaira0,chaira1,chaira2,chaira3,chaira4,chaira5,chaira6;
    @FXML Label usernameLabel ;

    private int sumPrice = 0  ;

    ArrayList<Chair3D> chairs  ;
    ArrayList<String> chairsSelected,checkBoxes,chairUser,user ;
    HashMap<String,ArrayList<String>> checkUserBooking ;
    Chair3D chairC0,chairC1,chairC2,chairC3,chairC4,chairC5,chairC6,
            chairB0,chairB1,chairB2,chairB3,chairB4,chairB5,chairB6,
            chairA0,chairA1,chairA2,chairA3,chairA4,chairA5,chairA6;

    private MyFile fileBookingTheatre4  ;

    @FXML  public void initialize() {
        String fs = File.separator;
        fileBookingTheatre4 = new MyFile(System.getProperty("user.dir") + fs + "bookingchair" + fs + "chairselectedtheatre4", "chairbookingtheatre4.txt");
        chairC0 = new Chair3D(c0, chairc0);
        chairC1 = new Chair3D(c1, chairc1);
        chairC2 = new Chair3D(c2, chairc2);
        chairC3 = new Chair3D(c3, chairc3);
        chairC4 = new Chair3D(c4, chairc4);
        chairC5 = new Chair3D(c5, chairc5);
        chairC6 = new Chair3D(c6, chairc6);
        chairB0 = new Chair3D(b0, chairb0);
        chairB1 = new Chair3D(b1, chairb1);
        chairB2 = new Chair3D(b2, chairb2);
        chairB3 = new Chair3D(b3, chairb3);
        chairB4 = new Chair3D(b4, chairb4);
        chairB5 = new Chair3D(b5, chairb5);
        chairB6 = new Chair3D(b6, chairb6);
        chairA0 = new Chair3D(a0, chaira0, 300);
        chairA1 = new Chair3D(a1, chaira1, 300);
        chairA2 = new Chair3D(a2, chaira2, 300);
        chairA3 = new Chair3D(a3, chaira3, 300);
        chairA4 = new Chair3D(a4, chaira4, 300);
        chairA5 = new Chair3D(a5, chaira5, 300);
        chairA6 = new Chair3D(a6, chaira6, 300);
        chairs = new ArrayList<>();
        chairsSelected = new ArrayList<>();
        checkBoxes = new ArrayList<>();
        checkUserBooking = new HashMap<>();
        chairUser = new ArrayList<>();
        user = new ArrayList<>() ;
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
        for (Chair3D chair : chairs){
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
                    String text = chair.getBox().getId() +","+usernameLabel.getText();
                    fileBookingTheatre4.appendWithNewLine(text);
                }
            }
            fileBookingTheatre4.save();
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
                    choices.add(choice);

                ChoiceDialog<String> dialog = new ChoiceDialog<>(checkUserBooking.get(usernameLabel.getText()).get(0), choices);
                dialog.setTitle("Cancel Booking");
                dialog.setHeaderText("Choose the chair you will cancel.");
                dialog.setContentText("Choose your chair:");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){
                    checkUserBooking.get(usernameLabel.getText()).remove(result.get());
                    for (Chair3D chair : chairs) {
                        if (chair.getBox().getId().equals(result.get())) {
                            chair.getBox().setDisable(false);
                            chair.setStatusBooking(false);
                            chair.setBookingName("-");
                            if(chair.getChair3DPrice() != 300)
                                chair.getImage().setImage(new Image("image/chair.png"));
                            else chair.getImage().setImage(new Image("image/premiumchair.png"));
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
        for (Chair3D chair : chairs){
            if (chairsSelected.contains(chair.getBox().getId()) && chair.getChair3DPrice() != 300 )
                chair.getImage().setImage(new Image("image/chairselected.png"));
            else if (chair.getBox().isSelected() && chair.getChair3DPrice() != 300){
                chair.getImage().setImage(new Image("image/chairselect.png"));
            }
            else if (chair.getBox().isDisable() && chair.getChair3DPrice() == 300)
                chair.getImage().setImage(new Image("image/premiumchairselected.png"));
            else if (!chair.getBox().isSelected() && chair.getChair3DPrice() == 300)
                chair.getImage().setImage(new Image("image/premiumchair.png"));
            else if (chair.getBox().isSelected() && chair.getChair3DPrice() == 300)
                chair.getImage().setImage(new Image("image/premiumchairselect.png"));
            else chair.getImage().setImage(new Image("image/chair.png"));
        }
    }
    public void mouseClickPremium(){
        for (Chair3D chair : chairs){
            if (chairsSelected.contains(chair.getBox().getId()) && chair.getChair3DPrice() == 300)
                chair.getImage().setImage(new Image("image/premiumchairselected.png"));
            else if (chair.getBox().isSelected() && chair.getChair3DPrice() == 300){
                chair.getImage().setImage(new Image("image/premiumchairselect.png"));
            }
            else if (chair.getBox().isDisable() && chair.getChair3DPrice() != 300)
                chair.getImage().setImage(new Image("image/chairselected.png"));
            else if (!chair.getBox().isSelected() && chair.getChair3DPrice() != 300)
                chair.getImage().setImage(new Image("image/chair.png"));
            else if (chair.getBox().isSelected() && chair.getChair3DPrice() != 300)
                chair.getImage().setImage(new Image("image/chairselect.png"));
            else chair.getImage().setImage(new Image("image/premiumchair.png"));
        }
    }
    public void readFile(){
        try {
            File file = new File(fileBookingTheatre4.getDirectory());
            if (!file.exists()) file.mkdirs();
            FileReader fileReader = new FileReader(fileBookingTheatre4.getFilename());
            BufferedReader buffer = new BufferedReader(fileReader);
            String line ;
            while ((line = buffer.readLine()) != null) {
                String[] data = line.split(",");
                String chairBox = data[0].trim();
                String username = data[1].trim();
                chairsSelected.add(chairBox);
                if(!user.contains(username)) user.add(username);
                for (Chair3D chair : chairs) {
                    if (chairsSelected.contains(chair.getBox().getId())&& chair.getChair3DPrice() != 300) {
                        chair.getBox().setDisable(true);
                        if(chair.getBookingName().equals("-")) chair.setBookingName(username);
                        chair.getImage().setImage(new Image("image/chairselected.png"));
                    }
                    else if  (chairsSelected.contains(chair.getBox().getId()) && chair.getChair3DPrice() == 300) {
                        chair.getBox().setDisable(true);
                        if(chair.getBookingName().equals("-")) chair.setBookingName(username);
                        chair.getImage().setImage(new Image("image/premiumchairselected.png"));
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.err.println("Cannot read file "+fileBookingTheatre4.getFilename());
        }
        catch (IOException e){
            System.err.println("Error reading from file");
        }
    }
    public void readFileToCancelBooking(){
        try {
            File file = new File(fileBookingTheatre4.getDirectory());
            if (!file.exists()) file.mkdirs();
            FileReader fileReader = new FileReader(fileBookingTheatre4.getFilename());
            BufferedReader buffer = new BufferedReader(fileReader);
            String line ;
            while ((line = buffer.readLine()) != null) {
                String[] data = line.split(",");
                String chairBox = data[0].trim();
                String username = data[1].trim();
                if (username.equals(usernameLabel.getText()))
                    chairUser.add(chairBox);
                if(!checkUserBooking.containsKey(username) && usernameLabel.getText().equals(username)){
                    checkUserBooking.put(username,chairUser);
                }
            }
        }
        catch (FileNotFoundException e){
            System.err.println("Cannot read file "+fileBookingTheatre4.getFilename());
        }
        catch (IOException e){
            System.err.println("Error reading from file");
        }
    }
    public void writeFileAfterCancelBooking(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileBookingTheatre4.getFilename());
            PrintWriter out = new PrintWriter(fileWriter);
            for (Chair3D chair : chairs) {
                if (chair.getBox().isDisable() && chair.getBookingName().equals(usernameLabel.getText())) {
                    if(chair.getChair3DPrice() != 300 ) {
                        chair.getBox().setDisable(true);
                        chair.setStatusBooking(true);
                        chair.getImage().setImage(new Image("image/chairselected.png"));
                        String line = chair.getBox().getId() + "," + usernameLabel.getText();
                        out.println(line);
                    }
                    else{
                        chair.getBox().setDisable(true);
                        chair.setStatusBooking(true);
                        chair.getImage().setImage(new Image("image/premiumchairselected.png"));
                        String line = chair.getBox().getId() + "," + usernameLabel.getText();
                        out.println(line);
                    }
                }
                else if(chair.getBox().isDisable() && !chair.getBookingName().equals(usernameLabel.getText())
                        && user.contains(chair.getBookingName())){
                    if(chair.getChair3DPrice() != 300 ) {
                        chair.getBox().setDisable(true);
                        chair.setStatusBooking(true);
                        chair.getImage().setImage(new Image("image/chairselected.png"));
                        String line = chair.getBox().getId() +","+chair.getBookingName();
                        out.println(line);
                    }
                    else{
                        chair.getBox().setDisable(true);
                        chair.setStatusBooking(true);
                        chair.getImage().setImage(new Image("image/premiumchairselected.png"));
                        String line = chair.getBox().getId() +","+chair.getBookingName();
                        out.println(line);
                    }
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
    public void chairSelectedPrice(Chair3D price){
        sumPrice += price.getChair3DPrice();
    }
    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }
    public void setUsername(String username){
        usernameLabel.setText(username);
    }
}
