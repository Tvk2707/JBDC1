/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Moder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class SinhVien {

    private int id;
    private String Ten;
    private LocalDate NgaySinh;
    private String DiaChi;

    public SinhVien() {
    }

    public SinhVien(int id, String Ten, LocalDate NgaySinh, String DiaChi) {
        this.id = id;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(LocalDate NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void xuat() {
        System.out.println("Id: " + id
                + "Ten :" + Ten
                + "Ngay Sinh : " + NgaySinh
                + "Dia chi :" + DiaChi);
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi nhap Ten:");
        this.Ten = sc.nextLine();
        System.out.println("Moi nhap dia chi :");
        this.DiaChi = sc.nextLine();

        while (true) {
            try {
                System.out.println("Moi nhap ngay sinh yyyy-MM-dd :");
                String input = sc.nextLine();
                DateTimeFormatter sv = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                this.NgaySinh = LocalDate.parse(input, sv);
                break;
            } catch (Exception e) {
                System.out.println("Ngay sai dinh dang");
            }
        }

    }

}
