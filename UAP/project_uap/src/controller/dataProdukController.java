package controller;

import static db.DBHelper.getConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import db.ProdukModel;
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
import project_uap.Produk;

public class dataProdukController implements Initializable{
    ProdukModel produk = new ProdukModel();
    ObservableList<String> kategoriList = FXCollections.observableArrayList("Barang", "Makanan");

    @FXML
    private Button btnBack;

    @FXML
    private ComboBox<String> dropdownKategori;

    @FXML
    private Text lblTotalProduk;

    @FXML
    private TableView<Produk> tableAllDataProduk;

    @FXML
    private TableColumn<Produk, Double> tblHargaProduk;

    @FXML
    private TableColumn<Produk, Integer> tblJumlahProduk;

    @FXML
    private TableColumn<Produk, String> tblNamaProduk;

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
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/dataBarang.fxml"));
                        Parent root = loader.load();
                        Stage stage = (Stage) dropdownKategori.getScene().getWindow();
                        stage.setScene(new Scene(root));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (selected.equals("Makanan")) {
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
        showProduk();
        totalProduk();
    }

    public void showProduk(){
        ObservableList<Produk> list = produk.getProduk();
        tblNamaProduk.setCellValueFactory(new PropertyValueFactory<Produk ,String>("nama_produk"));
        tblHargaProduk.setCellValueFactory(new PropertyValueFactory<Produk ,Double>("harga"));
        tblJumlahProduk.setCellValueFactory(new PropertyValueFactory<Produk ,Integer>("jumlah"));
        
        tableAllDataProduk.setItems(list);
    }

    public void totalProduk(){
        int count = 0;
        String query = "SELECT Barang.nama_produk FROM Barang UNION SELECT Makanan.nama_produk FROM Makanan;";
        Connection CONN = getConnection();
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                count++; 
            }
            lblTotalProduk.setText(Integer.toString(count));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
