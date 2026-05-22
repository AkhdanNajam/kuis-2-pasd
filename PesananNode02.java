// Node untuk menyimpan data satu pesanan di daftar pesanan.
public class PesananNode02 {
    Pesanan02 pesanan;
    PesananNode02 next;

    // Buat node baru untuk satu item pesanan dalam list.
    public PesananNode02(Pesanan02 pesanan) {
        this.pesanan = pesanan;
        this.next = null;
    }
}
