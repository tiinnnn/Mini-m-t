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
public class DoanhThu {
    @AllArgsConstructor 
    @NoArgsConstructor 
    @Builder 
    @Data 
    public static class ByLoai {
        private String maLoai; 
        private double doanhThu; 
        private int soLuong; 
        private double minPrice; 
        private double maxPrice; 
        private double avgPrice;
        private double profit;
    } 
    @AllArgsConstructor 
    @NoArgsConstructor 
    @Builder 
    @Data 
    public static class ByNV { 
        private String maNV; 
        private double doanhThu; 
        private int soLuong; 
        private Date firstTime; 
        private Date lastTime;
    }
}
