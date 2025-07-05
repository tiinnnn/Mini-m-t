/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mini.dao;

import java.util.List;
import mini.entity.HoaDonChiTiet;
/**
 *
 * @author LENOVO
 */
public interface HoaDonChiTietDAO extends CrudDAO<HoaDonChiTiet, Long>{
    List<HoaDonChiTiet> findByBillId(Long billId);
    List<HoaDonChiTiet> findBymaSP(String maSP);
}
