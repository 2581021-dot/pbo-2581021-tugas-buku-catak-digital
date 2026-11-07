public class BukuDigital extends Buku {
    private double ukuranMB;


    //Meneruskan tiga data ke parent, simpan data sendiri, Baris perintah super (...) yang dihapus sementara untuk di eksperimen.

    public BukuDigital(String judul, String penulis, int harga, double ukuranMB) {
        super(judul, penulis, harga);
        this.ukuranMB = ukuranMB;
    }

    @Override
    int hargaAkhir() {
        return super.hargaAkhir() * 80 / 100;
    }


    //bagian umum dari parent dulu, lalu bagian unik. ukuranMB dicetak sebagai 12.5 apa adanya.
    // Tidak ada baris ongkir karena buku digital tidak dikirim.
    @Override
    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("  Ukuran      : " + ukuranMB + " MB");
        System.out.println("  Harga akhir : " + formatRupiah(hargaAkhir()) + " (diskon 20%)");
    }
}