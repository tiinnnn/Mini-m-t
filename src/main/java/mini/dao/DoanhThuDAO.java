/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mini.dao;

import java.util.Date;
import java.util.List;
import mini.entity.DoanhThu;

/**
 *
 * @author LENOVO
 */
public interface DoanhThuDAO {
    List<DoanhThu.ByLoai> getByCategory(Date begin, Date end); 
    List<DoanhThu.ByNV> getByUser(Date begin, Date end);
}
