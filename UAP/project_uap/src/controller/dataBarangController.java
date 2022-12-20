package controller;

import static db.DBHelper.getConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project_uap.Barang;

public class dataBarangController implements Initializable{
    BarangModel barang = new BarangModel();
    ObservableList<String> kategoriList = FXCollections.observableArrayList("Barang", "Makanan");

    @FXML
    private Button btnBack;

    @FXML
    private ComboBox<String> dropdownKategori;

    @FXML
    private Text lblTotalBarang;

    @FXML
    private TableView<Barang> tableAllDataProduk;

    @FXML
    private TableColumn<Barang, String> tblBarcode;

    @FXML
    private TableColumn<Barang, String> tblExp;

    @FXML
    private TableColumn<Barang, Double> tblHargaProduk;

    @FXML
    private TableColumn<Barang, Integer> tblJumlahProduk;

    @FXML
    private TableColumn<Barang, String> tblKategori;

    @FXML
    private TableColumn<Barang, String> tblNamaProduk;

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
            
            if (selected.equals("Makanan")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/dataMakanan.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) dropdownKategori.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        showBarang();
        totalBarang();
    }

    public void showBarang(){
        ObservableList<Barang> list = barang.getBarang();
        tblBarcode.setCellValueFactory(new PropertyValueFactory<Barang ,String>("barcode"));
        tblNamaProduk.setCellValueFactory(new PropertyValueFactory<Barang ,String>("nama_produk"));
        tblHargaProduk.setCellValueFactory(new PropertyValueFactory<Barang ,Double>("harga"));
        tblJumlahProduk.setCellValueFactory(new PropertyValueFactory<Barang ,Integer>("jumlah"));
        tblExp.setCellValueFactory(new PropertyValueFactory<Barang ,String>("expired"));
        tblKategori.setCellValueFactory(new PropertyValueFactory<Barang ,String>("kategori"));
        
        tableAllDataProduk.setItems(list);
    }

    public void totalBarang(){
        int count = 0;
        String query = "SELECT * FROM Barang";
        Connection CONN = getConnection();
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                count++; 
            }
            lblTotalBarang.setText(Integer.toString(count));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
