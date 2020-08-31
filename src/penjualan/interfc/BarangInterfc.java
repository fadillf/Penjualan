/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.interfc;

import java.util.List;
import penjualan.entity.Barang;

/**
 *
 * @author Fadillah F
 */
public interface BarangInterfc {
 
    List getAll();
    void insert(Barang barang);
    void update(Barang barang);
    void delete(String kode_barang);
}
