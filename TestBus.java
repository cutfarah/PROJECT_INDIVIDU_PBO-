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
