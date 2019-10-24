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

public class Theatre3 implements backToFirstPage{
    @FXML Button backtofirst ,booking,cancelBookingButton;
    @FXML CheckBox c0,c1,c2,c3,c4,c5,c6,b0,b1,b2,b3,b4,b5,b6,a0,a1,a2,a3,a4,a5,a6 ;
    @FXML ImageView chairc0,chairc1,chairc2,chairc3,chairc4,chairc5,chairc6,
            chairb0,chairb1,chairb2,chairb3,chairb4,chairb5,chairb6,
            chaira0,chaira1,chaira2,chaira3,chaira4,chaira5,chaira6;
    @FXML Label usernameLabel,movieName,theatreName,timeshowLabel ;

    private int sumPrice = 0  ;

    ArrayList<Chair4K> chairs  ; // ArrayList เก็บ เก้าอี้ที่อยู่ในโรงหนังทั้งหมด
    ArrayList<String> chairsSelected,checkBoxes,chairUser,user ;//chairSelected ดูตำแหน่งเก้าอี้ที่ได้ถูกจองไป , checkBoxes เก็บตำแหน่งเก้าอี้ที่ถูกจอง,chairUserเก็บชื่อของผู้ที่จองเก้าอี้,user ดูผู้ที่จองเก้าอี้
    HashMap<String,ArrayList<String>> checkUserBooking ;// Hashmap เก็บดูว่า  user ที่จองเก้าอี้มี ใครบ้างและจองที่ไหนบ้าง
    Chair4K chairC0,chairC1,chairC2,chairC3,chairC4,chairC5,chairC6,// เก้าอี้
            chairB0,chairB1,chairB2,chairB3,chairB4,chairB5,chairB6,
            chairA0,chairA1,chairA2,chairA3,chairA4,chairA5,chairA6;

    private MyFile fileBookingTheatre3  ;

    @FXML  public void initialize() {// method เริ่มต้น เมื่อย้ายมา scene นี้ จะทำการสร้างเก้าอี้ (Object) แล้วเก็บใน ArrayList
        String fs = File.separator;
        fileBookingTheatre3 = new MyFile(System.getProperty("user.dir") + fs + "bookingchair" + fs + "chairselectedtheatre3", "chairbookingtheatre3.txt");
        chairC0 = new Chair4K(c0, chairc0);
        chairC1 = new Chair4K(c1, chairc1);
        chairC2 = new Chair4K(c2, chairc2);
        chairC3 = new Chair4K(c3, chairc3);
        chairC5 = new Chair4K(c5, chairc5);
        chairC4 = new Chair4K(c4, chairc4);//  Chair4K price : 200    //
        chairC6 = new Chair4K(c6, chairc6);//  Chair4K price : 200    //
        chairB0 = new Chair4K(b0, chairb0);
        chairB1 = new Chair4K(b1, chairb1);
        chairB2 = new Chair4K(b2, chairb2);
        chairB3 = new Chair4K(b3, chairb3);
        chairB4 = new Chair4K(b4, chairb4);
        chairB5 = new Chair4K(b5, chairb5);
        chairB6 = new Chair4K(b6, chairb6);
        chairA0 = new Chair4K(a0, chaira0, 400);
        chairA1 = new Chair4K(a1, chaira1, 400);//  Chair4K price : 400    //
        chairA2 = new Chair4K(a2, chaira2, 400);
        chairA3 = new Chair4K(a3, chaira3, 400);
        chairA4 = new Chair4K(a4, chaira4, 400);
        chairA5 = new Chair4K(a5, chaira5, 400);
        chairA6 = new Chair4K(a6, chaira6, 400);
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
    public void backToFirstPage(ActionEvent event) throws IOException {// back to mockupmovie.fxml
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mockupmovie.fxml"));
        s.setScene(new Scene(loader.load(),600,573));//set Scene size
        Cinema userName = loader.getController();
        userName.setUsername(usernameLabel.getText());//send username to Cinema
        s.show();
    }
    public void bookingChair(ActionEvent event) throws IOException {// method จองเก้าอี้
        for (Chair4K chair : chairs){
            if (chair.getBox().isSelected()) {// ถ้าเก้าอี้ที่ checkbox ถูกเลือก
                chairSelectedPrice(chair);// sumPrice (ราคารวม) จะบวกเพิ่ม
                checkBoxes.add(chair.getBox().getId());// ArrayList checkBoxs ทำการเก็บตำแหน่งของเก้าอี้
            }
        }
        Alert td = new Alert(Alert.AlertType.CONFIRMATION);// กล่องแจ้งเตือนเพื่อยืนยันการจอง
        td.setTitle("ยืนยันการจอง");
        td.setContentText("ที่นั่งที่จอง "+checkBoxes+"\nยอดที่ต้องจ่าย " +getSumPrice());// สรุปค่าใช้จ่ายรวมของเก้าอี้ทั้งหมดที่ user ได้เลือกไว้ และ แสดงตำแหน่ง ที่ username ได้เลือกไว้
        td.showAndWait();
        if (td.getResult().getText().equals("OK")) {// ถ้า user กด ตกลง
            for (Chair chair : chairs) {
                if (chair.getBox().isSelected()) {// ดูเก้าอี้ทั้งหมด
                    chair.getBox().setDisable(true);// ถ้าเก้าอี้ถูกจอง checkbox จะถูก disable ไม่ให้ทำการจองได้
                    chair.setStatusBooking(true);// ตั้งค่าให้เก้าอี้มีสถานะการจองเป็น false
                    chair.setBookingName(usernameLabel.getText());// ตั้งค่าให้เก้าอี้ที่ถูกจองมีชื่อของผู้จองเป็น username ที่ได้จองเก้าอี้ตัวนี้
                    String text = usernameLabel.getText()+","+movieName.getText()+","+timeshowLabel.getText()+
                            ","+theatreName.getText()+","+chair.getBox().getId() ;
                    fileBookingTheatre3.appendWithNewLine(text);// เขียนลงในไฟล์ fileBookingTheatre1
                }
            }
            fileBookingTheatre3.save();// save fileBookingTheatre3
            Button b = (Button) event.getSource() ;
            Stage s = (Stage) b.getScene().getWindow() ;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mockupmovie.fxml"));
            s.setScene(new Scene(loader.load(),600,573));// set Scene size
            Cinema userName = loader.getController();
            userName.setUsername(usernameLabel.getText());//send username to Cinema
            s.show();
        }
        else if (td.getResult().getText().equals("Cancel")) {// ถ้า  user กด ยกเลิก
            setSumPrice(0);// set sumPrice (ราคารวม) มีค่า 0
            checkBoxes.clear();// delete all chair.isSelected in ArrayList
        }
    }
    public void cancelBooking(){// method ยกเลิกการจองเก้าอี้
        readFileToCancelBooking();
        if (checkUserBooking.containsKey(usernameLabel.getText())) {//ถ้า checkuserBooking มี key ตรงกับ username ที่ login เข้ามา
            if (!checkUserBooking.get(usernameLabel.getText()).isEmpty()) {// ถ้าusername ที่login เข้ามาได้เคยจองเก้าอี้ไว้แล้ว
                List<String> choices = new ArrayList<>();
                Collections.sort(checkUserBooking.get(usernameLabel.getText()));
                for (String choice : checkUserBooking.get(usernameLabel.getText()))
                     choices.add(choice);// เพิ่มคำตอบของการยกเลิกว่าจะยกเลิกเก้าอี้ที่ตำแหน่งใด

                ChoiceDialog<String> dialog = new ChoiceDialog<>(checkUserBooking.get(usernameLabel.getText()).get(0), choices);
                dialog.setTitle("Cancel Booking");
                dialog.setHeaderText("Choose the chair you will cancel.");
                dialog.setContentText("Choose your chair:");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){//ถ้าเลือกเก้าอี้ที่จะยกเลิก
                    checkUserBooking.get(usernameLabel.getText()).remove(result.get());// username ที่ login จะไม่มีเก้าอี้นั้นในประวัติการจอง
                    chairsSelected.remove(result.get());// ตำแหน่งของเก้าอี้ที่ถูกจองไปจะถูกลบไป 1 เก้าอี้ ตือเก้าอี้ที่username ได้ยกเลิกไป
                    for (Chair4K chair : chairs) {
                        if (chair.getBox().getId().equals(result.get())) {// ถ้าตำแหน่งเก้าอี้ที่ถูกยกเลิกตรงกับตำแหน่งที่ user ยกเลิก
                            chair.getBox().setDisable(false);// checkbox จะใช้การได้ (จองได้)
                            chair.setStatusBooking(false);// set สถานะการจอง false
                            chair.setBookingName("-");// set ชื่อผู้จองเก้าอี้ให้เป็น ไม่มีผู้จอง
                            if(chair.getChair4KPrice() != 400) // ถ้าเก้าอี้มีราคาไม่เท่ากับ 400 set เป็นรูปเก้าอี้ที่จองได้
                            chair.getImage().setImage(new Image("image/chair.png"));
                            else chair.getImage().setImage(new Image("image/vipchair.png"));// ถ้าเก้าอี้มีราคาเท่ากับ 400 set เป็นรูปเก้าอี้ที่จองได้
                        }
                    }
                    writeFileAfterCancelBooking();
                }

            }
        }
        else {// ถ้า username ไม่ได้จองเก้าอี้ไว้เลย
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("ไม่พบประวัติการจอง");
            alert.showAndWait();
        }
    }
    public void mouseClick(){// method กดเลืกเก้าอี้เ
        for (Chair4K chair : chairs){
            if (chairsSelected.contains(chair.getBox().getId()) && chair.getChair4KPrice() != 400 )// ถ้าตำแหน่งเก้าอี้ อยู่ในArrayList และ ถ้าเก้าอี้มีราคาไม่เท่ากับ 400 เก้าอี้จะถูก set Image chairselected
                chair.getImage().setImage(new Image("image/chairselected.png"));
            else if (chair.getBox().isSelected() && chair.getChair4KPrice() != 400){// ถ้าตำแหน่งเก้าอี้ ถูกเลือก   และ ถ้าเก้าอี้มีราคาไม่เท่ากับ 400 เก้าอี้จะถูก set Image chairselect
                chair.getImage().setImage(new Image("image/chairselect.png"));
            }
            else if (chair.getBox().isDisable() && chair.getChair4KPrice() == 400)// ถ้า checkbox ของ เก้าอี้ถูก disable  และ ถ้าเก้าอี้มีราคาท่ากับ 400 เก้าอี้จะถูก set Image vipchairselected
                chair.getImage().setImage(new Image("image/vipchairselected.png"));
            else if (!chair.getBox().isSelected() && chair.getChair4KPrice() == 400)// ถ้า checkbox ของ เก้าอี้ไม่ถูกเลือก  และ ถ้าเก้าอี้มีราคาเท่ากับ 400 เก้าอี้จะถูก set Image vipchair
                chair.getImage().setImage(new Image("image/vipchair.png"));
            else if (chair.getBox().isSelected() && chair.getChair4KPrice() == 400)// ถ้า checkbox ของ เก้าอี้ถูกเลือก  และ ถ้าเก้าอี้มีราคาเท่ากับ 400 เก้าอี้จะถูก set Image vipchair
                chair.getImage().setImage(new Image("image/vipselect.png"));
            else chair.getImage().setImage(new Image("image/chair.png"));
        }
    }
    public void mouseClickVip(){
        for (Chair4K chair : chairs){
            if (chairsSelected.contains(chair.getBox().getId()) && chair.getChair4KPrice() == 400)// ถ้าตำแหน่งเก้าอี้ อยู่ในArrayList และ ถ้าเก้าอี้มีราคาเท่ากับ 400 เก้าอี้จะถูก set Image vipchairselected
                chair.getImage().setImage(new Image("image/vipchairselected.png"));
            else if (chair.getBox().isSelected() && chair.getChair4KPrice() == 400){// ถ้าตำแหน่งเก้าอี้ ถูกเลือก   และ ถ้าเก้าอี้มีราคาเท่ากับ 400 เก้าอี้จะถูก set Image vipselect
                chair.getImage().setImage(new Image("image/vipselect.png"));
            }
            else if (chair.getBox().isDisable() && chair.getChair4KPrice() != 400)// ถ้า checkbox ของ เก้าอี้ถูก disable  และ ถ้าเก้าอี้มีราคาไม่เท่ากับ 400 เก้าอี้จะถูก set Image chairselected
                chair.getImage().setImage(new Image("image/chairselected.png"));
            else if (!chair.getBox().isSelected() && chair.getChair4KPrice() != 400)// ถ้า checkbox ของ เก้าอี้ไม่ถูกเลือก  และ ถ้าเก้าอี้มีราคาไม่เท่ากับ 400 เก้าอี้จะถูก set Image chair
                chair.getImage().setImage(new Image("image/chair.png"));
            else if (chair.getBox().isSelected() && chair.getChair4KPrice() != 400)// ถ้า checkbox ของ เก้าอี้ถูกเลือก  และ ถ้าเก้าอี้มีราคาไม่เท่ากับ 400 เก้าอี้จะถูก set Image chairselect
                chair.getImage().setImage(new Image("image/chairselect.png"));
            else chair.getImage().setImage(new Image("image/vipchair.png"));
        }
    }
    public void readFile(){
        try {
            File file = new File(fileBookingTheatre3.getDirectory());
            if (!file.exists()) file.mkdirs();
            FileReader fileReader = new FileReader(fileBookingTheatre3.getFilename());
            BufferedReader buffer = new BufferedReader(fileReader);
            String line ;
            while ((line = buffer.readLine()) != null) {// อ่านไฟล์ เมื่อไฟล์ยังไม่เจอบรรทัดว่าง
                String[] data = line.split(",");// แยกคำด้วย ,
                String chairBox = data[4].trim();
                String username = data[0].trim();
                chairsSelected.add(chairBox);// ArrayList เก็บ ตำแหน่งเก้าอี้ที่ได้ถูกจองไป
                if(!user.contains(username)) user.add(username);// ถ้า ArrayList user ยังไม่มี username จะทำการเพิ่ม
                for (Chair4K chair : chairs) {
                    if (chairsSelected.contains(chair.getBox().getId())&& chair.getChair4KPrice() != 400) {// ถ้าเก้าอี้มีราคาไม่เท่ากับ 400 และchairselected มีตำแหน่งที่นั่งของเก้าอี้
                        chair.getBox().setDisable(true);// checkbox จะถูก Disable
                        if(chair.getBookingName().equals("-")) chair.setBookingName(username);// set ชื่อผู้จองเก้าอี้ตัวนี้ ถ้าเก้าอี้ไม่มีชื่อผู้จอง
                        chair.getImage().setImage(new Image("image/chairselected.png"));// set รูปให้เก้าอี้ เป็นchairselected คือเก้าอี้ที่ถูกจองแล้ว
                    }
                    else if  (chairsSelected.contains(chair.getBox().getId()) && chair.getChair4KPrice() == 400) {// ถ้าเก้าอี้มีราคา 400 และchairselected มีตำแหน่งที่นั่งของเก้าอี้
                        chair.getBox().setDisable(true);// checkbox จะถูก Disable
                        if(chair.getBookingName().equals("-")) chair.setBookingName(username);// set ชื่อผู้จองเก้าอี้ตัวนี้ ถ้าเก้าอี้ไม่มีชื่อผู้จอง
                        chair.getImage().setImage(new Image("image/vipchairselected.png"));// set รูปให้เก้าอี้ เป็นvipchairselected คือเก้าอี้ที่ถูกจองแล้ว
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.err.println("Cannot read file "+fileBookingTheatre3.getFilename());
        }
        catch (IOException e){
            System.err.println("Error reading from file");
        }
    }
    public void readFileToCancelBooking(){
        try {
            File file = new File(fileBookingTheatre3.getDirectory());
            if (!file.exists()) file.mkdirs();
            FileReader fileReader = new FileReader(fileBookingTheatre3.getFilename());
            BufferedReader buffer = new BufferedReader(fileReader);
            String line ;
            while ((line = buffer.readLine()) != null) {
                String[] data = line.split(",");
                String chairBox = data[4].trim();
                String username = data[0].trim();
                if (username.equals(usernameLabel.getText()))// ถ้า username ในไฟล์ ตรงกับ username ที่ login เข้ามา
                    if(!chairUser.contains(chairBox)) chairUser.add(chairBox);// ถ้า ArrayList chairUser ยังไม่มีตำแหน่งของเก้าอี้ ที่อยู่ในไฟล์ จะทำการเพิ่มเข้าไป
                if(!checkUserBooking.containsKey(username) && usernameLabel.getText().equals(username)){// ถ้า hashmap checkUserBooking ไม่มี key ที่ตรงกับusername ในไฟล์
                    checkUserBooking.put(username,chairUser);                                           // และถ้า username ในไฟล์ ตรงกับ  username ที่ login เข้ามา
                }                                                                                        // hashmap checkUserBooking ทำการput  username,ArrayList chairUser
            }
        }
        catch (FileNotFoundException e){
            System.err.println("Cannot read file "+fileBookingTheatre3.getFilename());
        }
        catch (IOException e){
            System.err.println("Error reading from file");
        }
    }
    public void writeFileAfterCancelBooking(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileBookingTheatre3.getFilename());
            PrintWriter out = new PrintWriter(fileWriter);
            for (Chair4K chair : chairs) {
                if (chair.getBox().isDisable() && chair.getBookingName().equals(usernameLabel.getText())) {//ถ้าเก้าอี้ถูก disable และ ชื่อของผู้จองเก้าอี้ตัวนี้ตรงกับ username ที่login เข้ามา
                    if(chair.getChair4KPrice() != 400 ) { //ถ้า ราคาเก้าอี้ไม่เท่ากับ 400
                        chair.getBox().setDisable(true);// checkbox จะถูก disable และไม่สามารถจองได้
                        chair.setStatusBooking(true);
                        chair.getImage().setImage(new Image("image/chairselected.png"));// set รูปภาพเก้าอี้นี้
                        String line = chair.getBookingName()+","+movieName.getText()+","+timeshowLabel.getText()+
                                ","+theatreName.getText()+","+chair.getBox().getId() ;
                        out.println(line);// เก็บสะสม text ก่อนที่จะเขียนลงไฟล์ใหม่
                    }
                    else{
                        chair.getBox().setDisable(true);// checkbox จะถูก disable และไม่สามารถจองได้
                        chair.setStatusBooking(true);
                        chair.getImage().setImage(new Image("image/vipchairselected.png"));// set รูปภาพเก้าอี้นี้
                        String line = chair.getBookingName()+","+movieName.getText()+","+timeshowLabel.getText()+
                                ","+theatreName.getText()+","+chair.getBox().getId() ;
                        out.println(line);// เก็บสะสม text ก่อนที่จะเขียนลงไฟล์ใหม่
                    }
                }
                else if(chair.getBox().isDisable() && !chair.getBookingName().equals(usernameLabel.getText())
                        && user.contains(chair.getBookingName())){//ถ้าเก้าอี้ถูก disable และ ชื่อของผู้จองเก้าอี้ตัวนี้ไม่ตรงกับ username ที่login เข้ามาและ ชื่อของผู้ที่จองเก้าอี้ตัวนี้อยู่ใน ArraysList  user และ ชื่อของผู้จองเก้าอี้อยู่ใน user
                    if(chair.getChair4KPrice() != 400 ) {//ถ้า ราคาเก้าอี้ไม่เท่ากับ 400
                        chair.getBox().setDisable(true);// checkbox จะถูก disable และไม่สามารถจองได้
                        chair.setStatusBooking(true);
                        chair.getImage().setImage(new Image("image/chairselected.png"));// set รูปภาพเก้าอี้นี้
                        String line = chair.getBookingName()+","+movieName.getText()+","+timeshowLabel.getText()+
                                ","+theatreName.getText()+","+chair.getBox().getId() ;
                        out.println(line);// เก็บสะสม text ก่อนที่จะเขียนลงไฟล์ใหม่
                    }
                    else{
                        chair.getBox().setDisable(true);// checkbox จะถูก disable และไม่สามารถจองได้
                        chair.setStatusBooking(true);
                        chair.getImage().setImage(new Image("image/vipchairselected.png"));// set รูปภาพเก้าอี้นี้
                        String line = chair.getBookingName()+","+movieName.getText()+","+timeshowLabel.getText()+
                                ","+theatreName.getText()+","+chair.getBox().getId() ;
                        out.println(line);// เก็บสะสม text ก่อนที่จะเขียนลงไฟล์ใหม่
                    }
                }
            }
            out.flush();// เขียนไฟล์ใหม่หลัง user ยกเลิกการจองเก้าอี้เสร็จแล้ว
        }
        catch (IOException e){
            System.err.println("Error reading from user");
        }
    }
    public int getSumPrice() {
        return sumPrice;
    }// เรียกผลรวมของราคาเก้าอี้
    public void chairSelectedPrice(Chair4K price){
        sumPrice += price.getChair4KPrice();
    }//เพิ่มราคารวมของเก้าอี้เมื่อผู้ใช้เก้าอี้เพิ่มเข้ามา
    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }// set ราคารวมของเก้าอี้ให้เป็น 0 เมื่อผู้ใช้ต้องการจองเเก้าอี้พิ่ม
    public void setUsername(String username){
        usernameLabel.setText(username);
    }
    public void setTimeshowLabel(String timeshow){
        timeshowLabel.setText(timeshow);
    }
}