//kata extends yang berarti CetakBuku mewarisi Buku. atau bisa dibilang seluruh isii buku dimiliki oleh BukuCetak.
//seperti jjudul, penulis, atau harga.
//Data yang hanya dimiliki buku cetak. Buku digital tidak punya berat, makanya field ini tidak ditaruh di Buku.

public class BukuCetak extends Buku {
    private int beratGram;

    //super(...) memanggil constructor Buku untuk mengisi judul, penulis, dan harga
    //Bagian dari parent harus terbentuk dulu sebelum bagian milik anak (subclass) diisi.
    public BukuCetak(String judul, String penulis, int harga, int beratGram) {
        super(judul, penulis, harga);
        this.beratGram = beratGram;
    }

    //menghitung ongkir dnegan hitungan pembulatan.
    public int hitungOngkir() {
        int jumlahBlok = (beratGram + 499) / 500;
        return jumlahBlok * 5000;
    }


    //Method ini menggantikan hargaAkhir() milik Buku.
    // Karena harga private, kita tidak bisa menulis harga + hitungOngkir().
    // Sebagai gantinya, super.hargaAkhir() berarti “tolong jalankan versi milik parent”, yang mengembalikan harga dasar (120.000).
    // Lalu ditambah ongkir (10.000) menjadi 130.000.

    //jika perintah super. dihilangkan, hargaAkhir() memanggil dirinya sendiri tanpa henti dan program berhenti dengan StackOverflowError.

    @Override
    public int hargaAkhir() {
        return super.hargaAkhir() + hitungOngkir();
    }



    //super.tampilkanInfo() dipanggil lebih dulu supaya dua baris pertama (judul dan harga) dicetak oleh Buku.
    // Sesudah itu BukuCetak menambahkan tiga baris miliknya( Berat, Ongkir, Harga akhir).
    // %d untuk angka bulat (berat), dan %s untuk teks hasil formatRupiah.

    //override digunakan untuk mengganti atau menyesuaikan perilaku yang ada di superclass atau yang ada di parent
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("  %-12s: %d gram%n", "Berat", beratGram);
        System.out.printf("  %-12s: %s%n", "Ongkir", formatRupiah(hitungOngkir()));
        System.out.printf("  %-12s: %s%n", "Harga akhir", formatRupiah(hargaAkhir()));
    }
}