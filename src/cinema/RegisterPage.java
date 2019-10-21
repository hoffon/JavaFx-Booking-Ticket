package cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;


public class RegisterPage {
    @FXML Button backToLogin,createAccountButton,checkButton ;
    @FXML TextField firstnametextfield,lastnametextfield,usernametextfield,emailtextfield,passwordtextfield;

    private MyFile fileAccount ;
    private ArrayList<String> check = new ArrayList<>() ;

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
                String firstname = data[0].trim();
                String lastname = data[1].trim();
                String email = data[2].trim();
                String username = data[3].trim();
                String password = data[4].trim();
                check.add(username);
            }
        }
            catch (FileNotFoundException e){
                System.err.println("Cannot read file "+fileAccount.getFilename());
            }
        catch (IOException e){
                System.err.println("Error reading from file");
            }
    }
    @ FXML public void createAccount()  {
        String textFirstname = firstnametextfield.getText();
        String textLastname = lastnametextfield.getText();
        String textEmail = emailtextfield.getText();
        String textUsername = usernametextfield.getText();
        String textPassword = passwordtextfield.getText();
        fileAccount.append(textFirstname);
        fileAccount.append(",");
        fileAccount.append(textLastname);
        fileAccount.append(",");
        fileAccount.append(textEmail);
        fileAccount.append(",");
        fileAccount.append(textUsername);
        fileAccount.append(",");
        fileAccount.appendWithNewLine(textPassword);
        fileAccount.save();
    }
    @FXML public void checkUsername(ActionEvent event) throws IOException {

                if (check.contains(usernametextfield.getText())){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Change Your Username");
                    alert.setContentText("Ooops,Your username already exists.");
                    alert.showAndWait();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Username");
                    alert.setHeaderText("Create This Account ");
                    alert.setContentText("Username : " + usernametextfield.getText()
                            + "\nPassword : " + passwordtextfield.getText());

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        createAccount();
                        backToLogin(event);
                  }
                }
        }


    @FXML public void backToLogin (ActionEvent event) throws IOException {
        Button b = (Button) event.getSource() ;
        Stage s = (Stage) b.getScene().getWindow() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        s.setScene(new Scene(loader.load(),600,400));
        s.show();
    }
}
