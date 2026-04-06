/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.time.LocalDate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import moded.BenhNhan;
import until.DBConnect;

/**
 *
 * @author Admin
 */
public class repoBenhNhan {

    private Connection con = null;

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public repoBenhNhan() {
        con = DBConnect.getConnection();
    }

    public ArrayList<BenhNhan> getAll() {
        ArrayList<BenhNhan> ListU = new ArrayList<>();
        sql = "select id,mabenhnhan ,nhommau ,diachi ,ngaysinh  from benhnhan";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int a, c;
                String b, d;
                LocalDate e;
                a = rs.getInt(1);
                c = rs.getInt(3);
                b = rs.getString(2);
                d = rs.getString(4);
                e = LocalDate.parse(rs.getString(5));
                ListU.add(new BenhNhan(a, b, e, c, d));

            }
            return ListU;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<BenhNhan> findByDiaChi(String diaChitim) {
        ArrayList<BenhNhan> ListU = new ArrayList<>();
        sql = "select id,mabenhnhan,ngaysinh,nhommau,diachi from benhnhan where diachi like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, '%' + diaChitim + '%');
            rs = ps.executeQuery();
            while (rs.next()) {
                int a, c;
                String b, d;
                LocalDate e;
                a = rs.getInt(1);
                c = rs.getInt(4);
                b = rs.getString(2);
                d = rs.getString(5);
                e = LocalDate.parse(rs.getString(3));
                ListU.add(new BenhNhan(a, b, e, c, d));

            }
            return ListU;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<BenhNhan> sortByNgaySinh() {
        ArrayList<BenhNhan> ListU = new ArrayList<>();
        sql = "select id,mabenhnhan,ngaysinh,nhommau,diachi from benhnhan order by ngaysinh desc";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int a, c;
                String b, d;
                LocalDate e;
                a = rs.getInt(1);
                c = rs.getInt(4);
                b = rs.getString(2);
                d = rs.getString(5);
                e = LocalDate.parse(rs.getString(3));
                ListU.add(new BenhNhan(a, b, e, c, d));

            }
            return ListU;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateBenhNhan(BenhNhan nb_sua) {
        sql = "update benhnhan set mabenhnhan=?, diachi=?, ngaysinh=?, nhommau=? where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, nb_sua.getMa());
            ps.setObject(3, nb_sua.getNgay());
            ps.setObject(4, nb_sua.getByt());
            ps.setObject(2, nb_sua.getDiachi());
            ps.setInt(5, nb_sua.getId());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace(); 
            return false;
        }

    }
    public BenhNhan findById(int id_tim){
     sql="select id,mabenhnhan,ngaysinh,nhommau,diachi from\n" +
"benhnhan where id=?";
      BenhNhan bn = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_tim);
            rs = ps.executeQuery();// select
          if (rs.next()) {
                int id;
                String ma, dc;
                LocalDate ns;
                int nm;
                id = rs.getInt(1);
                
                ma = rs.getString(2);
                dc = rs.getString(5);
               
                ns = LocalDate.parse(rs.getString(3));
                nm=rs.getInt(4);
                bn=new BenhNhan(id, ma, ns,nm,dc);
            }// close while
            return bn;
        } catch (Exception e) {// k lay dl
            System.out.println("k lay duoc dl tu sql");
            return null;
        }  
 }

}
