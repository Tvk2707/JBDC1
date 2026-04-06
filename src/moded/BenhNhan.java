/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moded;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BenhNhan {

    private int id;
    private String Ma;
    private LocalDate Ngay;
    private int byt;
    private String Diachi;

    public BenhNhan() {
    }

    public BenhNhan(int id, String Ma, LocalDate Ngay, int byt, String Diachi) {
        this.id = id;
        this.Ma = Ma;
        this.Ngay = Ngay;
        this.byt = byt;
        this.Diachi = Diachi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public LocalDate getNgay() {
        return Ngay;
    }

    public void setNgay(LocalDate Ngay) {
        this.Ngay = Ngay;
    }

    public int getByt() {
        return byt;
    }

    public void setByt(int byt) {
        this.byt = byt;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    @Override
    public String toString() {
        return "BenhNhan{" + "id=" + id + ", Ma=" + Ma + ", Ngay=" + Ngay + ", byt=" + byt + ", Diachi=" + Diachi + '}';
    }

    public void nhap() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Mã bệnh nhân:");
        this.Ma = scan.nextLine();
        System.out.println("Dịa trỉ:");
        this.Diachi = scan.nextLine();
        while (true) {
            try {
                System.out.println("Moiwg nhập Ngày sinh:(yyyy-MM-dd) ");
                String input;
                input = scan.nextLine();
                DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                this.Ngay = LocalDate.parse(input, fm);
                break;
            } catch (Exception e) {
                System.out.println("Ngày sai định dạng");
            }

        }
        // nhập nhóm máu
        while (true) {
            try {
                 byt=Integer.parseInt(scan.nextLine()); 
        if(byt==1 || byt==2 || byt==3 || byt==4) break;

            } catch (Exception e) {
                System.out.println("Nhóm máu ko phải số :");
            }
        }
    }
      public void xuat() {
        System.out.println("id:" + id
                + "ma:" + Ma
                + "Ngay " + Ngay
                + "nhom Mau:" + byt
                + "dia chi:" + Diachi);
    }
}
