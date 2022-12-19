package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class adminLoginController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnInputProduk;

    @FXML
    private Button btnViewData;

    @FXML
    void menampilkanHomePage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/homeInput.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void menampilkanPageAllDataProduk(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/dataProduk.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void menampilkanPageInputProduk(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/inputProdukNew.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnInputProduk.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
