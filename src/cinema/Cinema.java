package cinema;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Cinema implements Initializable {

    @FXML
    Button booktheatre1,booktheatre2,booktheatre3,booktheatre4,
            gototrailer1,gototrailer2,gototrailer3,gototrailer4;
    @FXML Label usernameLabel,usernameLabel1,usernameLabel2;
    @FXML TableView<csvFileforTableView> csvTableView ;
    @FXML TableColumn <csvFileforTableView,String> usernameColumn , movienameColumn, timeshowColumn,
            theatreColumn,chairColumn;


    private String fs = File.separator;
    private MyFile csvFile = new MyFile(System.getProperty("user.dir")+ fs +"bookingchair"  , "BookingData.csv");
    private MyFile fileBookingTheatre1 = new MyFile(System.getProperty("user.dir")+ fs +"bookingchair" + fs + "chairselectedtheatre1" , "chairbookingtheatre1.txt");
    private MyFile fileBookingTheatre2 = new MyFile(System.getProperty("user.dir")+ fs +"bookingchair" + fs + "chairselectedtheatre2" , "chairbookingtheatre2.txt");
    private MyFile fileBookingTheatre3 = new MyFile(System.getProperty("user.dir")+ fs +"bookingchair" + fs + "chairselectedtheatre3" , "chairbookingtheatre3.txt");
    private MyFile fileBookingTheatre4 = new MyFile(System.getProperty("user.dir")+ fs +"bookingchair" + fs + "chairselectedtheatre4" , "chairbookingtheatre4.txt");
    private MyFile fileBookingTheatre5 = new MyFile(System.getProperty("user.dir")+ fs +"bookingchair" + fs + "chairselectedtheatre5" , "chairbookingtheatre5.txt");
    private MyFile fileBookingTheatre6 = new MyFile(System.getProperty("user.dir")+ fs +"bookingchair" + fs + "chairselectedtheatre6" , "chairbookingtheatre6.txt");


    @Override
    public void initialize(URL location, ResourceBundle resources) {// method เริ่มต้น เมื่อเปิดโปรแกรมขึ้นมาจะทำการ set tableView โดยใช้ Booking.csv
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("Username"));
        movienameColumn.setCellValueFactory(new PropertyValueFactory<>("Moviename"));
        timeshowColumn.setCellValueFactory(new PropertyValueFactory<>("Time"));
        theatreColumn.setCellValueFactory(new PropertyValueFactory<>("Theatre"));
        chairColumn.setCellValueFactory(new PropertyValueFactory<>("Booking"));
        csvTableView.setItems(getCsvText());
    }
    @FXML public void bookingTheatre1(ActionEvent event)throws IOException {//go to chair1.fxml จองหนังในโรงที่ 1
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair1.fxml"));
        s.setScene(new Scene(loader.load(),600,550));// set Scene size
        Theatre1 userName = loader.getController();
        Theatre1 timeshow = loader.getController();
        userName.setUsername(usernameLabel.getText());//send username to Theatre 1
        timeshow.setTimeshowLabel(booktheatre1.getText());// send timeshow of movie to Theatre 1
        s.show();
    }
    @FXML public void bookingTheatre2(ActionEvent event)throws IOException {//go to chair2.fxml จองหนังในโรงที่ 2
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair2.fxml"));
        s.setScene(new Scene(loader.load(),600,550));// set Scene size
        Theatre2 userName = loader.getController();
        Theatre2 timeshow = loader.getController();
        userName.setUsername(usernameLabel.getText());  //send username to Theatre 2
        timeshow.setTimeshowLabel(booktheatre2.getText()); // send timeshow of movie to Theatre 2
        s.show();
    }
    @FXML public void bookingTheatre3(ActionEvent event)throws IOException {//go to chair3.fxml จองหนังในโรงที่ 3
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair3.fxml"));
        s.setScene(new Scene(loader.load(),600,550));// set Scene size
        Theatre3 userName = loader.getController();
        Theatre3 timeshow = loader.getController();
        userName.setUsername(usernameLabel.getText());//send username to Theatre 3
        timeshow.setTimeshowLabel(booktheatre3.getText());// send timeshow of movie to Theatre 3
        s.show();
    }
    @FXML public void bookingTheatre4(ActionEvent event)throws IOException {//go to chair4.fxml จองหนังในโรงที่ 4
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair4.fxml"));
        s.setScene(new Scene(loader.load(),600,550));// set Scene size
        Theatre4 userName = loader.getController();
        Theatre4 timeshow = loader.getController();
        userName.setUsername(usernameLabel.getText());//send username to Theatre 3
        timeshow.setTimeshowLabel(booktheatre4.getText());// send timeshow of movie to Theatre 4
        s.show();
    }
    @FXML public void bookingTheatre5(ActionEvent event)throws IOException {//go to chair5.fxml จองหนังในโรงที่ 5
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair5.fxml"));
        s.setScene(new Scene(loader.load(),600,550));// set Scene size
        Theatre5 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());
        s.show();
    }
    @FXML public void bookingTheatre6(ActionEvent event)throws IOException {//go to chair6.fxml จองหนังในโรงที่ 6
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair6.fxml"));
        s.setScene(new Scene(loader.load(),600,550));// set Scene size
        Theatre6 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());
        s.show();
    }
    public void clickGoToTrailer1(ActionEvent event) throws IOException {//go to trailer1.fxml ดูตัวอย่างหนังของหนังโรงที่ 1
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("trailer1.fxml"));
        s.setScene(new Scene(loader.load(),600,400));// set Scene size
        Trailer1 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());//send username to Trailer 1
        s.show();
    }
    public void clickGoToTrailer2(ActionEvent event) throws IOException {//go to trailer2.fxml ดูตัวอย่างหนังของหนังโรงที่ 2
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("trailer2.fxml"));
        s.setScene(new Scene(loader.load(),600,400)); // set Scene size
        Trailer2 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());//send username to Trailer 2
        s.show();
    }
    public void clickGoToTrailer3(ActionEvent event) throws IOException {//go to trailer3.fxml ดูตัวอย่างหนังของหนังโรงที่ 3
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("trailer3.fxml"));
        s.setScene(new Scene(loader.load(),600,400)); // set Scene size
        Trailer3 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());//send username to Trailer 3
        s.show();
    }
    public void clickGoToTrailer4(ActionEvent event) throws IOException {//go to trailer4.fxml ดูตัวอย่างหนังของหนังโรงที่ 4
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("trailer4.fxml"));
        s.setScene(new Scene(loader.load(),600,400)); // set Scene size
        Trailer4 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());//send username to Trailer 4
        s.show();
    }
    public void clickGoToTrailer5(ActionEvent event) throws IOException {//go to trailer4.fxml ดูตัวอย่างหนังของหนังโรงที่ 5
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("trailer5.fxml"));
        s.setScene(new Scene(loader.load(),600,400)); // set Scene size
        Trailer5 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());//send username to Trailer 5
        s.show();
    }
    public void clickGoToTrailer6(ActionEvent event) throws IOException {//go to trailer4.fxml ดูตัวอย่างหนังของหนังโรงที่ 6
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("trailer6.fxml"));
        s.setScene(new Scene(loader.load(),600,400)); // set Scene size
        Trailer6 userName = loader.getController();
        userName.setUsername(usernameLabel.getText());//send username to Trailer 6
        s.show();
    }

    public void setUsername(String username){//set username
        usernameLabel.setText(username);
    }
    public void btnupdateCsvTable() throws IOException { // save BookingData.csv after user booking or cancel bookingchair
        ArrayList<BufferedReader> buff = new ArrayList<>();// and setTableView at CSV tab to show text in BookingData.csv

            FileWriter fileWriter = new FileWriter(csvFile.getFilename());
            PrintWriter out = new PrintWriter(fileWriter);

            FileReader fileReader1 = new FileReader(fileBookingTheatre1.getFilename());
            BufferedReader buffer1 = new BufferedReader(fileReader1);
            FileReader fileReader2 = new FileReader(fileBookingTheatre2.getFilename());
            BufferedReader buffer2 = new BufferedReader(fileReader2);
            FileReader fileReader3 = new FileReader(fileBookingTheatre3.getFilename());
            BufferedReader buffer3 = new BufferedReader(fileReader3);
            FileReader fileReader4 = new FileReader(fileBookingTheatre4.getFilename());
            BufferedReader buffer4 = new BufferedReader(fileReader4);
            FileReader fileReader5 = new FileReader(fileBookingTheatre5.getFilename());
            BufferedReader buffer5 = new BufferedReader(fileReader5);
            FileReader fileReader6 = new FileReader(fileBookingTheatre6.getFilename());
            BufferedReader buffer6 = new BufferedReader(fileReader6);
            buff.add(buffer1);
            buff.add(buffer2);
            buff.add(buffer3);
            buff.add(buffer4);
            buff.add(buffer5);
            buff.add(buffer6);

            String line ;
        for (BufferedReader bufferedReader : buff) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                String username = data[0].trim();
                String movieName = data[1].trim();
                String timeshow = data[2].trim();
                String theatre = data[3].trim();
                String chairBox = data[4].trim();

                String text = username + "," + movieName + "," + timeshow +
                        "," + theatre + "," + chairBox;
                out.println(text);
            }
        }
            out.flush(); // เขียน bookingData.csv ใหม่
        csvTableView.refresh();//ลบข้อมูลใน TableView
        csvTableView.setItems(getCsvText());// เขียนข้อมูลใน TableView ใหม่
        }
    private ObservableList<csvFileforTableView> getCsvText(){ //สร้าง list เพื่อเก็บ text ใน BookingData.csv
        ObservableList<csvFileforTableView> csvFileforTableViews = FXCollections.observableArrayList();
        try {

            FileReader fileReader = new FileReader(csvFile.getFilename());
            BufferedReader buffer = new BufferedReader(fileReader);
            String line ;
            while ((line = buffer.readLine()) != null) {
                String[] data = line.split(",");
                String username = data[0].trim();
                String moviename = data[1].trim();
                String time = data[2].trim();
                String theatre = data[3].trim();
                String chair = data[4].trim();
                csvFileforTableView text = new csvFileforTableView(username, moviename, time,theatre,chair);
                csvFileforTableViews.add(text);
            }
        }
        catch (FileNotFoundException e){
            System.err.println("Cannot read file "+csvFile.getFilename());
        }
        catch (IOException e){
            System.err.println("Error reading from file");
        }
        return csvFileforTableViews ;
    }
}
