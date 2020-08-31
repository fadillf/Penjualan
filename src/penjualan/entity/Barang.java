/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.entity;

import penjualan.interfc.BarangInterfc;

/**
 *
 * @author Fadillah F
 */
public class Barang{
    private String idBarang;
    private String namaBarang;
    private int jumlah;
    private int harga;
    
    public Barang(){
    }

    public Barang(String idBarang, String namaBarang, String jumlah, String harga) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.jumlah = Integer.parseInt(jumlah);
        this.harga = Integer.parseInt(harga);
    }

    public String getIdBarang() {
        return idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getHarga() {
        return harga;
    }

    /**
     * @param kodeBarang the kodeBarang to set
     */
    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    /**
     * @param namaBarang the namaBarang to set
     */
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    /**
     * @param jumlah the jumlah to set
     */
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(int harga) {
        this.harga = harga;
    }
    
}
