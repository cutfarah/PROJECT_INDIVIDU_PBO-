public class Penumpang extends Orang implements PembayarBus {

    private int id;
    private int umur;
    private boolean hamil;
    private int saldo; // dalam rupiah
    private KategoriPenumpang kategori;

     public Penumpang(int id, String nama, int umur, boolean hamil) {
        super(nama);
        this.id = id;
        this.umur = umur;
        this.hamil = hamil;
        // saldo awal sesuai soal: 10.000
        this.saldo = 10000;
        this.kategori = tentukanKategori();
    }

 private KategoriPenumpang tentukanKategori() {
        if (umur > 60 || umur < 10 || hamil) {
            return KategoriPenumpang.PRIORITAS;
        } else {
            return KategoriPenumpang.BIASA;
        }
    }

 public int getId() {
        return id;
    }

    public int getUmur() {
        return umur;
    }

    public boolean getHamil() {
        return hamil;
    }

    public int getSaldo() {
        return saldo;
    }

    public KategoriPenumpang getKategori() {
        return kategori;
    }

    public boolean isPrioritas() {
        return kategori == KategoriPenumpang.PRIORITAS;
    }

    public void tambahSaldo(int saldoBaru) {
        if (saldoBaru > 0) {
            saldo += saldoBaru;
        }
    }

   @Override
    public void bayarOngkos(int ongkos) throws SaldoTidakCukupException {
        if (saldo < ongkos) {
            throw new SaldoTidakCukupException(
                "Saldo " + getNama() + " tidak cukup. Saldo: " + saldo +
                ", ongkos: " + ongkos
            );
        }
        saldo -= ongkos;
    }
}
