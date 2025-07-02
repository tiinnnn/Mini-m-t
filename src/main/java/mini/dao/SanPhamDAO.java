/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mini.dao;

import java.util.List;
import mini.entity.SanPham;

/**
 *
 * @author LENOVO
 */
public interface SanPhamDAO extends CrudDAO<SanPham,String>{
    List<SanPham> findByLoaiId(String maLoai);
}
