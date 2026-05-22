import java.util.Scanner;

// Program utama untuk menjalankan sistem antrean dan pencatatan pesanan Royal Delish.
public class RoyalDelishApp02 {
    private static Scanner scanner = new Scanner(System.in);
    private static AntrianList02 antrianList = new AntrianList02();
    private static PesananList02 pesananList = new PesananList02();

    // Program yang menampilkan menu utama dan memproses pilihan pengguna.
    public static void main(String[] args) {
        initDummyAntrian();

        int pilihan;
        do {
            printMenu();
            pilihan = inputInt("Pilih menu : ");
            switch (pilihan) {
                case 1:
                    // Pilihan 1: tambah pembeli ke antrean.
                    tambahAntrian();
                    break;
                case 2:
                    // Pilihan 2: tampilkan semua pembeli yang sedang antre.
                    cetakAntrian();
                    break;
                case 3:
                    // Pilihan 3: panggil nomor antrean dan catat pesanan pelanggan.
                    hapusAntrianDanPesan();
                    break;
                case 4:
                    // Pilihan 4: cetak laporan semua pesanan yang sudah dicatat.
                    laporanPesanan();
                    break;
                case 5:
                    // Pilihan 5: cari pesanan berdasarkan kode.
                    cariPesanan();
                    break;
                case 0:
                    // Pilihan 0: keluar dari aplikasi.
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    // Input selain 0-5 dianggap tidak valid.
                    System.out.println("Menu tidak valid. Silakan pilih lagi.");
            }
            System.out.println();
        } while (pilihan != 0);
    }

    // Tambahkan data pembeli dummy ke antrean saat program dimulai.
    private static void initDummyAntrian() {
        antrianList.addAntrian(new Pembeli02("Najam", "081234567890"));
        antrianList.addAntrian(new Pembeli02("Wildan", "082345678901"));
        antrianList.addAntrian(new Pembeli02("Rafi", "083456789012"));
        antrianList.addAntrian(new Pembeli02("Nayaka", "084567890123"));
    }

    // Tampilkan pilihan menu pengguna.
    private static void printMenu() {
        System.out.println("SISTEM ANTRIAN ROYAL DELISH");
        System.out.println("================================");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Cetak Antrian");
        System.out.println("3. Hapus Antrian dan Pesan");
        System.out.println("4. Laporan Pesanan");
        System.out.println("5. Cari Pesanan berdasarkan Kode");
        System.out.println("0. Keluar");
    }

    // Proses input data pembeli baru dan tambahkan ke antrean.
    private static void tambahAntrian() {
        System.out.println("================================");
        System.out.println("Tambah Antrian");

        // Ambil data pembeli dari pengguna.
        String namaPembeli = inputString("Nama Pembeli : ");
        String noHp = inputString("No HP        : ");

        // Buat objek pembeli dan masukkan ke antrian.
        Pembeli02 pembeli = new Pembeli02(namaPembeli, noHp);
        int nomor = antrianList.addAntrian(pembeli);

        System.out.println("Antrian berhasil ditambahkan dengan nomor: " + nomor);
    }

    // Cetak daftar antrean saat ini.
    private static void cetakAntrian() {
        System.out.println("================================");
        System.out.println("Cetak Antrian");
        antrianList.printAntrian();
    }

    // Proses panggilan antrean, hapus dari antrean, lalu tambahkan pesanan.
    private static void hapusAntrianDanPesan() {
        System.out.println("================================");
        System.out.println("Hapus Antrian dan Pesan");

        // Pastikan masih ada antrean sebelum melanjutkan.
        if (antrianList.isEmpty()) {
            System.out.println("Tidak ada antrean untuk diproses.");
            return;
        }

        // Minta nomor antrean yang dipanggil.
        int nomor = inputInt("Masukkan No Antrian yang dipanggil: ");
        Pembeli02 pembeli = antrianList.removeByNomor(nomor);

        // Jika nomor tidak ditemukan, batalkan pemrosesan pesanan.
        if (pembeli == null) {
            System.out.println("Nomor antrean tidak ditemukan. Silakan periksa kembali.");
            return;
        }

        // Input data pesanan untuk pembeli yang dipanggil.
        int kodePesanan = inputInt("Kode Pesanan : ");
        String namaPesanan = inputString("Nama Pesanan : ");
        int harga = inputInt("Harga       : ");

        // Tambahkan pesanan baru ke daftar pesanan.
        Pesanan02 pesanan = new Pesanan02(kodePesanan, namaPesanan, harga);
        pesananList.addPesanan(pesanan);

        System.out.println(pembeli.getNamaPembeli() + " telah memesan " + namaPesanan + ".");
    }

    // Tampilkan laporan pesanan yang sudah masuk.
    private static void laporanPesanan() {
        System.out.println("================================");
        System.out.println("Laporan Pesanan");
        pesananList.printReport();
    }

    // Cari pesanan berdasarkan kode dan tampilkan detail jika ditemukan.
    private static void cariPesanan() {
        System.out.println("================================");
        System.out.println("Cari Pesanan berdasarkan Kode");
        int kodePesanan = inputInt("Masukkan Kode Pesanan : ");

        Pesanan02 hasil = pesananList.searchPesananByKode(kodePesanan);
        if (hasil != null) {
            System.out.println("Pesanan ditemukan:");
            System.out.println("Nama Pesanan : " + hasil.getNamaPesanan());
            System.out.println("Harga        : " + hasil.getHarga());
        } else {
            System.out.println("Kode pesanan tidak ditemukan.");
        }
    }

    // Baca input angka dari pengguna dengan validasi.
    private static int inputInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = scanner.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                // Jika input bukan angka, ulangi sampai valid.
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
            }
        }
    }

    // Baca input teks dari pengguna dan hilangkan spasi ekstra.
    private static String inputString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
