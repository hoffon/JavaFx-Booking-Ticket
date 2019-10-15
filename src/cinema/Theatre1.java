package cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.IOException;
import java.util.ArrayList;

public class Theatre1 extends Cinema {
    @FXML Button backtofirst ,booking;
    @FXML CheckBox c0,c1,c2,c3,c4,c5,c6,b0,b1,b2,b3,b4,b5,b6 ;
    @FXML ImageView chairc0,chairc1,chairc2,chairc3,chairc4,chairc5,chairc6,
    chairb0,chairb1,chaircb2,chairb3,chairb4,chairb5,chairb6 ;

    ArrayList<Chair> chairs  ;
    Chair chairC0,chairC1,chairC2,chairC3,chairC4,chairC5,chairC6 ;

    @FXML  public void initialize(){
        chairC0 = new Chair(c0,chairc0);
        chairC1 = new Chair(c1,chairc1);
        chairC2 = new Chair(c2,chairc2);
        chairC3 = new Chair(c3,chairc3);
        chairC4 = new Chair(c4,chairc4);
        chairC5 = new Chair(c5,chairc5);
        chairC6 = new Chair(c6,chairc6);
        chairs = new ArrayList<>() ;
        chairs.add(chairC0) ;
        chairs.add(chairC1) ;
        chairs.add(chairC2) ;
        chairs.add(chairC3) ;
        chairs.add(chairC4) ;
        chairs.add(chairC5) ;
        chairs.add(chairC6) ;
//        checkBoxes.add(c0);
//        checkBoxes.add(c1);
//        checkBoxes.add(c2);
//        checkBoxes.add(c3);
//        checkBoxes.add(c4);
//        checkBoxes.add(c5);
//        checkBoxes.add(c6);
//        checkBoxes.add(b0);
//        checkBoxes.add(b1);
//        checkBoxes.add(b2);
//        checkBoxes.add(b3);
//        checkBoxes.add(b4);
//        checkBoxes.add(b5);
//        checkBoxes.add(b6);
    }


    @Override
    public void backToFirstPage(ActionEvent event) throws IOException {
        super.backToFirstPage(event);
    }
//    public void deleteCheckbox(ActionEvent event){
//        for(CheckBox box : checkBoxes){
//            if(box.isSelected())
//        }
//
//    }
//
//    public void xxx(CheckBox chair){
//        if(chair.isSelected()){ chair00.setImage(new Image("image/chairselect.png"));
//            chair.setDisable(true);
//        }
//    }
    public void bookingChair(){
        for (Chair chair : chairs){
            if (chair.getBox().isSelected()){
                chair.getBox().setDisable(true);
                chair.getImage().setImage(new Image("image/chairselect.png"));
            }
        }
    }



}
