# PROJECT_INDIVIDU_PBOProjek Individu – Simulasi Bus Trans Koetaradja
Program Berbasis Java (BlueJ / VSCode / Terminal)

**1. Deskripsi Program**
Projek ini merupakan simulasi pengelolaan penumpang Bus Trans Koetaradja menggunakan pendekatan Object-Oriented Programming (OOP). Program memungkinkan pengguna menambahkan penumpang baru, menurunkan penumpang berdasarkan nama, serta menampilkan kondisi bus secara real-time.
Sistem dirancang mengikuti aturan operasional bus, termasuk pembagian kursi prioritas, kursi biasa, dan area berdiri. Setiap penumpang diperiksa saldo, kategori, dan kelayakan tempat duduk sesuai ketentuan yang berlaku.

**2. Fitur Utama**

**Naikkan Penumpang**
Memasukkan data penumpang (nama, umur, hamil/tidak).
Menentukan kategori otomatis berdasarkan aturan:
Lansia (>60 tahun)
Anak-anak (<10 tahun)
Ibu hamil
Memastikan saldo cukup untuk membayar ongkos (Rp2.000).
Menempatkan penumpang sesuai prioritas:
Prioritas → kursi prioritas → kursi biasa → berdiri
Penumpang biasa → kursi biasa → berdiri

**Turunkan Penumpang**
Menghapus penumpang berdasarkan nama.
Memberikan notifikasi apakah penumpang ditemukan atau tidak.

**Lihat Penumpang**
Menampilkan daftar lengkap:
Penumpang Biasa
Penumpang Prioritas
Penumpang Berdiri
Total penumpang
Total pendapatan bus

**3. Struktur Kelas**

**Class Orang**
Atribut:
nama
Tujuan:
Menjadi kelas dasar bagi Penumpang
Menyediakan representasi nama

**Class PembayarBus (Interface)**
Mendefinisikan perilaku bayarOngkos() untuk objek penumpang

**Class KategoriPenumpang (Enum)**
PRIORITAS
BIASA

**Class SaldoTidakCukupException**
Exception khusus ketika saldo penumpang tidak mencukupi

**Class Penumpang**
Atribut:
id, nama, umur, hamil, saldo, kategori
Method penting:
Constructor dengan saldo awal Rp10.000
tambahSaldo(int)
bayarOngkos(int)
isPrioritas()
Getter atribut lengkap

**Class Bus**
Atribut:
ArrayList<Penumpang> untuk:
penumpangPrioritas
penumpangBiasa
penumpangBerdiri
ONGKOS_BUS = 2000
totalPendapatan
Method penting:
naikkanPenumpang(Penumpang)
turunkanPenumpang(String nama)
Getter jumlah penumpang
getTotalPendapatan()
toString() untuk ringkasan bus

**Class TestBus**
Menyediakan menu interaktif:
Naikkan Penumpang
Turunkan Penumpang
Lihat Penumpang
Keluar

**4. Konsep OOP yang Diimplementasikan**
Program ini mengimplementasikan lebih dari enam konsep OOP, yaitu:
Class dan Object
Encapsulation (atribut private + getter)
Inheritance (Penumpang mewarisi Orang)
Interface (PembayarBus)
Abstraction (pemodelan entitas)
Polymorphism (override toString())
Exception Handling (SaldoTidakCukupException)
Enum untuk kategori
Collection (ArrayList)

**5. Cara Menjalankan Program (BlueJ / VSCode / CMD)**
Pastikan semua file .java berada pada folder yang sama.
Compile seluruh file:
javac *.java
Jalankan program utama:
java TestBus
Gunakan menu yang tersedia untuk mencoba seluruh fitur.
