/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mini.dao;

import java.util.Date;
import java.util.List;
import mini.entity.HoaDon;

/**
 *
 * @author LENOVO
 */
public interface HoaDonDAO extends CrudDAO<HoaDon, Long>{
    List<HoaDon> findByUsername(String username);
    List<HoaDon> findByTimeRange(Date begin, Date end);
    List<HoaDon> findByUserAndTimeRange(String username, Date begin, Date end);

    public Long insertAndReturnId(HoaDon bill);
}
