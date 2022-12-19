package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class userLoginController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnBuyProduct;

    @FXML
    void menampilkanHomePage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/homeInput.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void menampilkanPagePenjualan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/penjualan.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnBuyProduct.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}