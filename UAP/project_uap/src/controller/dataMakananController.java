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
import project_uap.Makanan;

public class dataMakananController implements Initializable{
    ObservableList<String> kategoriList = FXCollections.observableArrayList("Barang", "Makanan");

    @FXML
    private Button btnBack;

    @FXML
    private ComboBox<String> dropdownKategori;

    @FXML
    private TableView<Makanan> tableAllDataProduk;

    @FXML
    private TableColumn<Makanan, Double> tblHargaProduk;

    @FXML
    private TableColumn<Makanan, Integer> tblIdProduk;

    @FXML
    private TableColumn<Makanan, Integer> tblJumlahProduk;

    @FXML
    private TableColumn<Makanan, String> tblNamaProduk;

    @FXML
    private TableColumn<Makanan, Integer> tblDt;

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
            }
        });
        showMakanan();
    }

    public ObservableList<Makanan> getProdukList(){
        ObservableList<Makanan> kategoriList = FXCollections.observableArrayList();
        Connection CONN = getConnection();
        String query = "SELECT * FROM Makanan";
        Statement st;
        ResultSet rs; 
        
        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            Makanan makanan;
            while(rs.next()){
                makanan = new Makanan(rs.getString("nama_produk"),rs.getDouble("harga"), rs.getInt("jumlah"), rs.getDouble("diskon"), rs.getInt("id"), rs.getInt("daya_tahan"));
                kategoriList.add(makanan);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return kategoriList;
    }

    public void showMakanan(){
        ObservableList<Makanan> list = getProdukList();
        tblIdProduk.setCellValueFactory(new PropertyValueFactory<Makanan ,Integer>("id"));
        tblNamaProduk.setCellValueFactory(new PropertyValueFactory<Makanan ,String>("nama_produk"));
        tblHargaProduk.setCellValueFactory(new PropertyValueFactory<Makanan ,Double>("harga"));
        tblJumlahProduk.setCellValueFactory(new PropertyValueFactory<Makanan ,Integer>("jumlah"));
        tblDt.setCellValueFactory(new PropertyValueFactory<Makanan ,Integer>("daya_tahan"));
        
        tableAllDataProduk.setItems(list);
    }

}
