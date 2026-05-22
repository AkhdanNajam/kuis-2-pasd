// Kelas untuk mengelola daftar pesanan dalam struktur linked list tunggal.
public class PesananList02 {
    private PesananNode02 head;
    private PesananNode02 tail;

    // Cek apakah daftar pesanan kosong.
    public boolean isEmpty() {
        return head == null;
    }

    // Tambahkan pesanan baru ke akhir daftar.
    // Jika daftar masih kosong, node baru menjadi head dan tail.
    // Jika sudah berisi, node baru dihubungkan setelah tail.
    public void addPesanan(Pesanan02 pesanan) {
        PesananNode02 node = new PesananNode02(pesanan);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    // Hitung jumlah node pesanan dengan menelusuri semua item.
    public int size() {
        int count = 0;
        PesananNode02 current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Ubah daftar linked list menjadi array, kemudian urutkan array berdasarkan nama pesanan.
    public Pesanan02[] toArraySortedByNama() {
        int size = size();
        Pesanan02[] array = new Pesanan02[size];
        PesananNode02 current = head;
        int index = 0;

        // Salin semua pesanan dari linked list ke array.
        while (current != null) {
            array[index++] = current.pesanan;
            current = current.next;
        }

        // Urutkan array menggunakan perbandingan nama pesanan.
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].getNamaPesanan().compareToIgnoreCase(array[j].getNamaPesanan()) > 0) {
                    Pesanan02 temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

    // Cetak laporan pesanan dengan format tabel setelah mengurutkan nama pesanan.
    public void printReport() {
        if (isEmpty()) {
            System.out.println("Laporan pesanan kosong.");
            return;
        }

        Pesanan02[] sorted = toArraySortedByNama();
        System.out.println("================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("================================");
        System.out.printf("%-12s %-20s %-10s%n", "Kode Pesanan", "Nama Pesanan", "Harga");

        // Cetak setiap pesanan yang sudah diurutkan.
        for (Pesanan02 pesanan : sorted) {
            System.out.printf("%-12d %-20s %-10d%n", pesanan.getKodePesanan(), pesanan.getNamaPesanan(), pesanan.getHarga());
        }
    }

    // Cari pesanan berdasarkan kode pesanan di linked list.
    public Pesanan02 searchPesananByKode(int kodePesanan) {
        PesananNode02 current = head;
        while (current != null) {
            if (current.pesanan.getKodePesanan() == kodePesanan) {
                return current.pesanan;
            }
            current = current.next;
        }
        return null;
    }
}
