/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mini.ui;

import mini.entity.HoaDon;

/**
 *
 * @author LENOVO
 */
public interface ChonHangController {
    void setBill(HoaDon hoaDon); // nhận bill từ BillJDialog 
    void open(); // hiển thị loại và đồ uống
    void fillLoai(); // tải và hiển thị loại đồ uống
    void fillSP(); // tải và hiển thị đồ uống
    void addSPToBill(); // thêm đồ uống vào bil
}
