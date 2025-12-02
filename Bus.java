import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bus {

    private List<Penumpang> penumpangBiasa;
    private List<Penumpang> penumpangPrioritas;
    private List<Penumpang> penumpangBerdiri;

  public static final int ONGKOS_BUS = 2000;

    private static final int MAKS_KURSI_BIASA = 16;
    private static final int MAKS_KURSI_PRIORITAS = 4;
    private static final int MAKS_BERDIRI = 20;
    private static final int MAKS_TOTAL = 40;

    private int totalPendapatan;

  public Bus() {
        penumpangBiasa = new ArrayList<>();
        penumpangPrioritas = new ArrayList<>();
        penumpangBerdiri = new ArrayList<>();
        totalPendapatan = 0;
    }

 // ====== Getter array ======
    public Penumpang[] getPenumpangBiasa() {
        return penumpangBiasa.toArray(new Penumpang[0]);
    }

    public Penumpang[] getPenumpangPrioritas() {
        return penumpangPrioritas.toArray(new Penumpang[0]);
    }

    public Penumpang[] getPenumpangBerdiri() {
        return penumpangBerdiri.toArray(new Penumpang[0]);
    }

        // ====== Jumlah penumpang ======
    public int getJumlahPenumpangBiasa() {
        return penumpangBiasa.size();
    }

    public int getJumlahPenumpangPrioritas() {
        return penumpangPrioritas.size();
    }

    public int getJumlahPenumpangBerdiri() {
        return penumpangBerdiri.size();
    }

    public int getTotalPendapatan() {
        return totalPendapatan;
    }

    public int getTotalPenumpang() {
        return getJumlahPenumpangBiasa()
             + getJumlahPenumpangPrioritas()
             + getJumlahPenumpangBerdiri();
    }

    private boolean busPenuh() {
        return getTotalPenumpang() >= MAKS_TOTAL;
    }

    /**
     * Mengatur logika naik penumpang:
     * - Cek saldo cukup
     * - Cek kapasitas bus
     * - Atur kursi sesuai prioritas / biasa
     */
    public boolean naikkanPenumpang(Penumpang p) {
        if (p == null) {
            return false;
        }

        if (busPenuh()) {
            System.out.println("Bus sudah penuh. Penumpang tidak dapat naik.");
            return false;
        }

        if (p.getSaldo() < ONGKOS_BUS) {
            System.out.println("Saldo penumpang tidak cukup untuk naik bus.");
            return false;
        }

           boolean berhasilDitempatkan = false;

        if (p.isPrioritas()) {
            if (penumpangPrioritas.size() < MAKS_KURSI_PRIORITAS) {
                penumpangPrioritas.add(p);
                berhasilDitempatkan = true;
            }
            else if (penumpangBiasa.size() < MAKS_KURSI_BIASA) {
                penumpangBiasa.add(p);
                berhasilDitempatkan = true;
            }
            else if (penumpangBerdiri.size() < MAKS_BERDIRI) {
                penumpangBerdiri.add(p);
                berhasilDitempatkan = true;
            }
        } else {
            // Penumpang biasa:
            // 1. Coba kursi biasa
            if (penumpangBiasa.size() < MAKS_KURSI_BIASA) {
                penumpangBiasa.add(p);
                berhasilDitempatkan = true;
            }
            // 2. Kalau kursi biasa penuh, boleh berdiri
            else if (penumpangBerdiri.size() < MAKS_BERDIRI) {
                penumpangBerdiri.add(p);
                berhasilDitempatkan = true;
            }
            // Tidak boleh duduk di kursi prioritas
        }

        if (!berhasilDitempatkan) {
            System.out.println("Tidak ada posisi yang tersedia untuk penumpang ini.");
            return false;
        }

          // Jika sudah ditempatkan, baru potong saldo dan tambah pendapatan
        try {
            p.bayarOngkos(ONGKOS_BUS);
            totalPendapatan += ONGKOS_BUS;
            return true;
        } catch (SaldoTidakCukupException e) {
            System.out.println(e.getMessage());
            // rollback: hapus dari list kalau tadi sudah masuk
            penumpangBiasa.remove(p);
            penumpangPrioritas.remove(p);
            penumpangBerdiri.remove(p);
            return false;
        }
    }

       /**
     * Turunkan penumpang berdasarkan NAMA.
     */
    public boolean turunkanPenumpang(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            return false;
        }

        // Cari di tiap list
        Penumpang target = cariPenumpangDenganNama(nama, penumpangBiasa);
        if (target != null) {
            penumpangBiasa.remove(target);
            return true;
        }

        target = cariPenumpangDenganNama(nama, penumpangPrioritas);
        if (target != null) {
            penumpangPrioritas.remove(target);
            return true;
        }

        target = cariPenumpangDenganNama(nama, penumpangBerdiri);
        if (target != null) {
            penumpangBerdiri.remove(target);
            return true;
        }

        return false;
    }

    private Penumpang cariPenumpangDenganNama(String nama, List<Penumpang> list) {
        for (Penumpang p : list) {
            if (p.getNama().equalsIgnoreCase(nama)) {
                return p;
            }
        }
        return null;
    }

       private String formatDaftarNama(List<Penumpang> list) {
        if (list.isEmpty()) {
            return "<kosong>";
        }
        // contoh penggunaan lambda + method reference
        return list.stream()
                   .map(Penumpang::getNama)
                   .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== BUS TRANS KOETARADJA ======\n");
        sb.append("Penumpang Biasa    : ")
          .append(formatDaftarNama(penumpangBiasa)).append("\n");
        sb.append("Penumpang Prioritas: ")
          .append(formatDaftarNama(penumpangPrioritas)).append("\n");
        sb.append("Penumpang Berdiri  : ")
          .append(formatDaftarNama(penumpangBerdiri)).append("\n");
        sb.append("---------------------------------\n");
        sb.append("Jumlah Penumpang   : ").append(getTotalPenumpang()).append("\n");
        sb.append("Total Pendapatan   : ").append(totalPendapatan).append("\n");
        sb.append("=================================\n");
        return sb.toString();
    }
}
