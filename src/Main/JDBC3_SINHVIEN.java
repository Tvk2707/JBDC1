/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Moder.SinhVien;
import java.util.ArrayList;
import java.util.Scanner;
import repository.RepoSinhVien;

/**
 *
 * @author Admin
 */
public class JDBC3_SINHVIEN {

    /**
     * @param args the command line arguments
     */
    static RepoSinhVien Reposv  = new RepoSinhVien();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        int chon;
        do {

            System.out.println("1. Load ds");
            System.out.println("2. them");
            System.out.println("3. sua");
            System.out.println("4. xoa");
            System.out.println("5. tim kiem");
            System.out.println("6. sap xep");
            System.out.println("0. thoat");
            System.out.println("-----------------");
            System.out.println("moi chon menu:");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    LoadDL();

                    break;
                       case 2 :
                           ThemDL();
                           break;

                case 0:
                    break;
                default:
                    System.out.println("ban chon sai chon menu:");
            }
        } while (chon != 0);
    }

    public static void LoadDL() {
        ArrayList<SinhVien> ListU = Reposv.getAll();
        System.out.println("Ds");
        for (SinhVien s : ListU) {
            s.xuat();

        }

    }
    
    public static void ThemDL(){
     SinhVien s = new SinhVien();
     s.nhap();
     if(Reposv.AddSinhVien(s)){
         System.out.println("Them thành công!");
         
     }else{
         System.out.println("them thát bại !");
     }
    }
}
