public interface PembayarBus {
    void bayarOngkos(int ongkos) throws SaldoTidakCukupException;
}
