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
public interface BanHangController{
    void setBill(HoaDon HoaDon); // truyền bill vào cửa sổ để hiển thị
    void open(); // Hiển thị bill
    void close(); // Xóa bill nếu ko chứa đồ uống nào
    void showChonHangJDialog(); // Hiển thị cửa sổ bổ sung đồ uống vào bill
    void removeSP(); // Xóa đồ uống khỏi bil
    void updateQuantity(); // Thay đổi số lượng đồ uống
    void checkout(); // Thanh toán
    void cancel(); // Hủy bill
    void fillHoaDonChiTiet();
}
