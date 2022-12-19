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

public class inputProdukNewController implements Initializable {
    ObservableList<String> kategoriList = FXCollections.observableArrayList("Barang", "Makanan");
    
    @FXML
    private Button btnBack;

    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox<String> dropdownKategori;

        // Barang mhs = new Barang();
        
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("Output.fxml"));
        // Parent root = loader.load();
        
        // OutputController outputController = loader.getController();
        // outputController.showValue(mhs);
        
        // Stage stage = (Stage) btnTambah.getScene().getWindow();
        // stage.setScene(new Scene(root));

    @FXML
    void backToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/adminLogin.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void pilihKategori(ActionEvent event) {
        dropdownKategori.getSelectionModel().getSelectedItem().toString();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)   {
        ObservableList<String> kategoriList = FXCollections.observableArrayList("Barang", "Makanan");
        dropdownKategori.setItems(kategoriList);
        
        dropdownKategori.setOnAction(event ->{
                String selected = dropdownKategori.getSelectionModel().getSelectedItem();
                
                if (selected.equals("Barang")) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/inputBarang.fxml"));
                        Parent root = loader.load();
                        Stage stage = (Stage) dropdownKategori.getScene().getWindow();
                        stage.setScene(new Scene(root));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (selected.equals("Makanan")) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/inputMakanan.fxml"));
                        Parent root = loader.load();
                        Stage stage = (Stage) dropdownKategori.getScene().getWindow();
                        stage.setScene(new Scene(root));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } 
        });
    }
}
