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
