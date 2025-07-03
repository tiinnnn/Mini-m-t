/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini.dao;

import java.util.Date;
import java.util.List;
import mini.entity.HoaDon;
import mini.util.XJdbc;
import mini.util.XQuery;

/**
 *
 * @author LENOVO
 */
public class HoaDonDAOImpl implements HoaDonDAO {
    String createSql = "INSERT INTO HoaDon(maNV, maKH, ngayLap, tongTien, giamGia, thanhToan, Status) VALUES(?, ?, ?, ?, ?, ?, ?)";
    String updateSql = "UPDATE HoaDon SET maNV=?, maKH=?, ngayLap=?, tongTien=?, giamGia=?, thanhToan=?, Status=? WHERE Id=?";
    String deleteSql = "DELETE FROM HoaDon WHERE Id=?";
    String findAllSql = "SELECT * FROM HoaDon";
    String findByIdSql = "SELECT * FROM HoaDon WHERE Id=?";
    String findByMaNVSql = "SELECT * FROM HoaDon WHERE maNV=?";
    String findByTimeRangeSql = "SELECT * FROM HoaDon WHERE ngayLap BETWEEN ? AND ? ORDER BY ngayLap DESC";

    @Override
    public List<HoaDon> findByUsername(String username) {
        return XQuery.getBeanList(HoaDon.class, findByMaNVSql, username);   
    }

    @Override
    public List<HoaDon> findByTimeRange(Date begin, Date end) {
        return XQuery.getBeanList(HoaDon.class, findByTimeRangeSql, begin, end);
    }

    @Override
    public List<HoaDon> findByUserAndTimeRange(String username, Date begin, Date end) {
        String sql = "SELECT * FROM HoaDon " + " WHERE maNV=? AND NgayLap BETWEEN ? AND ?";
        return XQuery.getBeanList(HoaDon.class, sql, username, begin, end);
    }

    @Override
    public HoaDon create(HoaDon entity) {
        Object[] values = {
        entity.getMaNV(),        
        entity.getMaKH(),
        entity.getNgayLap(),
        entity.getTongTien(),
        entity.getGiamGia(),
        entity.getThanhToan(),
        entity.getStatus()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(HoaDon entity) {
        Object[] values = {
        entity.getMaNV(),        
        entity.getMaKH(),
        entity.getNgayLap(),
        entity.getTongTien(),
        entity.getGiamGia(),
        entity.getThanhToan(),
        entity.getStatus(),
        entity.getId()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<HoaDon> findAll() {
        return XQuery.getBeanList(HoaDon.class, findAllSql);  
    }

    @Override
    public HoaDon findById(Long id) {
        return XQuery.getSingleBean(HoaDon.class, findByIdSql, id);  
    }
    
}
