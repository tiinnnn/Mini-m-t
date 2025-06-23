/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini.entity;

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
public class KhachHang {
    private String maKH;
    private String tenKH;
    private int sdt;
    private float tongChiTieu;
    private String hang;
}
