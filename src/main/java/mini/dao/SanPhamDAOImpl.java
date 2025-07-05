/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini.dao;

import java.util.List;
import mini.entity.SanPham;
import mini.util.XJdbc;
import mini.util.XQuery;

/**
 *
 * @author LENOVO
 */
public class SanPhamDAOImpl implements SanPhamDAO{
    String createSql = "INSERT INTO SanPham(maSP,tenSP,giaNhap,giaBan,soLuong,giamGiaSP,hinhAnh,maLoai) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    String updateSql = "UPDATE SanPham SET tenSP=?, giaNhap=?, giaBan=?, soLuong=?, giamGiaSP=?, hinhAnh=?, maLoai=? where maSP=?";
    String deleteSql = "DELETE FROM SanPham where maSP=?";
    String findAllSql = "SELECT * FROM SanPham";
    String findByIdSql = "SELECT * FROM SanPham where maSP=?";
    String findByCategoryIdSql = "SELECT maSP,tenSP,giaNhap,giaBan,soLuong,giamGiaSP,hinhAnh,maLoai FROM SanPham WHERE maLoai=?";
    @Override
    public SanPham create(SanPham entity) {
        Object[] values = {
        entity.getMaSP(),
        entity.getTenSP(),
        entity.getGiaNhap(),
        entity.getGiaBan(),
        entity.getSoLuong(),
        entity.getGiamGiaSP(),
        entity.getHinhAnh(),
        entity.getMaLoai()
        };
        XJdbc.executeUpdate(createSql, values);  
        return entity;
    }

    @Override
    public void update(SanPham entity) {
        Object[] values = {    
        entity.getTenSP(),
        entity.getGiaNhap(),
        entity.getGiaBan(),
        entity.getSoLuong(),
        entity.getGiamGiaSP(),
        entity.getHinhAnh(),
        entity.getMaLoai(),
        entity.getMaSP()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<SanPham> findAll() {
        return XQuery.getBeanList(SanPham.class, findAllSql);
    }

    @Override
    public SanPham findById(String id) {
        return XQuery.getSingleBean(SanPham.class, findByIdSql, id);
    }

    @Override
    public List<SanPham> findByLoaiId(String maLoai) {
        return XQuery.getBeanList(SanPham.class, findByCategoryIdSql, maLoai);   
    }
    
}
