public abstract class Orang {
    private String nama;

    public Orang(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public String toString() {
        return nama;
    }
}
