/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini.dao;

import java.util.List;
import mini.entity.HoaDonChiTiet;
import mini.util.XJdbc;
import mini.util.XQuery;

/**
 *
 * @author LENOVO
 */
public class HoaDonChiTietDaoImpl implements HoaDonChiTietDAO{
    String createSql = "INSERT INTO HoaDonChiTiet(BillId, maSP, soLuong, donGia, giamGiaSP) VALUES(?, ?, ?, ?, ?)";
    String updateSql = "UPDATE HoaDonChiTiet SET BillId=?, maSP=?, soLuong=?, donGia=?, giamGiaSP=? WHERE Id=?";
    String deleteSql = "DELETE FROM HoaDonChiTiet WHERE Id=?";
    String findAllSql = "SELECT bd.*, d.tenSP AS SPName\n" + "FROM HoaDonChiTiet bd JOIN SanPham d ON d.maSP=bd.maSP";
    String findByIdSql = "SELECT bd.*, d.tenSP AS SPName\n" + "FROM HoaDonChiTiet bd JOIN SanPham d ON d.maSP=bd.maSP WHERE bd.Id=?";
    String findByBillIdSql = "SELECT bd.*, d.tenSP AS SPName\n" + "FROM HoaDonChiTiet bd JOIN SanPham d ON d.maSP=bd.maSP WHERE bd.BillId=?";
    String findBymaSPSql = "SELECT bd.*, d.tenSP AS SPName\n" + "FROM HoaDonChiTiet bd JOIN SanPham d ON d.maSP=bd.maSP WHERE bd.maSP=?";
    @Override
    public List<HoaDonChiTiet> findByBillId(Long billId) {
        return XQuery.getBeanList(HoaDonChiTiet.class, findByBillIdSql, billId);  }

    @Override
    public List<HoaDonChiTiet> findBymaSP(String maSP) {
        return XQuery.getBeanList(HoaDonChiTiet.class, findBymaSPSql, maSP);
    }

    @Override
    public HoaDonChiTiet create(HoaDonChiTiet entity) {
        Object[] values = {
        entity.getBillId(),
        entity.getMaSP(),
        entity.getSoLuong(),
        entity.getDonGia(),
        entity.getGiamGiaSP()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(HoaDonChiTiet entity) {
 Object[] values = {
        entity.getBillId(),
        entity.getMaSP(),
        entity.getSoLuong(),
        entity.getDonGia(),
        entity.getGiamGiaSP(),
        entity.getId()
        };
        XJdbc.executeUpdate(updateSql, values);    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<HoaDonChiTiet> findAll() {
        return XQuery.getBeanList(HoaDonChiTiet.class, findAllSql);   
    }

    @Override
    public HoaDonChiTiet findById(Long id) {
       return XQuery.getSingleBean(HoaDonChiTiet.class, findByIdSql, id);  
    }
}
