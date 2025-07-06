/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini.dao;

import java.util.Date;
import java.util.List;
import mini.entity.DoanhThu.ByLoai;
import mini.entity.DoanhThu.ByNV;
import mini.util.XQuery;

/**
 *
 * @author LENOVO
 */
public class DoanhThuDAOImpl implements DoanhThuDAO{

    @Override
    public List<ByLoai> getByCategory(Date begin, Date end) {
        String sql = """
            SELECT loaiSP.tenLoai AS maLoai,
                   SUM(hdct.donGia * hdct.soLuong * (1 - hdct.giamGiaSP)) AS doanhThu,
                   SUM(hdct.soLuong) AS soLuong,
                   MIN(hdct.donGia) AS minPrice,
                   MAX(hdct.donGia) AS maxPrice,
                   AVG(hdct.donGia) AS avgPrice,
                   SUM(hdct.donGia * hdct.soLuong * (1 - hdct.giamGiaSP))- SUM(sp.giaNhap * hdct.soLuong) AS profit
            FROM HoaDonChiTiet hdct
            JOIN SanPham sp ON sp.maSP = hdct.maSP
            JOIN LoaiSanPham loaiSP ON loaiSP.maLoai = sp.maLoai
            JOIN HoaDon hd ON hd.Id = hdct.BillId
            WHERE hd.Status = 1 AND hd.ngayLap BETWEEN ? AND ?
            GROUP BY loaiSP.tenLoai
            ORDER BY doanhThu DESC
        """;
        return XQuery.getBeanList(ByLoai.class, sql, begin, end);
    }

    @Override
    public List<ByNV> getByUser(Date begin, Date end) {
        String sql = """
            SELECT hd.maNV AS maNV,
                   SUM(hdct.donGia * hdct.soLuong * (1 - hdct.giamGiaSP)) AS doanhThu,
                   COUNT(DISTINCT hd.Id) AS soLuong,
                   MIN(hd.ngayLap) AS firstTime,
                   MAX(hd.ngayLap) AS lastTime
            FROM HoaDonChiTiet hdct
            JOIN HoaDon hd ON hd.Id = hdct.BillId
            WHERE hd.Status = 1 AND hd.ngayLap BETWEEN ? AND ?
            GROUP BY hd.maNV
            ORDER BY doanhThu DESC
        """;
        return XQuery.getBeanList(ByNV.class, sql, begin, end);
    }
    
}
