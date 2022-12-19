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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import project_uap.Barang;

public class penjualanBarangController implements Initializable {
    BarangModel barang = new BarangModel();
    ObservableList<String> kategoriList = FXCollections.observableArrayList("Barang", "Makanan");

    @FXML
    private Button btnBack;

    @FXML
    private Button btnBuy;

    @FXML
    private ComboBox<String> dropdownKategori;

    @FXML
    private TextField fieldBarcode;

    @FXML
    private TableColumn<Barang, String> tblExp;

    @FXML
    private TableColumn<Barang, Double> tblHargaBarangPenjualan;

    @FXML
    private TableColumn<Barang, Integer> tblJumlah;

    @FXML
    private TableColumn<Barang, String> tblNamaBarangPenjualan;

    @FXML
    private TableView<Barang> tblBarangPenjualan;

    @FXML
    private TableColumn<Barang, String> tblBarcode;

    @FXML
    private TableColumn<Barang, Double> tblDiskon;

    @FXML
    private TableColumn<Barang, String> tblKategori;

    @FXML
    void backToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/userLogin.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void beliBarang(ActionEvent event) throws IOException {
        Barang brg = new Barang(fieldBarcode.getText());
        barang.deleteBarang(brg);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/PenjualanBarang.fxml"));
        Parent root = loader.load();
                    
        Stage stage = (Stage) btnBuy.getScene().getWindow();
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
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/penjualanMakanan.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) dropdownKategori.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        showBarangPenjualan();
    }

    public ObservableList<Barang> getProdukList(){
        ObservableList<Barang> kategoriList = FXCollections.observableArrayList();
        Connection CONN = getConnection();
        String query = "SELECT * FROM Barang";
        Statement st;
        ResultSet rs; 
        
        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            Barang barang;
            while(rs.next()){
                barang = new Barang(rs.getString("nama_produk"),rs.getDouble("harga"), rs.getInt("jumlah"), rs.getDouble("diskon"), rs.getString("barcode"), rs.getString("expired"), rs.getString("kategori"));
                kategoriList.add(barang);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return kategoriList;
    }

    public void showBarangPenjualan(){
        ObservableList<Barang> list = getProdukList();
        tblBarcode.setCellValueFactory(new PropertyValueFactory<Barang ,String>("barcode"));
        tblNamaBarangPenjualan.setCellValueFactory(new PropertyValueFactory<Barang ,String>("nama_produk"));
        tblHargaBarangPenjualan.setCellValueFactory(new PropertyValueFactory<Barang ,Double>("harga"));
        tblJumlah.setCellValueFactory(new PropertyValueFactory<Barang ,Integer>("jumlah"));
        tblExp.setCellValueFactory(new PropertyValueFactory<Barang ,String>("expired"));
        tblDiskon.setCellValueFactory(new PropertyValueFactory<Barang ,Double>("diskon"));
        tblKategori.setCellValueFactory(new PropertyValueFactory<Barang ,String>("kategori"));

        tblBarangPenjualan.setItems(list);
    }
}
