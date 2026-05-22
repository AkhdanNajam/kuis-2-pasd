// Node untuk menyimpan data satu pembeli di antrean.
public class AntrianNode02 {
    int nomorAntrian;
    Pembeli02 pembeli;
    AntrianNode02 prev;
    AntrianNode02 next;

    // Buat node baru untuk satu pembeli dalam antrean.
    public AntrianNode02(int nomorAntrian, Pembeli02 pembeli) {
        this.nomorAntrian = nomorAntrian;
        this.pembeli = pembeli;
        this.prev = null;
        this.next = null;
    }
}
