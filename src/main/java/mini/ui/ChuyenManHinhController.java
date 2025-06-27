/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author LENOVO
 */
public class ChuyenManHinhController {
    private JPanel root;
    private String kindSelected= "";
    
    private List<DanhMucBean>listItem=null;
    
    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected="ChangeUser";
        jpnItem.setBackground(new Color(102,102,255));
        jlbItem.setBackground(new Color(102,102,255));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new ChangeUserJPanel());
        root.validate();
        root.repaint();
    }
    public void setEvent(List<DanhMucBean>listItem){
        this.listItem = listItem;
        for(DanhMucBean item: listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "BanHang":
                    node = new BanHangJPanel();
                    break;
                case "LichSu":
                    node = new LichSuJPanel();
                    break;
                case "QLKhachHang":
                    node = new QLKhachHangJPanel();
                    break;
                case "QLNhanVien":
                    node = new QLNhanVienJPanel();
                    break;
                case "QLLSP":
                    node = new QLLoaiSPJPanel();
                    break;
                case "QLSP":
                    node = new QLSanPhamJPanel();
                    break;
                case "DoanhThu":
                    node = new DoanhThuJPanel();
                    break;
                case "QLHoaDon":
                    node = new QLHoaDonJPanel();
                    break;
                case "Pass":
                    node = new ChangePasswordJPanel();
                    break;
                case "ChangeUser":
                    node = new ChangeUserJPanel();
                    break;
                default:
                    node = new ChangeUserJPanel(); // hoặc bạn có thể để là null hoặc panel mặc định khác
                    break;
            }
           root.removeAll();
           root.setLayout(new BorderLayout());
           root.add(node);
           root.validate();
           root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
           jpnItem.setBackground(new Color(255,153,255));
           jlbItem.setBackground(new Color(255,153,255));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(153,153,255));
            jlbItem.setBackground(new Color(153,153,255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(153,153,255));
                jlbItem.setBackground(new Color(153,153,255));
            }
        }
        private void setChangeBackground(String kind){
            for(DanhMucBean item : listItem){
                if(item.getKind().equalsIgnoreCase(kind)){
                    item.getJpn().setBackground(new Color(102,102,255));
                    item.getJlb().setBackground(new Color(102,102,255));
                }else{
                    item.getJpn().setBackground(new Color(153,153,255));
                    item.getJlb().setBackground(new Color(153,153,255));
                }
            }
        }
    }
} 
