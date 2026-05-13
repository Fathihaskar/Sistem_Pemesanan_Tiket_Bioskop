import java.util.Scanner;

class Tiket {
    int id;
    String nama;
    String film;
    int jumlah;
    boolean isDeleted;

    public Tiket(int id, String nama, String film, int jumlah) {
        this.id = id;
        this.nama = nama;
        this.film = film;
        this.jumlah = jumlah;
        this.isDeleted = false;
    }
}

public class SistemTiketBioskopnew {
    static Tiket[] data = new Tiket[100];
    static int jumlahData = 0;
    static Scanner sc = new Scanner(System.in);

    // Method untuk memuat 30 data awal
    static void muatDataAwal() {
        // Film: Ghost in the Cell
        data[jumlahData++] = new Tiket(101, "Motoko Kusanagi",  "Ghost in the Cell", 3);
        data[jumlahData++] = new Tiket(102, "Batou",            "Ghost in the Cell", 2);
        data[jumlahData++] = new Tiket(103, "Togusa",           "Ghost in the Cell", 4);
        data[jumlahData++] = new Tiket(104, "Aramaki",          "Ghost in the Cell", 1);
        data[jumlahData++] = new Tiket(105, "Ishikawa",         "Ghost in the Cell", 2);
        data[jumlahData++] = new Tiket(106, "Saito",            "Ghost in the Cell", 3);

        // Film: Danur 2
        data[jumlahData++] = new Tiket(201, "Risa Adistia",     "Danur 2", 2);
        data[jumlahData++] = new Tiket(202, "Peter",            "Danur 2", 1);
        data[jumlahData++] = new Tiket(203, "William",          "Danur 2", 3);
        data[jumlahData++] = new Tiket(204, "Janshen",          "Danur 2", 2);
        data[jumlahData++] = new Tiket(205, "Hans",             "Danur 2", 4);
        data[jumlahData++] = new Tiket(206, "Asih",             "Danur 2", 1);

        // Film: Pengabdi Setan 3
        data[jumlahData++] = new Tiket(301, "Rini Suwono",      "Pengabdi Setan 3", 4);
        data[jumlahData++] = new Tiket(302, "Tony Suwono",      "Pengabdi Setan 3", 2);
        data[jumlahData++] = new Tiket(303, "Hendra Suwono",    "Pengabdi Setan 3", 3);
        data[jumlahData++] = new Tiket(304, "Bondi Suwono",     "Pengabdi Setan 3", 1);
        data[jumlahData++] = new Tiket(305, "Uwak",             "Pengabdi Setan 3", 5);
        data[jumlahData++] = new Tiket(306, "Budiman",          "Pengabdi Setan 3", 2);

        // Film: Sri Asih
        data[jumlahData++] = new Tiket(401, "Alana Shinta",     "Sri Asih", 3);
        data[jumlahData++] = new Tiket(402, "Sari Dewi",        "Sri Asih", 2);
        data[jumlahData++] = new Tiket(403, "Komandan Wira",    "Sri Asih", 4);
        data[jumlahData++] = new Tiket(404, "Nadia Permata",    "Sri Asih", 1);
        data[jumlahData++] = new Tiket(405, "Farhan Malik",     "Sri Asih", 3);
        data[jumlahData++] = new Tiket(406, "Dewi Ratna",       "Sri Asih", 2);

        // Film: Gundala
        data[jumlahData++] = new Tiket(501, "Sancaka",          "Gundala", 5);
        data[jumlahData++] = new Tiket(502, "Pengkor",          "Gundala", 2);
        data[jumlahData++] = new Tiket(503, "Wulan",            "Gundala", 3);
        data[jumlahData++] = new Tiket(504, "Ghani",            "Gundala", 1);
        data[jumlahData++] = new Tiket(505, "Ridwan Bahri",     "Gundala", 4);
        data[jumlahData++] = new Tiket(506, "Swara Bumi",       "Gundala", 2);

        System.out.println(">> " + jumlahData + " data tiket awal berhasil dimuat.");
    }

    public static void main(String[] args) {
        muatDataAwal();

        int menu;
        do {
            System.out.println("\n=== APP BIOSKOP ===");
            System.out.println("1. Tambah Tiket");
            System.out.println("2. Tampil Semua (CRUD - Read)");
            System.out.println("3. Urutkan Nama (Selection Sort - Asc)");
            System.out.println("4. Urutkan ID (Bubble Sort - Asc)");
            System.out.println("5. Urutkan Tiket Terbanyak (Bubble Sort - Desc)");
            System.out.println("6. Cari ID (Binary Search)");
            System.out.println("7. Cari Nama (Linear Search)");
            System.out.println("8. Cari Film (Kategori)");
            System.out.println("9. Hapus Tiket (Soft Delete)");
            System.out.println("10. Statistik");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            menu = sc.nextInt();

            switch(menu) {
                case 1: tambah(); break;
                case 2: tampil(); break;
                case 3: urutNama(); break;
                case 4: urutID(); break;
                case 5: urutTerbanyak(); break;
                case 6: cariID(); break;
                case 7: cariNama(); break;
                case 8: cariFilm(); break;
                case 9: hapus(); break;
                case 10: statistik(); break;
            }
        } while (menu != 0);
    }

    static void tambah() {
        System.out.print("ID: "); int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Nama Pemesan: "); String nama = sc.nextLine();
        System.out.print("Judul Film: "); String film = sc.nextLine();
        System.out.print("Jumlah Tiket: "); int jml = sc.nextInt();
        data[jumlahData++] = new Tiket(id, nama, film, jml);
        System.out.println("Berhasil!");
    }

    static void tampil() {
        System.out.println("\nID\tNama\t\t\tFilm\t\t\tJumlah\tStatus");
        System.out.println("----------------------------------------------------------------------");
        for (int i = 0; i < jumlahData; i++) {
            if (!data[i].isDeleted) {
                System.out.println(data[i].id + "\t" + data[i].nama + "\t\t" + data[i].film + "\t\t" + data[i].jumlah + "\tAktif");
            }
        }
    }

    // SELECTION SORT (Alphabetical)
    static void urutNama() {
        for (int i = 0; i < jumlahData - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < jumlahData; j++) {
                if (data[j].nama.compareToIgnoreCase(data[minIdx].nama) < 0) minIdx = j;
            }
            Tiket temp = data[minIdx];
            data[minIdx] = data[i];
            data[i] = temp;
        }
        System.out.println("Nama berhasil diurutkan A-Z.");
    }

    // BUBBLE SORT (ID Ascending)
    static void urutID() {
        for (int i = 0; i < jumlahData - 1; i++) {
            for (int j = 0; j < jumlahData - i - 1; j++) {
                if (data[j].id > data[j+1].id) {
                    Tiket temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        System.out.println("ID berhasil diurutkan.");
    }

    // BUBBLE SORT (Jumlah Tiket Descending)
    static void urutTerbanyak() {
        for (int i = 0; i < jumlahData - 1; i++) {
            for (int j = 0; j < jumlahData - i - 1; j++) {
                if (data[j].jumlah < data[j+1].jumlah) {
                    Tiket temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        System.out.println("Data diurutkan dari pembelian terbanyak.");
    }

    // BINARY SEARCH
    static void cariID() {
        urutID(); // Wajib urut dulu
        System.out.print("Cari ID: ");
        int cari = sc.nextInt();
        int low = 0, high = jumlahData - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid].id == cari) {
                System.out.println("Ditemukan! Pemesan: " + data[mid].nama + " | Film: " + data[mid].film);
                return;
            }
            if (data[mid].id < cari) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println("Tidak ditemukan.");
    }

    // LINEAR SEARCH
    static void cariNama() {
        sc.nextLine();
        System.out.print("Cari Nama: ");
        String cari = sc.nextLine();
        for (int i = 0; i < jumlahData; i++) {
            if (data[i].nama.equalsIgnoreCase(cari) && !data[i].isDeleted) {
                System.out.println("ID: " + data[i].id + ", Film: " + data[i].film + ", Jumlah: " + data[i].jumlah);
                return;
            }
        }
        System.out.println("Nama tidak ada.");
    }

    // SEARCH KATEGORI
    static void cariFilm() {
        sc.nextLine();
        System.out.print("Masukkan Judul Film: ");
        String cari = sc.nextLine();
        System.out.println("Daftar Penonton Film \"" + cari + "\":");
        boolean ada = false;
        for (int i = 0; i < jumlahData; i++) {
            if (data[i].film.equalsIgnoreCase(cari) && !data[i].isDeleted) {
                System.out.println("- " + data[i].nama + " (" + data[i].jumlah + " tiket)");
                ada = true;
            }
        }
        if (!ada) System.out.println("Tidak ada data untuk film tersebut.");
    }

    static void hapus() {
        System.out.print("ID yang ingin dihapus: ");
        int id = sc.nextInt();
        for (int i = 0; i < jumlahData; i++) {
            if (data[i].id == id) {
                data[i].isDeleted = true;
                System.out.println("Data dinonaktifkan (Soft Delete).");
                return;
            }
        }
        System.out.println("ID tidak ditemukan.");
    }

    static void statistik() {
        int aktif = 0;
        int totalTiket = 0;
        int[] tiketPerFilm = new int[5];
        String[] judulFilm = {"Ghost in the Cell", "Danur 2", "Pengabdi Setan 3", "Sri Asih", "Gundala"};

        for (int i = 0; i < jumlahData; i++) {
            if (!data[i].isDeleted) {
                aktif++;
                totalTiket += data[i].jumlah;
                for (int f = 0; f < judulFilm.length; f++) {
                    if (data[i].film.equalsIgnoreCase(judulFilm[f])) {
                        tiketPerFilm[f] += data[i].jumlah;
                    }
                }
            }
        }

        System.out.println("\n=== STATISTIK ===");
        System.out.println("Total Transaksi Aktif : " + aktif);
        System.out.println("Total Tiket Terjual   : " + totalTiket);
        System.out.println("\nTiket per Film:");
        for (int f = 0; f < judulFilm.length; f++) {
            System.out.println("  - " + judulFilm[f] + ": " + tiketPerFilm[f] + " tiket");
        }
    }
}