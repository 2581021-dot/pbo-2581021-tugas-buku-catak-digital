import java.util.Scanner;
public class TokoBuku {
    public static void main(String[] args) {
        Buku[] keranjang = {
                new BukuCetak("Pemrograman Java", "John Doe", 120000, 750),
                new BukuCetak("Algoritma Dasar", "Jane Smith", 95000, 400),
                new BukuDigital("Belajar OOP", "Ani Wijaya", 80000, 12.5)
        };


        //for-each: b berganti menjadi tiap elemen array.
        // Walaupun b bertipe Buku, Java memeriksa objek aslinya saat program berjalan.
        // Saat b adalah BukuCetak, yang dijalankan versi BukuCetak; saat BukuDigital, versi BukuDigital.
        System.out.println("=============== KERANJANG ===============");
        int total = 0;
        for (Buku b : keranjang) {
            b.tampilkanInfo();
            total += b.hargaAkhir();
        }
        System.out.println("-----------------------------------------");
        System.out.println("Total bayar   : " + Buku.formatRupiah(total));



        //
        // EKSPERIMEN: baris super(...) di constructor BukuDigital dihapus sementara.
        // Pesan error dari IntelliJ:
        // java: constructor Buku in class Buku cannot be applied to given types;
        //   required: java.lang.String,java.lang.String,int
        //   found:    no arguments
        //   reason:   actual and formal argument lists differ in length
        // Penyebab: tanpa super(...), Java menyisipkan super() otomatis, padahal
        // Buku tidak punya constructor tanpa parameter.

    }
}

//java: constructor Buku in class Buku cannot be applied to given types;
//  required: java.lang.String,java.lang.String,int
//  found:    no arguments
//  reason: actual and formal argument lists differ in length

//java: hargaAkhir() in BukuDigital cannot override hargaAkhir() in Buku
//  attempting to assign weaker access privileges; was public

//java: tampilkanInfo() in BukuDigital cannot override tampilkanInfo() in Buku
//  attempting to assign weaker access privileges; was public