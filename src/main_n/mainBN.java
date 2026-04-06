/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_n;
//import main.*;

import java.util.ArrayList;
import java.util.Scanner;
import moded.BenhNhan;
import repository.repoBenhNhan;

/**
 *
 * @author Admin
 */
public class mainBN {

    static repoBenhNhan repoU = new repoBenhNhan();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int chon;
        do {

            System.out.println("1. Load ds");
            System.out.println("2. tim theo dia chi:");
            System.out.println("3. săp xếp");
            System.out.println("4. sua");
            System.out.println("5. tim kiem");
            System.out.println("6. sap xep");
            System.out.println("0. thoat");
            System.out.println("-----------------");
            System.out.println("moi chon menu:");
            chon = Integer.parseInt(scan.nextLine());// chong choi
            switch (chon) {
                case 1:
                    Load();
                    break;
                case 2:
                    timTheoDiaChi();
                    break;
                case 3:
                    sapXepTheoNgaySinh();
                    break;
                case 4:
                    suaBenhNhan();
                    break;

                case 0:
                    break;
                default:
                    System.out.println("ban chon sai chon menu:");
            }
        } while (chon != 0);// chon 0 thi thoat
    }

    public static void Load() {
        ArrayList<BenhNhan> list = repoU.getAll();
        System.out.println("DS");
        for (BenhNhan u : list) {
            u.xuat();
        }

    }

    public static void timTheoDiaChi() {
        System.out.println("Mời nhập địa chỉ cần tìm:");
        String dc = scan.nextLine();
        if(repoU.findByDiaChi(dc) != null) {
            System.out.println("DS tìm kiếm :");
            ArrayList<BenhNhan> List = repoU.findByDiaChi(dc);
            for (BenhNhan b : List) {
                b.xuat();
            }
        } else {
            System.out.println("k có địa chỉ nào tìm đươc");
        }

    }

    public static void sapXepTheoNgaySinh() {
        if (repoU.sortByNgaySinh() != null) {
            System.out.println("DS sau sắp xêp:");
            ArrayList<BenhNhan> list = repoU.sortByNgaySinh();
            for (BenhNhan b : list) {
                b.xuat();
            }

        }

    }

    public static void suaBenhNhan() {
        // b1: tim benh nhan can sua
        // b2: tim duoc thi : nhap thong tin moi -> sua
        System.out.println("moi nhap id benh nhan can sua: ");
        int id = Integer.parseInt(scan.nextLine());
        BenhNhan b = repoU.findById(id);
        if (b != null) {// co tim thay => sua
            b.nhap();

        } else {
            System.out.println("khong tim thay");
        }
        if (repoU.updateBenhNhan(b)) {// true
            System.out.println("sua thanh cong: ");
            System.out.println("ds sau update: ");
            Load();
        } else {
            System.out.println("update that bai");
        }
    }

}


