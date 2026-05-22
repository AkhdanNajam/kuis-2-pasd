// Kelas untuk mengelola antrean pembeli dengan linked list ganda.
public class AntrianList02 {
    private AntrianNode02 head;
    private AntrianNode02 tail;
    private int nextNomor = 1;

    // Cek apakah antrean kosong.
    public boolean isEmpty() {
        return head == null;
    }

    // Tambahkan pembeli baru ke akhir antrean dan kembalikan nomor antrean.
    public int addAntrian(Pembeli02 pembeli) {
        int nomor = nextNomor++;
        AntrianNode02 node = new AntrianNode02(nomor, pembeli);

        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        return nomor;
    }

    // Hapus pembeli dari antrean berdasarkan nomor antrean.
    public Pembeli02 removeByNomor(int nomor) {
        AntrianNode02 current = head;

        while (current != null) {
            if (current.nomorAntrian == nomor) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return current.pembeli;
            }
            current = current.next;
        }

        return null;
    }

    // Cetak semua pembeli yang sedang antrekan saat ini.
    public void printAntrian() {
        if (isEmpty()) {
            System.out.println("Daftar antrean kosong.");
            return;
        }

        System.out.println("================================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("================================");
        System.out.printf("%-10s %-20s %-15s%n", "No Antrian", "Nama", "No HP");

        AntrianNode02 current = head;
        while (current != null) {
            System.out.printf("%-10d %-20s %-15s%n", current.nomorAntrian, current.pembeli.getNamaPembeli(), current.pembeli.getNoHp());
            current = current.next;
        }
    }

    // Hitung jumlah pembeli yang ada di antrean saat ini.
    public int size() {
        int count = 0;
        AntrianNode02 current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
