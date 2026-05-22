// Model data untuk informasi pembeli.
public class Pembeli02 {
    private String namaPembeli;
    private String noHp;

    // Buat objek pembeli dengan nama dan nomor HP.
    public Pembeli02(String namaPembeli, String noHp) {
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
    }

    // Kembalikan nama pembeli.
    public String getNamaPembeli() {
        return namaPembeli;
    }

    // Kembalikan nomor HP pembeli.
    public String getNoHp() {
        return noHp;
    }

    // Representasi teks singkat untuk data pembeli.
    @Override
    public String toString() {
        return namaPembeli + " | " + noHp;
    }
}
