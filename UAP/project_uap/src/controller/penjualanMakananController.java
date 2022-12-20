package controller;

import static db.DBHelper.getConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project_uap.Makanan;

public class penjualanMakananController implements Initializable{
    MakananModel makanan = new MakananModel();
    ObservableList<String> kategoriList = FXCollections.observableArrayList("Barang", "Makanan");

    @FXML
    private Button btnBack;

    @FXML
    private Button btnBuy;

    @FXML
    private ComboBox<String> dropdownKategori;

    @FXML
    private TextField fieldId;

    @FXML
    private Text lblTotalHarga;

    @FXML
    private TableColumn<Makanan, Integer> tblDt;

    @FXML
    private TableColumn<Makanan, Double> tblHargaMakananPenjualan;

    @FXML
    private TableColumn<Makanan, Integer> tblId;

    @FXML
    private TableColumn<Makanan, Integer> tblJumlah;

    @FXML
    private TableColumn<Makanan, String> tblNamaMakananPenjualan;

    @FXML
    private TableColumn<Makanan, Double> tblDiskon;

    @FXML
    private TableView<Makanan> tblMakananPenjualan;

    @FXML
    void backToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/userLogin.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void beliBarang(ActionEvent event) throws IOException {
        Makanan makan = new Makanan(Integer.parseInt(fieldId.getText()));
        makanan.deleteMakanan(makan);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/penjualanMakanan.fxml"));
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
            
            if (selected.equals("Barang")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/penjualanBarang.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) dropdownKategori.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        showMakananPenjualan();
        totalHarga();
    }

    public void showMakananPenjualan(){
        ObservableList<Makanan> list = makanan.getMakanan();
        tblId.setCellValueFactory(new PropertyValueFactory<Makanan ,Integer>("id"));
        tblNamaMakananPenjualan.setCellValueFactory(new PropertyValueFactory<Makanan ,String>("nama_produk"));
        tblHargaMakananPenjualan.setCellValueFactory(new PropertyValueFactory<Makanan ,Double>("harga"));
        tblJumlah.setCellValueFactory(new PropertyValueFactory<Makanan ,Integer>("jumlah"));
        tblDt.setCellValueFactory(new PropertyValueFactory<Makanan ,Integer>("daya_tahan"));
        tblDiskon.setCellValueFactory(new PropertyValueFactory<Makanan ,Double>("diskon"));
        
        tblMakananPenjualan.setItems(list);
    }

    public void totalHarga(){
        int count = 0;
        String query = "SELECT SUM(harga) AS harga FROM Makanan;";
        Connection CONN = getConnection();
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                count += rs.getDouble("harga");
            }
            lblTotalHarga.setText(Double.toString(count));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
