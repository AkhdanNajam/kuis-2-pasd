// Model data untuk informasi pesanan pelanggan.
public class Pesanan02 {
    private int kodePesanan;
    private String namaPesanan;
    private int harga;

    // Buat objek pesanan dengan kode, nama, dan harga.
    public Pesanan02(int kodePesanan, String namaPesanan, int harga) {
        this.kodePesanan = kodePesanan;
        this.namaPesanan = namaPesanan;
        this.harga = harga;
    }

    // Kembalikan kode pesanan.
    public int getKodePesanan() {
        return kodePesanan;
    }

    // Kembalikan nama pesanan.
    public String getNamaPesanan() {
        return namaPesanan;
    }

    // Kembalikan harga pesanan.
    public int getHarga() {
        return harga;
    }

    // Representasi teks singkat untuk data pesanan.
    @Override
    public String toString() {
        return kodePesanan + " | " + namaPesanan + " | " + harga;
    }
}
