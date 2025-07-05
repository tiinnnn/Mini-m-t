/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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

    @Override
    public Long insertAndReturnId(HoaDon bill) {
    Long generatedId = null;
    String sql = "INSERT INTO HoaDon (MaKH, MaNV, NgayLap, Status) VALUES (?, ?, ?, ?)";
    try (Connection con = XJdbc.openConnection();
         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        ps.setString(1, bill.getMaKH());
        ps.setString(2, bill.getMaNV());
        ps.setTimestamp(3, new Timestamp(bill.getNgayLap().getTime()));
        ps.setInt(4, bill.getStatus());

        ps.executeUpdate();

        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                generatedId = rs.getLong(1);
            }
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return generatedId;
}
}
