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

