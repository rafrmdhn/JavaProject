package db;

import project_uap.Barang;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BarangModel {
    private final Connection CONN;

    public BarangModel(){
        this.CONN = DBHelper.getConnection();
    }

    public void addBarang(Barang barang){
        String insert = "INSERT INTO barang  VALUES ('"
                        + barang.getBarcode() + "', '" +
                        barang.getExpired() + "', '" +
                        barang.getNama_produk() + "', '" +
                        barang.getKategori() + "', '" +
                        barang.getHarga() + "', '" +
                        barang.getJumlah() + "', '" + 
                        barang.getDiskon() + "');";
        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Berhasil Memasukkan Data");
            }
            else{
                System.out.println("Gagal Memasukkan Data");
            }
        } catch (SQLException e) {
            System.out.println("Gagal Memasukkan Data" + e.getMessage());
        }
    }

    public void deleteBarang(Barang barang){
        String delete = "DELETE FROM barang WHERE barcode = '"
                        + barang.getBarcode() + "'";
        try {
            if(CONN.createStatement().executeUpdate(delete) > 0){
                System.out.println("Berhasil Hapus Data");
            }
            else{
                System.out.println("Gagal Hapus Data");
            }
        } catch (SQLException ex) {
            System.out.println("Gagal Hapus Data");
        }
    }

    public ObservableList<Barang> getBarang(){
        ObservableList<Barang> kategoriList = FXCollections.observableArrayList();
        String query = "SELECT * FROM Barang";
        Statement st;
        ResultSet rs; 
        
        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            Barang barang;
            while(rs.next()){
                barang = new Barang(rs.getString("nama_produk"),rs.getDouble("harga"), 
                         rs.getInt("jumlah"), rs.getDouble("diskon"), 
                         rs.getString("barcode"), rs.getString("expired"), 
                         rs.getString("kategori"));
                kategoriList.add(barang);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return kategoriList;
    }
}
