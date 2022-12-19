package db;

import project_uap.Makanan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MakananModel {
    private final Connection CONN;

    public MakananModel() {
        this.CONN = DBHelper.getConnection();
    }

    public void addMakanan(Makanan makanan){
        String insert = "INSERT INTO makanan  VALUES ('"
                        + makanan.getId() + "', '" +
                        makanan.getDaya_tahan() + "', '" +
                        makanan.getNama_produk() + "', '" +
                        makanan.getHarga() + "', '" +
                        makanan.getJumlah() + "' , '" +
                        makanan.getDiskon() + "');";
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

    public void deleteMakanan(Makanan makanan){
        String delete = "DELETE FROM makanan WHERE id = '"
                        + makanan.getId() + "'";
        
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

    public ObservableList<Makanan> getMakanan(){
        ObservableList<Makanan> kategoriList = FXCollections.observableArrayList();
        String query = "SELECT * FROM Makanan";
        Statement st;
        ResultSet rs; 
        
        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            Makanan makanan;
            while(rs.next()){
                makanan = new Makanan(rs.getString("nama_produk"),rs.getDouble("harga"), 
                          rs.getInt("jumlah"), rs.getDouble("diskon"), 
                          rs.getInt("id"), rs.getInt("daya_tahan"));
                kategoriList.add(makanan);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return kategoriList;
    }
}
