import java.util.Scanner;

public class TestBus {

    private static int NEXT_ID = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Bus bus = new Bus();

      boolean jalan = true;
        while (jalan) {
            System.out.println("===== BUS TRANS KOETARADJA ======");
            System.out.println("MENU : ");
            System.out.println("1. Naikkan Penumpang");
            System.out.println("2. Turunkan Penumpang");
            System.out.println("3. Lihat Penumpang");
            System.out.println("4. Keluar");
            System.out.print("Pilihan : ");

            String input = in.nextLine();
            int pilihan;
            try {
                pilihan = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid!\n");
                continue;
            }

                    switch (pilihan) {
                case 1:
                    naikkanPenumpangMenu(bus, in);
                    break;
                case 2:
                    turunkanPenumpangMenu(bus, in);
                    break;
                case 3:
                    System.out.println(bus.toString());
                    break;
                case 4:
                    jalan = false;
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak dikenal.\n");
            }
        }

        in.close();
    }

     private static void naikkanPenumpangMenu(Bus bus, Scanner in) {
        System.out.print("Nama  : ");
        String nama = in.nextLine();

        System.out.print("Umur  : ");
        int umur;
        try {
            umur = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Umur tidak valid.\n");
            return;
        }

                 System.out.print("Hamil (y/n): ");
        String hamilStr = in.nextLine().trim().toLowerCase();
        boolean hamil = hamilStr.equals("y");

        Penumpang p = new Penumpang(NEXT_ID++, nama, umur, hamil);

        boolean berhasil = bus.naikkanPenumpang(p);
        if (berhasil) {
            System.out.println("Penumpang berhasil ditambahkan!\n");
        } else {
            System.out.println("Penumpang gagal naik ke bus.\n");
        }
    }
