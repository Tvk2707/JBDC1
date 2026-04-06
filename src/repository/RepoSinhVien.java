/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Moder.SinhVien;
import Until.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class RepoSinhVien {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public RepoSinhVien() {
        con = DBConnect.getConnection();
    }

    // lay het du lieu getAll 
    public ArrayList<SinhVien> getAll() {
        ArrayList<SinhVien> sv = new ArrayList<>();
        sql = " select  id ,ho_ten,ngay_sinh,dia_chi from sinh_vien";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String b, d;
                int a;
                LocalDate c;
                a = rs.getInt(1);
                b = rs.getString(2);
                c = LocalDate.parse(rs.getString(3));
                d = rs.getString(4);
                sv.add(new SinhVien(a, b, c, d));

            }
            return sv;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    // them du lieu 
    public boolean AddSinhVien(SinhVien sv) {
        sql = " insert into sinh_vien(ho_ten,ngay_sinh,dia_chi)  values(?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, sv.getTen());
            ps.setObject(2, sv.getNgaySinh());
            ps.setObject(3, sv.getDiaChi());
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    // tìm kiếm
    public SinhVien FrindbySinhVien(int sv) {
        sql = " select id, ho_ten,ngay_sinh,dia_chi from sinh_vien\n"
                + "where id = ?";
        SinhVien a = new SinhVien();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, sv);
            rs = ps.executeQuery();
            if (rs.next()) {
                int q;
                String b, d;
                LocalDate c;
                q = rs.getInt(1);
                a.setId(q);
                b = rs.getString(2);
                a.setTen(b);
                c = LocalDate.parse(rs.getString(3));
                a.setNgaySinh(c);
                d = rs.getString(4);
                a.setDiaChi(d);
            }
            return a;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
