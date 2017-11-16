/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

/**
 *
 * @author NguyenPH
 */
public class Utilities {
    // Tạo mã mã hàng hóa từ mã sản phẩm cuối cùng trong list
    public static String taoMaTiepTheo(String str){
        String[] arStr = str.split("V");
        String numStr = arStr[1];
        int code = Integer.parseInt(numStr);
        return layMaCuoiCung(code);
    }
    
    // tạo mã hàng hóa lớn hơn mã cuối cùng trong csdl
    public static String layMaCuoiCung(int code){
        String codeStr = "NV" + String.format("%06d", ++code);
        return codeStr;
    }
    
    public static String taoTienTuChuoi(String money){
        StringBuilder str = new StringBuilder(money);
        int idx = str.length() - 3;

        while (idx > 0){
            str.insert(idx, ".");
            idx = idx - 3;
        }
        return str.toString();
    }
    
    
    public static String boPhanSauDauCham(String money){
        return money.split("\\.")[0];
    }
    public static void main(String[] args){
       
        String str = taoTienTuChuoi(boPhanSauDauCham("10000000.0012"));
       int b = 1;
    }
}
