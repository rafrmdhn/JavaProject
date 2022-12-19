package controller;

import static db.DBHelper.getConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import project_uap.Produk;

public class penjualanController implements Initializable {
    ObservableList<String> kategoriList = FXCollections.observableArrayList("Barang", "Makanan");

    @FXML
    private Button btnBack;

    @FXML
    private ComboBox<String> dropdownKategori;

    @FXML
    private TableColumn<Produk, Double> tblDiskon;

    @FXML
    private TableColumn<Produk, Integer> tblJumlah;

    @FXML
    private TableColumn<Produk, Double> tblJumlahHargaProdukPenjualan;

    @FXML
    private TableColumn<Produk, String> tblNamaProdukPenjualan;

    @FXML
    private TableView<Produk> tblProdukPenjualan;

    @FXML
    void backToHome(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/userLogin.fxml"));
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
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/penjualanBarang.fxml"));
                        Parent root = loader.load();
                        Stage stage = (Stage) dropdownKategori.getScene().getWindow();
                        stage.setScene(new Scene(root));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (selected.equals("Makanan")) {
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
        showProduk();
    }

    public ObservableList<Produk> getProdukList(){
        ObservableList<Produk> kategoriList = FXCollections.observableArrayList();
        Connection CONN = getConnection();
        String query = "SELECT Makanan.nama_produk, Makanan.jumlah, Makanan.diskon, (Makanan.harga) - (Makanan.harga*Makanan.diskon) AS harga FROM Makanan UNION SELECT Barang.nama_produk, Barang.jumlah, Barang.diskon, (Barang.harga) - (Barang.harga*Barang.diskon) as harga FROM Barang;";
        Statement st;
        ResultSet rs; 
        
        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            Produk produk;
            while(rs.next()){
                produk = new Produk(rs.getString("nama_produk"),rs.getDouble("harga"), rs.getInt("jumlah"), rs.getDouble("diskon"));
                kategoriList.add(produk);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return kategoriList;
    }

    public void showProduk(){
        ObservableList<Produk> list = getProdukList();
        tblNamaProdukPenjualan.setCellValueFactory(new PropertyValueFactory<Produk ,String>("nama_produk"));
        tblJumlah.setCellValueFactory(new PropertyValueFactory<Produk ,Integer>("jumlah"));
        tblDiskon.setCellValueFactory(new PropertyValueFactory<Produk ,Double>("diskon"));
        tblJumlahHargaProdukPenjualan.setCellValueFactory(new PropertyValueFactory<Produk ,Double>("harga"));
        
        tblProdukPenjualan.setItems(list);
    }
}
