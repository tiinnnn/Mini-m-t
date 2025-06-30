/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini.dao;

import java.util.List;
import mini.entity.KhachHang;
import mini.util.XJdbc;
import mini.util.XQuery;

/**
 *
 * @author LENOVO
 */
public class KhachHangDAOImpl implements KhachHangDAO{
    String createSql = "INSERT INTO KhachHang(maKH,tenKH,sdt,hang) VALUES(?, ?, ?, ?)";
    String updateSql = "UPDATE KhachHang SET tenKH=?, sdt=?, hang=? where maKH=?";
    String deleteSql = "DELETE FROM KhachHang where maKH=?";
    String findAllSql = "SELECT * FROM KhachHang";
    String findByIdSql = "SELECT * FROM KhachHang where maKH=?";
    @Override
    public KhachHang create(KhachHang entity) {
        Object[] values = {
        entity.getMaKH(),
        entity.getTenKH(),
        entity.getSdt(),
        entity.getHang()
        };
        XJdbc.executeUpdate(createSql, values);  
        return entity;
    }

    @Override
    public void update(KhachHang entity) {
        Object[] values = {    
        entity.getTenKH(),
        entity.getSdt(),
        entity.getHang(),
        entity.getMaKH()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
         XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<KhachHang> findAll() {
        return XQuery.getBeanList(KhachHang.class, findAllSql);
    }

    @Override
    public KhachHang findById(String id) {
        return XQuery.getSingleBean(KhachHang.class, findByIdSql, id);
    }
    
}
