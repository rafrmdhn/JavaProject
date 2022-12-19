package db;

import project_uap.Penjualan;

import java.sql.Connection;
import java.sql.SQLException;

public class PenjualanModel {
    private final Connection CONN;

    public PenjualanModel() throws SQLException {
        this.CONN = DBHelper.getConnection();
    }
    public void addPenjualan(Penjualan penjualan){
        String insert = "INSERT INTO penjualan  VALUES ('"
                        + penjualan.getProduk() + "', '" +
                        penjualan.getJumlahProduk() + "', '" +
                        penjualan.getStok() + "');";
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
