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
            gototrailer1,gototrailer2,gototrailer3,gototrailer4
            ,csv;
    @FXML Label usernameLabel,usernameLabel1,usernameLabel2;
    @FXML TableView<csvFileforTableView> csvTableView ;
    @FXML TableColumn <csvFileforTableView,String> usernameColumn , movienameColumn, timeshowColumn,
            theatreColumn,chairColumn;


    String fs = File.separator;
    private MyFile csvFile = new MyFile(System.getProperty("user.dir")+ fs +"bookingchair"  , "BookingData.csv");
    private MyFile fileBookingTheatre1 = new MyFile(System.getProperty("user.dir")+ fs +"bookingchair" + fs + "chairselectedtheatre1" , "chairbookingtheatre1.txt");
    private MyFile fileBookingTheatre2 = new MyFile(System.getProperty("user.dir")+ fs +"bookingchair" + fs + "chairselectedtheatre2" , "chairbookingtheatre2.txt");
    private MyFile fileBookingTheatre3 = new MyFile(System.getProperty("user.dir")+ fs +"bookingchair" + fs + "chairselectedtheatre3" , "chairbookingtheatre3.txt");
    private MyFile fileBookingTheatre4 = new MyFile(System.getProperty("user.dir")+ fs +"bookingchair" + fs + "chairselectedtheatre4" , "chairbookingtheatre4.txt");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("Username"));
        movienameColumn.setCellValueFactory(new PropertyValueFactory<>("Moviename"));
        timeshowColumn.setCellValueFactory(new PropertyValueFactory<>("Time"));
        theatreColumn.setCellValueFactory(new PropertyValueFactory<>("Theatre"));
        chairColumn.setCellValueFactory(new PropertyValueFactory<>("Booking"));
        csvTableView.setItems(getCsvText());
    }
    @FXML public void bookingTheatre1(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair1.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
        Theatre1 userName = loader.getController();
        Theatre1 timeshow = loader.getController();
        userName.setUsername(usernameLabel.getText());
        timeshow.setTimeshowLabel(booktheatre1.getText());
        s.show();
    }
    @FXML public void bookingTheatre2(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair2.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
        Theatre2 userName = loader.getController();
        Theatre2 timeshow = loader.getController();
        userName.setUsername(usernameLabel.getText());
        timeshow.setTimeshowLabel(booktheatre2.getText());
        s.show();
    }
    @FXML public void bookingTheatre3(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair3.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
        Theatre3 userName = loader.getController();
        Theatre3 timeshow = loader.getController();
        userName.setUsername(usernameLabel.getText());
        timeshow.setTimeshowLabel(booktheatre3.getText());
        s.show();
    }
    @FXML public void bookingTheatre4(ActionEvent event)throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chair4.fxml"));
        s.setScene(new Scene(loader.load(),600,550));
        Theatre4 userName = loader.getController();
        Theatre4 timeshow = loader.getController();
        userName.setUsername(usernameLabel.getText());
        timeshow.setTimeshowLabel(booktheatre4.getText());
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
    }public void setUsername(String username){
        usernameLabel.setText(username);
        usernameLabel1.setText(username);
        usernameLabel2.setText(username);
    }
    public void saveCsv() throws IOException {
        ArrayList<BufferedReader> buff = new ArrayList<>();

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
            buff.add(buffer1);
            buff.add(buffer2);
            buff.add(buffer3);
            buff.add(buffer4);

            String line ;
            for(int i = 0 ; i < buff.size();i++){
                while ((line = buff.get(i).readLine()) != null){
                    String[] data = line.split(",");
                    String username = data[0].trim();
                    String movieName = data[1].trim();
                    String timeshow = data[2].trim();
                    String theatre = data[3].trim();
                    String chairBox = data[4].trim();

                    String text = username+","+movieName+","+timeshow+
                            ","+theatre+","+chairBox ;
                    out.println(text);
                }
            }
            out.flush();
        }
    public ObservableList<csvFileforTableView> getCsvText(){
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
    public void btnupdateCsvTable(){
        csvTableView.refresh();
        csvTableView.setItems(getCsvText());
    }


}
