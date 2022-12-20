package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static db.DBHelper.getConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private TextField fieldUsername;

    @FXML
    private Label lblMassage;

    @FXML
    void backToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/homeInput.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void goToLogin(ActionEvent event) throws IOException {
        if(fieldUsername.getText().isBlank() == false && fieldPassword.getText().isBlank() == false){
            // lblMassage.setText("You try to login!");
            validLogin();
        }else{
            lblMassage.setText("Please enter username and password.");
        }

    }

    public void validLogin(){
        Connection CONN = getConnection();
        Statement st;
        ResultSet rs; 

        String query = "SELECT count(1) FROM login WHERE username = '" +
                        fieldUsername.getText() + "' AND password = " +
                        fieldPassword.getText() + ";";

        try {
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                if(rs.getInt(1) == 1){
                    // lblMassage.setText("Welcome!");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/adminLogin.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }else{
                    lblMassage.setText("Invalid Login. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
