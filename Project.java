/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package Inventaris;

import java.util.Scanner;

/**
 *
 * @author gokpraz
 */

public class Project {

   public static String barang[] = new String[10]; // jumlah barang dimasukkan maksimal 10
   public static int stokBarang[] = new int[10]; // jumlah stok barang dimasukkan maksimal 10
   
   public static String barangMasuk[] = new String[10]; // menampung barang masuk yang diinputkan
   public static int stokBarangMasuk[] = new int[10]; // jumlah stok barang masuk dimasukkan maksimal 10
   
   public static String barangKeluar[] = new String[10]; // menampung barang keluar yang diinputkan
   public static int stokBarangKeluar[] = new int[10]; // jumlah stok barang keluar dimasukkan maksimal 10

   public static String barangRusak[] = new String[10]; // menampung barang rusak diinputkan
   public static int stokBarangRusak[] = new int[10]; // jumlah stok barang rusak dimasukkan maksimal 10
   
   public static int indexBarang = 0, indexBarangMasuk = 0, indexBarangKeluar = 0, indexBarangRusak = 0; // ini digunakan untuk menentukan letak index barang ketika ditambahkan
   
   public static void main(String[] args) {
      Scanner scInt = new Scanner(System.in);
      Scanner scString = new Scanner(System.in);
      
      String lanjut, inputBarang, inputPencarianBarang, inputBarangMasuk, inputBarangKeluar, inputBarangRusak;
      int pilihMenu, inputStok, inputStokBarangMasuk, inputStokBarangKeluar, inputStokBarangRusak;

      do {
         menu();
         System.out.print("Pilih menu berdasarkan nomer > ");
         pilihMenu = scInt.nextInt();

         switch (pilihMenu) { // memilih menu sesuai dengan inputan
            
            case 1: // jika memilih menu 1 [ Input Barang ]
               System.out.println("[ Input Barang ]\n");
               
               System.out.print("Masukan nama barang > ");
               inputBarang = scString.nextLine();
               
               System.out.print("Masukan Stok Barang > ");
               inputStok = scInt.nextInt();
               
               inputDataBarang(inputBarang, inputStok); // memanggil fungsi inputDataBarang() dan mengisi parameternya yang berupa "inputBarang" dan "inputStok"
               break;
               
            case 2: // jika memilih menu 2 [ Tampilkan Barang ]
               System.out.println("[ Tampilkan Barang ]\n");

               tampilkanBarang(); // memanggil fungsi untuk menampilkan barang
               break;

            case 3: // jika memilih menu 3 [ Cari Barang ]
               System.out.println("[ Cari Barang ]\n");

               System.out.print("Masukan nama barang > ");
               inputPencarianBarang = scString.nextLine();
               
               cariBarang(inputPencarianBarang); // memanggil fungsi cariBarang() untuk pencarian barang yang berada di barang
               break;

            case 4: // jika memilih menu 4 [ Laporan Barang ]
               System.out.println("[ Laporan Barang ]\n");

               laporanBarang(); // memanggil fungsi untuk menampilkan barang, barang masuk, barang keluar, dan barang rusak
               break;

            case 5: // jika memilih menu 5 [ Barang Masuk ]
               System.out.println("[ Barang Masuk ]\n");

               System.out.println("Daftar Barang : ");
               tampilkanBarang();
               
               System.out.print("\nMasukan nama barang masuk > ");
               inputBarangMasuk = scString.nextLine();
               
               System.out.print("Masukan stok barang masuk > ");
               inputStokBarangMasuk = scInt.nextInt();
               
               inputBarangMasuk(inputBarangMasuk, inputStokBarangMasuk); // memanggil fungsi inputBarangMasuk() untuk memasukan data ke dalam array barangMasuk[]
               break;

            case 6: // jika memilih menu 6 [ Barang Keluar ]
               System.out.println("[ Barang Keluar ]\n");

               System.out.println("Daftar Barang : ");
               tampilkanBarang();
               
               System.out.print("\nMasukan nama Barang Keluar sesuai daftar barang > ");
               inputBarangKeluar = scString.nextLine();
               
               System.out.print("Masukan stok barang Keluar sesuai daftar barang > ");
               inputStokBarangKeluar = scInt.nextInt();
               
               inputBarangKeluar(inputBarangKeluar, inputStokBarangKeluar); // memanggil fungsi inputBarangKeluar() untuk memasukan data ke dalam array barangKeluar[]
               break;

            case 7: // jika memilih menu 7 [ Barang Rusak ]
               System.out.println("[ Barang Rusak ]\n");

               System.out.println("Daftar Barang : ");
               tampilkanBarang();
               
               System.out.print("\nMasukan nama Barang Rusak sesuai daftar barang > ");
               inputBarangRusak = scString.nextLine();
               
               System.out.print("Masukan stok barang Rusak sesuai daftar barang > ");
               inputStokBarangRusak = scInt.nextInt();
               
               inputBarangRusak(inputBarangRusak, inputStokBarangRusak); // memanggil fungsi inputBarangRusak() untuk memasukan data ke dalam array barangRusak[]
               break;

            case 8: // jika memilih menu 8 [ Keluar ]
               keluar(); // memanggil method/fungsi keluar()
               System.exit(0); // keluar program
               break;
         }
         
         System.out.print("\nKlik [ ENTER ] untuk mengulangi, ketik [ EXIT ] untuk keluar program . . .");
         lanjut = scString.nextLine();
      
         if (lanjut.equalsIgnoreCase("exit")) { // jika pengguna mengetik kata exit
            keluar(); // memanggil fungsi keluar()
         }
         
         System.out.println("\n\n");
      } while (lanjut.equals("")); // jika pengguna menekan tombol ENTER
   
   }

   public static void inputDataBarang(String namaBarang, int stok) // method/fungsi yang berfungsi untuk menginputkan barang
   {
      barang[indexBarang] = namaBarang; // memasukan data ke dalam array barang[]
      stokBarang[indexBarang] = stok; // memasukan data ke array stokBarang[]
      indexBarang++; // menambahkan nilai 1 pada variabel indexBarang
   }
   
   public static void tampilkanBarang() // method/fungsi yang berfungsi untuk menampilkan barang
   {
      System.out.println("NO|\tBarang\t| Stok");
      for (int i = 0; i < (indexBarang); i++) {
         System.out.println((i + 1) + ".\t" + barang[i] + "\t   " + stokBarang[i]);
      }
      
      System.out.println("Jumlah barang : " + indexBarang + " buah"); // menampilkan data jumlah barang yang dimasukan ke array
   }
   
   public static void cariBarang(String namaBarang) // method/fungsi yang berfungsi untuk pencarian data barang
   {
      boolean status = false;
      
      for (int i = 0; i < indexBarang; i++) {
         if (barang[i].equalsIgnoreCase(namaBarang)) { // jika barang ditemukan
            status = true;
            
            System.out.println("Barang ditemukan . . .");

            System.out.println("Nama Barang : " + barang[i]);
            System.out.println("Jumlah Stok : " + stokBarang[i]);            
            break;
         }
      }
      
      if (!status) { // jika barang tidak ditemukan
         System.out.println("Barang [" + namaBarang + "] tidak ditemukan . . .");
      }
   }
   
   public static void inputBarangMasuk(String namaBarang, int stok) // method/fungsi yang berfungsi untuk input data barang masuk
   {
      boolean status = false;
      
      // Menambahkan stok barang ketika diinputkan barang masuk
      for (int i = 0; i < indexBarang; i++) {
         if (barang[i].equalsIgnoreCase(namaBarang)) { // jika barang ditemukan
            status = true;
            stokBarang[i] = stokBarang[i] + stok;
         }
      }
      
      if (status) { // jika statusnya ditemukan
         barangMasuk[indexBarangMasuk] = namaBarang; // Memasukan data ke dalam array barangMasuk[]
         stokBarangMasuk[indexBarangMasuk] = stok; // Memasukan data ke dalam array stokBarangMasuk[]
         indexBarangMasuk++; // menambahkan nilai 1 ke variabel indexBarangMasuk
         System.out.println("Input barang masuk sukses . . .");
      
      } else { // jika statusnya tidak ditemukan
         System.out.println("Barang tidak ditemukan . . .");
      }
      
   }

   public static void inputBarangKeluar(String namaBarang, int stok) // method/fungsi yang berfungsi untuk input data barang keluar
   {
      boolean status = false;
      
      // Menambahkan stok barang ketika diinputkan barang masuk
      for (int i = 0; i < indexBarang; i++) {
         if (barang[i].equalsIgnoreCase(namaBarang)) { // jika barang ditemukan
            status = true;
            stokBarang[i] = stokBarang[i] - stok;
         }
      }
      
      if (status) { // jika statusnya ditemukan
         barangKeluar[indexBarangKeluar] = namaBarang; // Memasukan data ke dalam array barangKeluar[]
         stokBarangKeluar[indexBarangKeluar] = stok; // Memasukan data ke dalam array stokBarangKeluar[]
         indexBarangKeluar++; // menambahkan nilai 1 ke variabel indexBarangKeluar
         System.out.println("Input barang keluar sukses . . .");
         
      } else { // jika statusnya tidak ditemukan
         System.out.println("Barang tidak ditemukan . . .");
      }
      
   }
   
   public static void inputBarangRusak(String namaBarang, int stok) // method/fungsi yang berfungsi untuk input data barang rusak
   {
      boolean status = false;
      
      // Menambahkan stok barang ketika diinputkan barang masuk
      for (int i = 0; i < indexBarang; i++) {
         if (barang[i].equalsIgnoreCase(namaBarang)) { // jika barang ditemukan
            status = true;
            stokBarang[i] = stokBarang[i] - stok;
         }
      }
      
      if (status) { // jika statusnya ditemukan
         barangRusak[indexBarangRusak] = namaBarang; // Memasukan data ke dalam array barangRusak[]
         stokBarangRusak[indexBarangRusak] = stok; // Memasukan data ke dalam array stokBarangRusak[]
         indexBarangRusak++; // menambahkan nilai 1 ke variabel indexBarangRusak
         System.out.println("Input barang rusak sukses . . .");
         
      } else {
         System.out.println("Barang tidak ditemuan . . .");
      }
      
   }
   
   public static void laporanBarang() // method/fungsi yang berfungsi untuk menampilkan laporan
   {
      System.out.println("Daftar Barang : ");
      tampilkanBarang();
      
      System.out.println("\nData Barang Masuk : ");
      tampilkanBarangMasuk();
      
      System.out.println("\nData Barang Keluar : ");
      tampilkanBarangKeluar();
      
      System.out.println("\nData Barang Rusak : ");
      tampilkanBarangRusak();
      
   }
   
   public static void tampilkanBarangMasuk() // method/fungsi yang berfungsi untuk menampilkan barang masuk
   {
      System.out.println("NO|\tBarang\t| Stok");
      for (int i = 0; i < (indexBarangMasuk); i++) {
         System.out.println((i + 1) + ".\t" + barangMasuk[i] + "\t   " + stokBarangMasuk[i]);
      }
      
      System.out.println("Jumlah barang masuk : " + indexBarangMasuk + " buah"); // menampilkan jumlah barang masuk
   }
   
   public static void tampilkanBarangKeluar() // method/fungsi yang berfungsi untuk menampilkan barang keluar
   {
      System.out.println("NO|\tBarang\t| Stok");
      for (int i = 0; i < (indexBarangKeluar); i++) {
         System.out.println((i + 1) + ".\t" + barangKeluar[i] + "\t   " + stokBarangKeluar[i]);
      }
      
      System.out.println("Jumlah barang keluar : " + indexBarangKeluar + " buah"); // menampilkan jumlah barang keluar
   }
   
   public static void tampilkanBarangRusak() // method/fungsi yang berfungsi untuk menampilkan barang rusak
   {
      System.out.println("NO|\tBarang\t| Stok");
      for (int i = 0; i < (indexBarangRusak); i++) {
         System.out.println((i + 1) + ".\t" + barangRusak[i] + "\t   " + stokBarangRusak[i]);
      }
      
      System.out.println("Jumlah barang rusak : " + indexBarangRusak + " buah"); // menampilkan jumlah barang rusak
   }
   
   public static void menu() // Daftar menu 
   { 
      System.out.println("=============================");
      System.out.println("========= INVENTORY =========");
      System.out.println("=============================");
      System.out.println("Daftar Menu : ");
      System.out.println("1. Input Barang");
      System.out.println("2. Tampilkan Barang");
      System.out.println("3. Cari Barang");
      System.out.println("4. Laporan Barang");
      System.out.println("5. Barang Masuk");
      System.out.println("6. Barang Keluar");
      System.out.println("7. Barang Rusak");
      System.out.println("8. Keluar \n");
   }
   
   public static void keluar() // menampilkan kata terima kasih
   { 
      System.out.println("\n\n");
      System.out.println("==================================================================================\n");
      System.out.println(" ######## #### #####   ##  ###    ###  ####      ##   ##  ####  ###### ## ##  ## ");
      System.out.println("    ##    ##   ##  ##  ##  ## #  # ## ##  ##     ## ##   ##  ## ##     ## ##  ## ");
      System.out.println("    ##    #### ## ##   ##  ##  ##  ## ##  ##     ###     ##  ## ###### ## ###### ");
      System.out.println("    ##    ##   ##  ##  ##  ##      ## ######     ## ##   ######     ## ## ##  ## ");
      System.out.println("    ##    #### ##   ## ##  ##      ## ##  ##     ##   ## ##  ## ###### ## ##  ## \n");
      System.out.println("==================================================================================");
      System.out.println("\n\n");
   }

}
