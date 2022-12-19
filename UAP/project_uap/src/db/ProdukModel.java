package db;


import project_uap.Produk;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ProdukModel {
    private final Connection CONN;

    public ProdukModel() {
        this.CONN = DBHelper.getConnection();
    }
    
    public void addProduk(Produk produk){
        String insert = "INSERT INTO produk  VALUES ('"
                        + produk.getNama_produk() + "', '" +
                        produk.getHarga() + "', '" +
                        produk.getJumlah() + "', '" +
                        produk.getDiskon() + "');";
        
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

    public ObservableList<Produk> getProduk(){
        ObservableList<Produk> kategoriList = FXCollections.observableArrayList();
        String query = "SELECT Makanan.nama_produk, Makanan.jumlah, Makanan.diskon," +
                       " (Makanan.harga) - (Makanan.harga * Makanan.diskon) AS harga FROM Makanan UNION SELECT " + 
                       "Barang.nama_produk, Barang.jumlah, Barang.diskon," +
                       " (Barang.harga) - (Barang.harga*Barang.diskon) as harga FROM Barang;";
        Statement st;
        ResultSet rs; 
        
        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            Produk produk;
            while(rs.next()){
                produk = new Produk(rs.getString("nama_produk"),rs.getDouble("harga"), 
                         rs.getInt("jumlah"), rs.getDouble("diskon"));
                kategoriList.add(produk);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return kategoriList;
    }
}
