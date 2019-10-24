package cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;

public class LoginPage {
    @FXML Button loginButton , registerButton ;
    @FXML TextField usernametextfield,passwordtextfield ;

    private MyFile fileAccount ;
    private HashMap<String , String > check = new HashMap<>();

    @FXML  public void initialize() {
        String fs = File.separator;
        fileAccount = new MyFile(System.getProperty("user.dir") + fs + "user" , "account.txt");
        try {
            File file = new File(fileAccount.getDirectory());
            if (!file.exists()) file.mkdirs();
            FileReader fileReader = new FileReader(fileAccount.getFilename());
            BufferedReader buffer = new BufferedReader(fileReader);
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] data = line.split(",");
                String username = data[3].trim();
                String password = data[4].trim();
                check.put(username,password);
            }
        }
        catch (FileNotFoundException e){
            System.err.println("Cannot read file "+fileAccount.getFilename());
        }
        catch (IOException e){
            System.err.println("Error reading from file");
        }
    }

    @FXML public void goToMockupMoviePage (ActionEvent event)throws IOException{
        if (check.containsKey(usernametextfield.getText())){
            if (check.get(usernametextfield.getText()).equals(passwordtextfield.getText())){
                Button b = (Button) event.getSource() ;
                Stage s = (Stage) b.getScene().getWindow() ;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("mockupmovie.fxml"));
                s.setScene(new Scene(loader.load(),600,573));
                Cinema userName = loader.getController();
                userName.setUsername(usernametextfield.getText());
                s.show();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Wrong Password");
                alert.setHeaderText("รหัสผ่านไม่ถูกต้อง");
                alert.setContentText("โปรดกรอก password ใหม่อีกครั้ง");
                alert.showAndWait();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("This username cannot be found.");
            alert.setHeaderText("ไม่มี username นี้ในระบบ");
            alert.setContentText("โปรดกรอก username ใหม่อีกครั้ง");
            alert.showAndWait();
        }

    }

    @FXML public void goToRegisterPage(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterPage.fxml"));
        s.setScene(new Scene(loader.load(),600,400));
        s.show();
    }

}
