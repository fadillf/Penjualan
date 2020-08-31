/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import penjualan.entity.Barang;
import penjualan.interfc.BarangInterfc;
import penjualan.koneksi.Koneksi;

/**
 *
 * @author Fadillah F
 */
public class BarangImplement implements BarangInterfc{
    Koneksi konek;
    
    @Override
    public List getAll() {
        List<Barang> e = new ArrayList<Barang>();
        try{
            Statement stmt = (Statement) konek.getConnection().createStatement();
            String query = "SELECT * FROM barang";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                Barang brg = new Barang();
                brg.setIdBarang(rs.getString("id_barang"));
                brg.setNamaBarang(rs.getString("nama_barang"));
                brg.setJumlah(rs.getInt("jumlah"));
                brg.setHarga(rs.getInt("harga"));   
                e.add(brg);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return e;
    }

    @Override
    public void insert(Barang barang) {
        try{
            Statement stmt = (Statement) konek.getConnection().createStatement();
            String query = "INSERT INTO barang(id_barang, nama_barang, jumlah, harga)" + "VALUES('"+barang.getIdBarang()+"','"+barang.getNamaBarang()+"','"+barang.getJumlah()+"','"+barang.getHarga()+"')";
            stmt.executeUpdate(query);
        }
        catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada Kesalahan");
        }
    }

    @Override
    public void update(Barang barang) {
        try{
            Statement stmt = (Statement) konek.getConnection().createStatement();
            String query = "UPDATE barang SET id_barang = '" + barang.getIdBarang() + "'," + "nama_barang = '" + barang.getNamaBarang() + "'," + "jumlah = '" + barang.getJumlah() + "'," + "harga = '" + barang.getHarga() + "' WHERE id_barang = '" + barang.getIdBarang() + "'";
            stmt.executeUpdate(query);
        }
        catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada Kesalahan");
        }
    }

    @Override
    public void delete(String id_barang) {
        try{
            Statement stmt =konek.getConnection().createStatement();
            String query = "DELETE FROM barang WHERE id_barang = '" + id_barang + "';";
            stmt.executeUpdate(query);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
