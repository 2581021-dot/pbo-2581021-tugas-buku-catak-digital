public class Buku {


    //Data ini milik satu buku. Untuk "private" artinya hanya kode di dalam Buku yang bisa mengaksesnya. Untuk anak class atau Subclass tidak dapat
    //mengaksesnya kecuali subclas seperti BukuCetak, BukuDigital meminta lewat method. contohnya
    // meminta harga, dibuat dulu methodnya hargaAkhir().
    private String judul;
    private String penulis;
    private int harga;


    //constructor dijalankan saat objeck dibuat dengan new. Tugasnya adalah untuk mengisi data awal.
    //this.judul = judul . Perintah this diperlukan karena field dan parameter punya nama yang sama.
    public Buku(String judul, String penulis, int harga) {
        this.judul = judul;
        this.penulis = penulis;
        this.harga = harga;
    }


    //Method ini dibuat agar subclass dapat mengganti perhitungannya sekaligus menjadi pintu  bagi subclass untuk mengetahui harga dasar.

    public int hargaAkhir() {
        return harga;
    }

    public void tampilkanInfo() {
        System.out.println(judul + " (" + penulis + ")");
        System.out.printf("  %-12s: %s%n", "Harga", formatRupiah(harga));
    }
    //Method static dibuat karena  tidak membutuhkan data object, hanya mengubah angka menjadi teks, bisa dipanggil lewat nama class (Buku.formatRupiah(...)).
    //protected , bisa dipakai oleh subclas dan class lain dalam package yang sama termasuk (TokoBuku).
    protected static String formatRupiah(int angka) {
        return "Rp" + String.format(java.util.Locale.US, "%,d", angka).replace(',', '.');
    }
}


