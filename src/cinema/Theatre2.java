package cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Theatre2 implements backToFirstPage{
    @FXML Button backtofirst ,booking;
    @FXML CheckBox d0,d1,d2,d3,d4,d5,d6,c0,c1,c2,c3,c4,c5,c6,b0,b1,b2,b3,b4,b5,b6,a0,a1,a2,a3,a4,a5,a6 ;
    @FXML ImageView chaird0,chaird1,chaird2,chaird3,chaird4,chaird5,chaird6,
            chairc0,chairc1,chairc2,chairc3,chairc4,chairc5,chairc6,
            chairb0,chairb1,chairb2,chairb3,chairb4,chairb5,chairb6,
            chaira0,chaira1,chaira2,chaira3,chaira4,chaira5,chaira6;

    private int sumPrice = 0  ;

    ArrayList<Chair4K> chairs  ;
    ArrayList<String> chairsSelected ;
    Chair4K chairC0,chairC1,chairC2,chairC3,chairC4,chairC5,chairC6,
            chairB0,chairB1,chairB2,chairB3,chairB4,chairB5,chairB6,
            chairA0,chairA1,chairA2,chairA3,chairA4,chairA5,chairA6;

    private MyFile fileBookingTheatre4  ;

    @FXML  public void initialize() {
        String fs = File.separator;
        fileBookingTheatre4 = new MyFile(System.getProperty("user.dir") + fs + "bookingchair" + fs + "chairselectedtheatre4", "chairbookingtheatre4.txt");
        chairC0 = new Chair4K(c0, chairc0);
        chairC1 = new Chair4K(c1, chairc1);
        chairC2 = new Chair4K(c2, chairc2);
        chairC3 = new Chair4K(c3, chairc3);
        chairC4 = new Chair4K(c4, chairc4);
        chairC5 = new Chair4K(c5, chairc5);
        chairC6 = new Chair4K(c6, chairc6);
        chairB0 = new Chair4K(b0, chairb0);
        chairB1 = new Chair4K(b1, chairb1);
        chairB2 = new Chair4K(b2, chairb2);
        chairB3 = new Chair4K(b3, chairb3);
        chairB4 = new Chair4K(b4, chairb4);
        chairB5 = new Chair4K(b5, chairb5);
        chairB6 = new Chair4K(b6, chairb6);
        chairA0 = new Chair4K(a0, chaira0, 400);
        chairA1 = new Chair4K(a1, chaira1, 400);
        chairA2 = new Chair4K(a2, chaira2, 400);
        chairA3 = new Chair4K(a3, chaira3, 400);
        chairA4 = new Chair4K(a4, chaira4, 400);
        chairA5 = new Chair4K(a5, chaira5, 400);
        chairA6 = new Chair4K(a6, chaira6, 400);
        chairs = new ArrayList<>();
        chairsSelected = new ArrayList<>();
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
        try {
            File file = new File(fileBookingTheatre4.getDirectory());
            if (!file.exists()) file.mkdirs();
            FileReader fileReader = new FileReader(fileBookingTheatre4.getFilename());
            BufferedReader buffer = new BufferedReader(fileReader);
            String line ;
            while ((line = buffer.readLine()) != null) {
                chairsSelected.add(line);
            }
            for (Chair chair : chairs) {
                if (chairsSelected.contains(String.valueOf(chair.getBox()))) {
                    chair.getBox().setDisable(true);
                    chair.getImage().setImage(new Image("image/chairselected.png"));
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

    @Override
    public void backToFirstPage(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mockupmovie.fxml"));
        s.setScene(new Scene(loader.load(),600,658));
        s.show();
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
}
