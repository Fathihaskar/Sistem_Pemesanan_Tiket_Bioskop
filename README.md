import java.util.Scanner;
import java.io.*;

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

public class SistemTiketBioskopFix {

    static Tiket[] data = new Tiket[100];
    static int jumlahData = 0;
    static Scanner sc = new Scanner(System.in);

    // =========================
    // LOAD DATA DARI FILE TXT
    // =========================
    static void loadData() {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("tiket.txt"));

            String line;

            while ((line = br.readLine()) != null) {

                String[] p = line.split(",");

                int id = Integer.parseInt(p[0]);
                String nama = p[1];
                String film = p[2];
                int jumlah = Integer.parseInt(p[3]);
                boolean deleted = Boolean.parseBoolean(p[4]);

                data[jumlahData] =
                        new Tiket(id, nama, film, jumlah);

                data[jumlahData].isDeleted = deleted;

                jumlahData++;
            }

            br.close();

            System.out.println(">> Data berhasil dimuat dari file.");

        } catch (Exception e) {

            System.out.println(">> File belum ada.");
        }
    }

    // =========================
    // SIMPAN DATA KE FILE TXT
    // =========================
    static void simpanData() {

        try {

            PrintWriter pw =
                    new PrintWriter(
                            new FileWriter("tiket.txt"));

            for (int i = 0; i < jumlahData; i++) {

                pw.println(
                        data[i].id + "," +
                        data[i].nama + "," +
                        data[i].film + "," +
                        data[i].jumlah + "," +
                        data[i].isDeleted
                );
            }

            pw.close();

            System.out.println(">> Data berhasil disimpan.");

        } catch (Exception e) {

            System.out.println(">> Gagal menyimpan data.");
        }
    }

    // =========================
    // DATA AWAL
    // =========================
    static void muatDataAwal() {

data[jumlahData++] = new Tiket(101, "Antony", "Ghost in the Cell", 1);
data[jumlahData++] = new Tiket(102, "Bagaskara", "Ghost in the Cell", 2);
data[jumlahData++] = new Tiket(103, "Bruno", "Ghost in the Cell", 4);
data[jumlahData++] = new Tiket(104, "Joko Anwar", "Ghost in the Cell", 1);
data[jumlahData++] = new Tiket(105, "Tokek", "Ghost in the Cell", 2);
data[jumlahData++] = new Tiket(106, "Six", "Ghost in the Cell", 3);

data[jumlahData++] = new Tiket(201, "Risa Adistia", "Danur 2", 2);
data[jumlahData++] = new Tiket(202, "Peter", "Danur 2", 1);
data[jumlahData++] = new Tiket(203, "William", "Danur 2", 3);
data[jumlahData++] = new Tiket(204, "Janshen", "Danur 2", 2);
data[jumlahData++] = new Tiket(205, "Hans", "Danur 2", 4);
data[jumlahData++] = new Tiket(206, "Asih", "Danur 2", 1);

data[jumlahData++] = new Tiket(301, "Rini Suwono", "Pengabdi Setan 3", 4);
data[jumlahData++] = new Tiket(302, "Tony Suwono", "Pengabdi Setan 3", 2);
data[jumlahData++] = new Tiket(303, "Hendra Suwono", "Pengabdi Setan 3", 3);
data[jumlahData++] = new Tiket(304, "Bondi Suwono", "Pengabdi Setan 3", 1);
data[jumlahData++] = new Tiket(305, "Uwak", "Pengabdi Setan 3", 5);
data[jumlahData++] = new Tiket(306, "Budiman", "Pengabdi Setan 3", 2);

data[jumlahData++] = new Tiket(401, "Alana Shinta", "Sri Asih", 3);
data[jumlahData++] = new Tiket(402, "Sari Dewi", "Sri Asih", 2);
data[jumlahData++] = new Tiket(403, "Komandan Wira", "Sri Asih", 4);
data[jumlahData++] = new Tiket(404, "Nadia Permata", "Sri Asih", 1);
data[jumlahData++] = new Tiket(405, "Farhan Malik", "Sri Asih", 3);
data[jumlahData++] = new Tiket(406, "Dewi Ratna", "Sri Asih", 2);

data[jumlahData++] = new Tiket(501, "Sancaka", "Gundala", 5);
data[jumlahData++] = new Tiket(502, "Pengkor", "Gundala", 2);
data[jumlahData++] = new Tiket(503, "Wulan", "Gundala", 3);
data[jumlahData++] = new Tiket(504, "Ghani", "Gundala", 1);
data[jumlahData++] = new Tiket(505, "Ridwan Bahri", "Gundala", 4);
data[jumlahData++] = new Tiket(506, "Swara Bumi", "Gundala", 2);

        System.out.println(">> Data awal berhasil dimuat.");
    }

    // =========================
    // MAIN
    // =========================
    public static void main(String[] args) {

        // LOAD DATA FILE
        loadData();

        // Kalau file kosong
        if (jumlahData == 0) {
            muatDataAwal();
        }

        int menu;

        do {

            System.out.println("\n=================================================================");
            System.out.println("|                     SISTEM TIKET BIOSKOP                      |");
            System.out.println("=================================================================");
            System.out.println("| No |                       Menu                               |");
            System.out.println("=================================================================");
            System.out.println("| 1  | Tambah Tiket                                             |");
            System.out.println("| 2  | Tampil Semua Data                                        |");
            System.out.println("| 3  | Urutkan Nama                                             |");
            System.out.println("| 4  | Urutkan ID                                               |");
            System.out.println("| 5  | Urutkan Tiket Terbanyak                                  |");
            System.out.println("| 6  | Cari ID                                                  |");
            System.out.println("| 7  | Cari Nama                                                |");
            System.out.println("| 8  | Cari Film                                                |");
            System.out.println("| 9  | Hapus Tiket                                              |");
            System.out.println("| 10 | Statistik                                                |");
            System.out.println("| 11 | Edit Data                                                |");
            System.out.println("| 12 | Update Status                                            |");
            System.out.println("| 13 | Counter Data                                             |");
            System.out.println("| 14 | Simpan Data ke TXT                                       |");
            System.out.println("| 0  | Keluar                                                   |");
            System.out.println("=================================================================");

            System.out.print("Pilih Menu : ");
            menu = sc.nextInt();

            switch(menu) {

                case 1:
                    tambah();
                    break;

                case 2:
                    tampil();
                    break;

                case 3:
                    urutNama();
                    break;

                case 4:
                    urutID();
                    break;

                case 5:
                    urutTerbanyak();
                    break;

                case 6:
                    cariID();
                    break;

                case 7:
                    cariNama();
                    break;

                case 8:
                    cariFilm();
                    break;

                case 9:
                    hapus();
                    break;

                case 10:
                    statistik();
                    break;

                case 11:
                    edit();
                    break;

                case 12:
                    updateStatus();
                    break;

                case 13:
                    tampilCounter();
                    break;

                case 14:
                    simpanData();
                    break;

                case 0:
                    simpanData();
                    System.out.println(">> Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }

        } while(menu != 0);
    }

    // =========================
    // TAMBAH DATA
    // =========================
    static void tambah() {

        System.out.print("ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nama Pemesan : ");
        String nama = sc.nextLine();

        System.out.print("Judul Film : ");
        String film = sc.nextLine();

        System.out.print("Jumlah Tiket : ");
        int jumlah = sc.nextInt();

        data[jumlahData++] =
                new Tiket(id, nama, film, jumlah);

        System.out.println(">> Data berhasil ditambahkan.");
    }

    // =========================
    // TAMPIL DATA
    // =========================
    static void tampil() {

        System.out.println("\n================================================================================================");
        System.out.printf("| %-5s | %-25s | %-25s | %-10s | %-15s |\n",
                "ID", "Nama Pemesan", "Judul Film", "Jumlah", "Status");
        System.out.println("================================================================================================");

        for (int i = 0; i < jumlahData; i++) {

            String status =
                    data[i].isDeleted ? "Nonaktif" : "Aktif";

            System.out.printf("| %-5d | %-25s | %-25s | %-10d | %-15s |\n",
                    data[i].id,
                    data[i].nama,
                    data[i].film,
                    data[i].jumlah,
                    status);
        }

        System.out.println("================================================================================================");
    }

    // =========================
    // SORT NAMA
    // =========================
    static void urutNama() {

        for (int i = 0; i < jumlahData - 1; i++) {

            int minIdx = i;

            for (int j = i + 1; j < jumlahData; j++) {

                if (data[j].nama.compareToIgnoreCase(data[minIdx].nama) < 0) {
                    minIdx = j;
                }
            }

            Tiket temp = data[minIdx];
            data[minIdx] = data[i];
            data[i] = temp;
        }

        System.out.println(">> Nama berhasil diurutkan.");
    }

    // =========================
    // SORT ID
    // =========================
    static void urutID() {

        for (int i = 0; i < jumlahData - 1; i++) {

            for (int j = 0; j < jumlahData - i - 1; j++) {

                if (data[j].id > data[j + 1].id) {

                    Tiket temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        System.out.println(">> ID berhasil diurutkan.");
    }

    // =========================
    // SORT TIKET TERBANYAK
    // =========================
    static void urutTerbanyak() {

        for (int i = 0; i < jumlahData - 1; i++) {

            for (int j = 0; j < jumlahData - i - 1; j++) {

                if (data[j].jumlah < data[j + 1].jumlah) {

                    Tiket temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        System.out.println(">> Data berhasil diurutkan.");
    }

    // =========================
    // BINARY SEARCH
    // =========================
    static void cariID() {

        urutID();

        System.out.print("Cari ID : ");
        int cari = sc.nextInt();

        int low = 0;
        int high = jumlahData - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (data[mid].id == cari) {

                System.out.println("\n======================================================");
                System.out.println("|                DATA DITEMUKAN                      |");
                System.out.println("======================================================");

                System.out.printf("| %-15s : %-25d |\n", "ID", data[mid].id);
                System.out.printf("| %-15s : %-25s |\n", "Nama", data[mid].nama);
                System.out.printf("| %-15s : %-25s |\n", "Film", data[mid].film);
                System.out.printf("| %-15s : %-25d |\n", "Jumlah", data[mid].jumlah);

                System.out.println("======================================================");

                return;
            }

            if (data[mid].id < cari)
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println("Data tidak ditemukan.");
    }

    // =========================
    // LINEAR SEARCH
    // =========================
    static void cariNama() {

        sc.nextLine();

        System.out.print("Cari Nama : ");
        String cari = sc.nextLine();

        for (int i = 0; i < jumlahData; i++) {

            if (data[i].nama.equalsIgnoreCase(cari)
                    && !data[i].isDeleted) {

                System.out.println("\n================================================================================");
                System.out.printf("| %-5s | %-25s | %-20s | %-10s |\n",
                        "ID", "Nama", "Film", "Jumlah");
                System.out.println("================================================================================");

                System.out.printf("| %-5d | %-25s | %-20s | %-10d |\n",
                        data[i].id,
                        data[i].nama,
                        data[i].film,
                        data[i].jumlah);

                System.out.println("================================================================================");

                return;
            }
        }

        System.out.println("Nama tidak ditemukan.");
    }

    // =========================
    // CARI FILM
    // =========================
    static void cariFilm() {

        sc.nextLine();

        System.out.print("Masukkan Judul Film : ");
        String cari = sc.nextLine();

        boolean ada = false;

        System.out.println("\n==================================================================================================");
        System.out.printf("| %-5s | %-25s | %-25s | %-10s |\n",
                "ID", "Nama", "Film", "Jumlah");
        System.out.println("==================================================================================================");

        for (int i = 0; i < jumlahData; i++) {

            if (data[i].film.equalsIgnoreCase(cari)
                    && !data[i].isDeleted) {

                System.out.printf("| %-5d | %-25s | %-25s | %-10d |\n",
                        data[i].id,
                        data[i].nama,
                        data[i].film,
                        data[i].jumlah);

                ada = true;
            }
        }

        System.out.println("==================================================================================================");

        if (!ada) {
            System.out.println("Film tidak ditemukan.");
        }
    }

    // =========================
    // HAPUS DATA (HARD DELETE)
    // =========================
    static void hapus() {

        System.out.print("Masukkan ID yang ingin dihapus : ");
        int id = sc.nextInt();

        boolean ditemukan = false;

        for (int i = 0; i < jumlahData; i++) {

            if (data[i].id == id) {

                // Geser semua data ke kiri
                for (int j = i; j < jumlahData - 1; j++) {

                    data[j] = data[j + 1];
                }

                // Kosongkan data terakhir
                data[jumlahData - 1] = null;

                // Kurangi jumlah data
                jumlahData--;

                ditemukan = true;

                System.out.println(">> Data berhasil dihapus permanen.");

                break;
            }
        }

        if (!ditemukan) {

            System.out.println(">> ID tidak ditemukan.");
        }
    }

    // =========================
    // STATISTIK
    // =========================
    static void statistik() {

        int aktif = 0;
        int totalTiket = 0;

        for (int i = 0; i < jumlahData; i++) {

            if (!data[i].isDeleted) {

                aktif++;
                totalTiket += data[i].jumlah;
            }
        }

        System.out.println("\n======================================================");
        System.out.println("|                    STATISTIK                       |");
        System.out.println("======================================================");

        System.out.printf("| %-30s | %-10d |\n",
                "Total Data Aktif", aktif);

        System.out.printf("| %-30s | %-10d |\n",
                "Total Tiket", totalTiket);

        System.out.println("======================================================");
    }

    // =========================
    // EDIT DATA
    // =========================
    static void edit() {

        System.out.print("Masukkan ID yang ingin diedit : ");
        int idEdit = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < jumlahData; i++) {

            if (data[i].id == idEdit && !data[i].isDeleted) {

                System.out.print("Nama Baru : ");
                data[i].nama = sc.nextLine();

                System.out.print("Film Baru : ");
                data[i].film = sc.nextLine();

                System.out.print("Jumlah Baru : ");
                data[i].jumlah = sc.nextInt();

                System.out.println(">> Data berhasil diedit.");

                return;
            }
        }

        System.out.println("ID tidak ditemukan.");
    }

    // =========================
    // UPDATE STATUS
    // =========================
    static void updateStatus() {

        System.out.print("Masukkan ID : ");
        int id = sc.nextInt();

        for (int i = 0; i < jumlahData; i++) {

            if (data[i].id == id) {

                data[i].isDeleted = !data[i].isDeleted;

                String status =
                        data[i].isDeleted ? "Nonaktif" : "Aktif";

                System.out.println(">> Status berhasil diubah menjadi " + status);

                return;
            }
        }

        System.out.println("ID tidak ditemukan.");
    }

    // =========================
    // COUNTER DATA
    // =========================
    static void tampilCounter() {

        int aktif = 0;
        int nonaktif = 0;

        for (int i = 0; i < jumlahData; i++) {

            if (data[i].isDeleted)
                nonaktif++;
            else
                aktif++;
        }

        System.out.println("\n======================================================");
        System.out.println("|                 COUNTER DATA ARRAY                 |");
        System.out.println("======================================================");

        System.out.printf("| %-30s | %-17d |\n",
                "Kapasitas Maksimal", data.length);

        System.out.printf("| %-30s | %-17d |\n",
                "Total Slot Terisi", jumlahData);

        System.out.printf("| %-30s | %-17d |\n",
                "Data Aktif", aktif);

        System.out.printf("| %-30s | %-17d |\n",
                "Data Nonaktif", nonaktif);

        System.out.printf("| %-30s | %-17d |\n",
                "Sisa Slot Kosong", (data.length - jumlahData));

        System.out.println("======================================================");
    }
}
