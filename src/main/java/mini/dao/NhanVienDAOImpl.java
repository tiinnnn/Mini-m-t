package mini.dao;


import java.util.List;
import mini.dao.NhanVienDAO;
import mini.entity.NhanVien;
import mini.util.XJdbc;
import mini.util.XQuery;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class NhanVienDAOImpl implements NhanVienDAO{
    String createSql = "INSERT INTO NhanVien(maNV,Password, Enabled ,Fullname,Manager) VALUES(?, ?, ?, ?, ?)";
    String updateSql = "UPDATE NhanVien SET Password=?, Enabled=?, Fullname=?, Manager=? where maNV=?";
    String deleteSql = "DELETE FROM NhanVien where maNV=?";
    String findAllSql = "SELECT * FROM NhanVien";
    String findByIdSql = "SELECT * FROM NhanVien where maNV=?";
    @Override
    public NhanVien create(NhanVien entity) {
        Object[] values = {
        entity.getMaNV(),
        entity.getPassword(),
        entity.isEnabled(),
        entity.getFullname(),
        entity.isManager()
        };
        XJdbc.executeUpdate(createSql, values);  
        return entity;
    }

    @Override
    public void update(NhanVien entity) {
        Object[] values = {    
        entity.getPassword(),
        entity.isEnabled(),
        entity.getFullname(),
        entity.isManager(),
        entity.getMaNV()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<NhanVien> findAll() {
        return XQuery.getBeanList(NhanVien.class, findAllSql);
    }

    @Override
    public NhanVien findById(String id) {
        return XQuery.getSingleBean(NhanVien.class, findByIdSql, id);
    }
    
}
