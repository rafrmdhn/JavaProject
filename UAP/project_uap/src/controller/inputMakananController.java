package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import db.MakananModel;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project_uap.Makanan;

public class inputMakananController implements Initializable{
    MakananModel makanan = new MakananModel();
    ObservableList<String> kategoriList = FXCollections.observableArrayList("Barang", "Makanan");

    @FXML
    private Button btnBack;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox<String> dropdownKategori;

    @FXML
    private TextField fieldDiskon;

    @FXML
    private TextField fieldDt;

    @FXML
    private TextField fieldHarga;

    @FXML
    private TextField fieldId;

    @FXML
    private TextField fieldJumlah;

    @FXML
    private TextField fieldNama;

    @FXML
    void addData(ActionEvent event) throws IOException {
        Makanan makan = new Makanan(fieldNama.getText(),Double.parseDouble(fieldHarga.getText()), Integer.parseInt(fieldJumlah.getText()), Double.parseDouble(fieldDiskon.getText()), Integer.parseInt(fieldId.getText()), Integer.parseInt(fieldDt.getText()));
        makanan.addMakanan(makan);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/inputMakanan.fxml"));
        Parent root = loader.load();
                    
        Stage stage = (Stage) btnAdd.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void backToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/adminLogin.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void cancelInput(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/inputProdukMakanan.fxml"));
        Parent root = loader.load();
                    
        Stage stage = (Stage) btnCancel.getScene().getWindow();
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
            }
        });
    }

}

