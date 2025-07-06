/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mini.ui;

import mini.entity.HoaDon;


/**
 *
 * @author nguye
 */
public interface QLHoaDonController extends CrudController<HoaDon>{
    void fillBillDetails();
    void selectTimeRange();
}
