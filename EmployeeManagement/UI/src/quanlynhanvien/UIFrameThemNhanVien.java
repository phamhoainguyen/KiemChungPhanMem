/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

import BLLChucVu.BLLChucVu;
import BLLChucVu.BLLLuong;
import BLLChucVu.BLLNhanVien;
import BLLChucVu.BLLPhongBan;
import dataOjects.DAONhanVien;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author NguyenPH
 */
public class UIFrameThemNhanVien extends javax.swing.JFrame {

    private DAONhanVien daoNhanVien;
    private BLLChucVu bllChucVu;
    private BLLPhongBan bllPhongBan;
    private BLLNhanVien bllNhanVien;
    private BLLLuong bllLuong;
    private Map <String, String> mapChucVu; 
    private Map <String, String> mapPhongBan; 
    private Map <String, String> mapLuong; 
    /**
     * Creates new form UIFrameThemNhanVien
     * @param _nhanVien
     */

    
    // ham khoi tao
    public UIFrameThemNhanVien(DAONhanVien _nhanVien) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.daoNhanVien = _nhanVien;
        
        initMembers();
        initComboChucVu();
        initComboPhongBan();
        initComboLuong();
        this.taoMaNhanVien();
        this.showThongTinNhanVien();
    }
    
    
    // show thong tin nhan vien
    public void showThongTinNhanVien(){
        if(this.daoNhanVien != null){
            
            try {
                this.jLabelMaNV.setText(daoNhanVien.getMaNhanVien());
                this.jTextFieldCMND.setText(daoNhanVien.getSoCMND());
                this.jTextFieldHoTen.setText(daoNhanVien.getTenNhanVien());
                this.jTextFieldQueQuan.setText(daoNhanVien.getQueQuan());
                this.jTextFieldSDT.setText(daoNhanVien.getSoDienThoai());
                this.jTextFieldSTK.setText(daoNhanVien.getSoTaiKhoan());
                this.jTextPanGhiChu.setText(daoNhanVien.getGhiChu());
                this.jTextPaneDiaChi.setText(daoNhanVien.getDiaChi());
                
                if(Integer.parseInt(daoNhanVien.getGioiTinh()) == 1){
                    this.jRadioButtonNam.setSelected(true);
                }
                else{
                    this.jRadioButtonu.setSelected(true);
                }
                
                Calendar date = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                
                date.setTime(sdf.parse(daoNhanVien.getNgayVaoLam()));
                this.dateChooserComboNVL.setSelectedDate(date);
                
                date.setTime(sdf.parse(daoNhanVien.getNgaySinh()));
                this.dateChooserComboNS.setSelectedDate(date);
            } catch (Exception ex) {
                Logger.getLogger(UIFrameThemNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    
    // Tu dong tao ma nhan vien
    private void taoMaNhanVien(){
        try {
            if(this.daoNhanVien == null){
                String lastesMaNV = this.bllNhanVien.getLastesNhanVien();
                String nextMaNV = Utilities.taoMaTiepTheo(lastesMaNV);
                this.jLabelMaNV.setText(nextMaNV);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
        // get du lieu tu database
    private void initMembers(){
        
        
        try {
            // do tat ca cac chuc vu vao mapChucVu
            this.bllChucVu = new BLLChucVu();

            this.mapChucVu = bllChucVu.getAllChucVu();

            this.bllPhongBan = new BLLPhongBan();
            this.mapPhongBan = bllPhongBan.getAllPhongBan();
            
            this.bllLuong = new BLLLuong();
            this.mapLuong = bllLuong.getALlBacLuong();
            
            this.bllNhanVien = new BLLNhanVien();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    // khoi tao gia tri cho cac combo Chuc Vu
    public void initComboChucVu(){
        try{
            this.jComboBoxChucVu.addItem("");

            for(Map.Entry m:mapChucVu.entrySet()){
                this.jComboBoxChucVu.addItem(m.getKey().toString());
            }
           
            if(this.daoNhanVien != null){
                String itemChucVu = this.daoNhanVien.getTenChucVu();
                if(!itemChucVu.isEmpty()){
                    this.jComboBoxChucVu.setSelectedItem(itemChucVu);
                }

            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    // khoi tao gia tri cho cac combo Phong Ban
    public void initComboPhongBan(){
        try{
            this.jComboBoxPhongBan.addItem("");

            for(Map.Entry m:mapPhongBan.entrySet()){
                this.jComboBoxPhongBan.addItem(m.getKey().toString());
            }
           
            if(this.daoNhanVien != null){
                String itemPhongBan = this.daoNhanVien.getTenPhongBan();
                if(!itemPhongBan.isEmpty()){
                    this.jComboBoxPhongBan.setSelectedItem(itemPhongBan);
                }

            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    // khoi tao gia tri cho cac combo Phong Ban
    public void initComboLuong(){
        try{
            this.jComboBoxBacLuong.addItem("");

            for(Map.Entry m:mapLuong.entrySet()){
                this.jComboBoxBacLuong.addItem(m.getKey().toString());
            }
           
            if(this.daoNhanVien != null){
                String itemLuong = this.daoNhanVien.getBacLuong();
                if(!itemLuong.isEmpty()){
                    this.jComboBoxBacLuong.setSelectedItem(itemLuong);
                }

            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    
    
    private void initialValuesForControls(){
        try{
            if(this.daoNhanVien != null){
                
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelc = new javax.swing.JLabel();
        jLabelMaNV = new javax.swing.JLabel();
        jTextFieldHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldCMND = new javax.swing.JTextField();
        jTextFieldQueQuan = new javax.swing.JTextField();
        jComboBoxBacLuong = new javax.swing.JComboBox<>();
        jComboBoxPhongBan = new javax.swing.JComboBox<>();
        jComboBoxChucVu = new javax.swing.JComboBox<>();
        jTextFieldSTK = new javax.swing.JTextField();
        jTextFieldSDT = new javax.swing.JTextField();
        jRadioButtonNam = new javax.swing.JRadioButton();
        jRadioButtonu = new javax.swing.JRadioButton();
        jButtonHuyBo = new javax.swing.JButton();
        jButtonLuu = new javax.swing.JButton();
        jButtonLamMoi = new javax.swing.JButton();
        dateChooserComboNS = new datechooser.beans.DateChooserCombo();
        dateChooserComboNVL = new datechooser.beans.DateChooserCombo();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneDiaChi = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPanGhiChu = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelc.setText("Mã nhân viên: ");

        jTextFieldHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHoTenActionPerformed(evt);
            }
        });

        jLabel3.setText("Họ và Tên: ");

        jLabel4.setText("Số CMND: ");

        jLabel5.setText("Giới tính: ");

        jLabel6.setText("Chức vụ: ");

        jLabel7.setText("Ngày vào làm: ");

        jLabel8.setText("Phòng ban: ");

        jLabel9.setText("Ngày sinh: ");

        jLabel10.setText("Số tài khoản: ");

        jLabel11.setText("Quê quán: ");

        jLabel12.setText("Số điện thoại: ");

        jLabel13.setText("Địa chỉ: ");

        jLabel14.setText("Ghi chú: ");

        jLabel15.setText("Bậc lương: ");

        jTextFieldCMND.setText("221420525");

        jTextFieldQueQuan.setText("Bình Dương");

        jTextFieldSTK.setText("2211 3456 44562");

        jTextFieldSDT.setText("0988588xxx");

        buttonGroup1.add(jRadioButtonNam);
        jRadioButtonNam.setText("Nam");

        buttonGroup1.add(jRadioButtonu);
        jRadioButtonu.setText("Nữ");

        jButtonHuyBo.setText("Hủy bỏ");

        jButtonLuu.setText("Lưu");
        jButtonLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLuuActionPerformed(evt);
            }
        });

        jButtonLamMoi.setText("Làm mới");

        dateChooserComboNS.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dateChooserComboNS.setLocale(new java.util.Locale("vi", "", ""));

    dateChooserComboNVL.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
        new datechooser.view.appearance.ViewAppearance("custom",
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(0, 0, 0),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(0, 0, 0),
                new java.awt.Color(0, 0, 255),
                true,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(0, 0, 255),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(128, 128, 128),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.LabelPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(0, 0, 0),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.LabelPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(0, 0, 0),
                new java.awt.Color(255, 0, 0),
                false,
                false,
                new datechooser.view.appearance.swing.ButtonPainter()),
            (datechooser.view.BackRenderer)null,
            false,
            true)));
dateChooserComboNVL.setLocale(new java.util.Locale("vi", "", ""));

jScrollPane1.setViewportView(jTextPaneDiaChi);

jScrollPane2.setViewportView(jTextPanGhiChu);

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButtonLamMoi)
                .addGap(28, 28, 28)
                .addComponent(jButtonHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelc)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonNam, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonu, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooserComboNVL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(dateChooserComboNS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldCMND, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldQueQuan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMaNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2))
                                .addGap(0, 3, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldSTK, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxPhongBan, 0, 207, Short.MAX_VALUE)
                                    .addComponent(jComboBoxChucVu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxBacLuong, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))))
        .addGap(32, 32, 32))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabelMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelc)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(19, 19, 19)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel15)
                .addComponent(jLabel4)
                .addComponent(jTextFieldCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBoxBacLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(25, 25, 25)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonNam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonu, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(30, 30, 30)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(jLabel9)
                .addComponent(jComboBoxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(dateChooserComboNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel10)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldSTK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateChooserComboNVL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(37, 37, 37)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel11)
                .addComponent(jLabel12)
                .addComponent(jTextFieldQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextFieldSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(34, 34, 34)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addComponent(jScrollPane2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonHuyBo)
                .addComponent(jButtonLuu)
                .addComponent(jButtonLamMoi))
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHoTenActionPerformed

    private void jButtonLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLuuActionPerformed
        // TODO add your handling code here:
        try{
            DAONhanVien nhanVien = new DAONhanVien();
            nhanVien.setBacLuong(this.jComboBoxBacLuong.getSelectedItem().toString());
            nhanVien.setDiaChi(this.jTextPaneDiaChi.getText());
            nhanVien.setGhiChu(this.jTextPanGhiChu.getText());
            nhanVien.setMaChucVu(this.getMaChucVu());
            nhanVien.setMaNhanVien(this.jLabelMaNV.getText());
            nhanVien.setMaPhongBan(this.getMaPhongBan());
            nhanVien.setNgaySinh(this.dateChooserComboNS.getText());
            nhanVien.setNgayVaoLam(this.dateChooserComboNVL.getText());
            nhanVien.setQueQuan(this.jTextFieldQueQuan.getText());
            nhanVien.setSoCMND(this.jTextFieldCMND.getText());
            nhanVien.setSoDienThoai(this.jTextFieldSDT.getText());
            nhanVien.setSoTaiKhoan(this.jTextFieldSTK.getText());
            nhanVien.setTenNhanVien(this.jTextFieldHoTen.getText());
            nhanVien.setGioiTinh(String.valueOf(this.getGioiTinh()));

            if(this.checkValidate(nhanVien)){
                if(this.daoNhanVien == null){
                    int status = this.bllNhanVien.insertNhanVien(nhanVien);
                    if(status != 0){
                        this.dispose();
                        JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    int status = this.bllNhanVien.updateNhanVien(nhanVien);
                    if(status != 0){
                        this.dispose();
                        JOptionPane.showMessageDialog(null, "Cập nhật thông tin thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                
            }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage()+ ex.getStackTrace(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonLuuActionPerformed

    public String getMaPhongBan(){
        String tenPhongBan = this.jComboBoxPhongBan.getSelectedItem().toString();
        String maPhongBan = this.mapPhongBan.get(tenPhongBan);
        return maPhongBan;
    }
    
    public String getMaChucVu(){
        String tenChucVu = this.jComboBoxChucVu.getSelectedItem().toString();
        String maChucVu = this.mapChucVu.get(tenChucVu);
        return maChucVu;
    }
    
    public int getGioiTinh(){
        try{
            if(this.jRadioButtonNam.isSelected() == true){
                return 1;
            }
            if(this.jRadioButtonu.isSelected() == true){
                return 0;
            }
            
            if(this.jRadioButtonu.isSelected() == false && this.jRadioButtonNam.isSelected() == false){
                JOptionPane.showMessageDialog(null, "Chua chon gioi tinh", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }
    
    
    // check Validate
    private boolean checkValidate(DAONhanVien nv){
        try{
            if(nv.getGioiTinh().isEmpty() || nv.getMaChucVu().isEmpty() 
                    || nv.getMaPhongBan().isEmpty() || nv.getSoCMND().isEmpty()
                    || nv.getTenNhanVien().isEmpty() || nv.getBacLuong().isEmpty()){
                JOptionPane.showMessageDialog(null, "Chưa nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            return true;
        }catch(Exception ex){
            throw ex;
        }
    }

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private datechooser.beans.DateChooserCombo dateChooserComboNS;
    private datechooser.beans.DateChooserCombo dateChooserComboNVL;
    private javax.swing.JButton jButtonHuyBo;
    private javax.swing.JButton jButtonLamMoi;
    private javax.swing.JButton jButtonLuu;
    private javax.swing.JComboBox<String> jComboBoxBacLuong;
    private javax.swing.JComboBox<String> jComboBoxChucVu;
    private javax.swing.JComboBox<String> jComboBoxPhongBan;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMaNV;
    private javax.swing.JLabel jLabelc;
    private javax.swing.JRadioButton jRadioButtonNam;
    private javax.swing.JRadioButton jRadioButtonu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldCMND;
    private javax.swing.JTextField jTextFieldHoTen;
    private javax.swing.JTextField jTextFieldQueQuan;
    private javax.swing.JTextField jTextFieldSDT;
    private javax.swing.JTextField jTextFieldSTK;
    private javax.swing.JTextPane jTextPanGhiChu;
    private javax.swing.JTextPane jTextPaneDiaChi;
    // End of variables declaration//GEN-END:variables
}
