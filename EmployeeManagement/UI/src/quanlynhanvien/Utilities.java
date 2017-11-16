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
}
