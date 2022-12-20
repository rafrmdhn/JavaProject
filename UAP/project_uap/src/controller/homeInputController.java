package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class homeInputController implements Initializable {
    ObservableList<String> pilihList = FXCollections.observableArrayList("Admin", "User");

    @FXML
    private ComboBox<String> boxPilih;

    @FXML
    private Button btnExit;

    @FXML
    void keluarAplikasi(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void pilihLogin(ActionEvent event) {
        boxPilih.getSelectionModel().getSelectedItem().toString();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> pilihList = FXCollections.observableArrayList("Admin", "User");
        boxPilih.setItems(pilihList);
        
        boxPilih.setOnAction(event ->{
                String selected = boxPilih.getSelectionModel().getSelectedItem();
                
                if (selected.equals("Admin")) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/login.fxml"));
                        Parent root = loader.load();
                        Stage stage = (Stage) boxPilih.getScene().getWindow();
                        stage.setScene(new Scene(root));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (selected.equals("User")) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/userLogin.fxml"));
                        Parent root = loader.load();
                        Stage stage = (Stage) boxPilih.getScene().getWindow();
                        stage.setScene(new Scene(root));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } 
        });
    }
}
