package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import db.BarangModel;
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
import project_uap.Barang;

public class inputBarangController implements Initializable{
    BarangModel barang = new BarangModel();
    ObservableList<String> kategoriList = FXCollections.observableArrayList("Barang", "Makanan");

    @FXML
    private Button btnBack;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btn_InputAdd;

    @FXML
    private ComboBox<String> dropdownKategori;

    @FXML
    private TextField fieldBarcode;

    @FXML
    private TextField fieldDiskon;

    @FXML
    private TextField fieldExp;

    @FXML
    private TextField fieldHarga;

    @FXML
    private TextField fieldJumlah;

    @FXML
    private TextField fieldKategori;

    @FXML
    private TextField fieldNama;

    @FXML
    void addData(ActionEvent event) throws IOException {
        Barang brg = new Barang(fieldNama.getText(),Double.parseDouble(fieldHarga.getText()), Integer.parseInt(fieldJumlah.getText()), Double.parseDouble(fieldDiskon.getText()), fieldBarcode.getText(), fieldExp.getText(), fieldKategori.getText());
        barang.addBarang(brg);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/inputBarang.fxml"));
        Parent root = loader.load();
                    
        Stage stage = (Stage) btn_InputAdd.getScene().getWindow();
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
    void cancelData(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/inputProdukBarang.fxml"));
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
            
            if (selected.equals("Makanan")) {
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

