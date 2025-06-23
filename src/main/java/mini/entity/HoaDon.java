/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author LENOVO
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HoaDon {
    private Long id;
    private String maNV;
    private String maKH;
    @Builder.Default
    private Date ngayLap = new Date();
    private float tongTien;
    private float giamGia;
    private float thanhToan;
    private int status;
    public enum Status {
    Servicing, Completed, Canceled;
    }
}
