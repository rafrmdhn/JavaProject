package db;

import project_uap.Kategori;

import java.sql.Connection;
import java.sql.SQLException;


public class KategoriModel {
    private final Connection CONN;

    public KategoriModel() throws SQLException {
        this.CONN = DBHelper.getConnection();
    }

    public void addKategori(Kategori kategori){
        String insert = "INSERT INTO kategori  VALUES ('"
                        + kategori.getNama_kategori() + "', '" +
                        kategori.getProduk() +"');";
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
}
