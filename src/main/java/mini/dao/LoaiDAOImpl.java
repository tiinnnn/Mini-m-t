/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini.dao;

import java.util.List;
import mini.entity.LoaiSanPham;
import mini.util.XJdbc;
import mini.util.XQuery;

/**
 *
 * @author LENOVO
 */
public class LoaiDAOImpl implements LoaiDAO{
    String createSql = "INSERT INTO LoaiSanPham(maLoai, tenLoai) VALUES(?, ?)";
    String updateSql = "UPDATE LoaiSanPham SET tenLoai=? WHERE maLoai=?";
    String deleteSql = "DELETE FROM LoaiSanPham WHERE maLoai=?";
    String findAllSql = "SELECT * FROM LoaiSanPham";
    String findByIdSql = "SELECT * FROM LoaiSanPham WHERE maLoai=?";

    @Override
    public LoaiSanPham create(LoaiSanPham entity) {
        Object[] values = {
        entity.getMaLoai(),
        entity.getTenLoai()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;    
    }

    @Override
    public void update(LoaiSanPham entity) {
        Object[] values = {
         entity.getTenLoai(),
        entity.getMaLoai()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);    
    }

    @Override
    public List<LoaiSanPham> findAll() {
        return XQuery.getBeanList(LoaiSanPham.class, findAllSql);   
    }

    @Override
    public LoaiSanPham findById(String id) {
        return XQuery.getSingleBean(LoaiSanPham.class, findByIdSql, id);  
    }
}
