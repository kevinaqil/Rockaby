package tgs_akhr_alpro;
import java.util.*;



public class Siakad {
	static int jumlahData = 0;
    
	static Mahasiswa[] mahasiswa = new Mahasiswa[1000];
    static Scanner inputUser = new Scanner(System.in);
    static int inputPilihan;
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int menu;
        do
        {
        	System.out.println("Jumlah data : " + jumlahData);
            System.out.println("\n====================");
            System.out.println("|   MENU SIAKAD    |");
            System.out.println("====================");
            System.out.println("| 1 | Tambah Data  |");
            System.out.println("| 2 | Lihat Data   |");
            System.out.println("| 3 | Urutkan Data |");
            System.out.println("| 4 | Cari Data    |");
            System.out.println("| 5 | Edit Data    |");
            System.out.println("| 6 | Hapus Data   |");
            System.out.println("| 7 | UAS          |");
            System.out.println("| 8 | Keluar       |");
            System.out.println("====================");
            System.out.print("Pilihan Menu : ");
            inputPilihan = inputUser.nextInt();
            System.out.println();
            switch (inputPilihan) {
                case 1 -> tambahData();
                case 2 -> lihatData();
                case 3 -> urutkanData();
                case 4 -> cariData();
                case 5 -> editData();
                case 6 -> hapusData();
                case 7 -> UAS();
                case 8 -> {
                    System.out.println("Terima kasih");
                    System.exit(0);
                }
                default -> System.out.println("Pilihan tidak sesuai");
            }
        } while (true);
    }
    
    public static void tambahData()
    {
        System.out.println("Silahkan tambah data");
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan NIM = ");
        long nim = scan.nextLong();
        scan.nextLine();
        System.out.print("Masukkan Nama = ");
        String nama = scan.nextLine();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNim(nim);
        mahasiswa[jumlahData].setNama(nama);
        jumlahData++;
    }

    public static void lihatData()
    {
        System.out.println("Berikut data Anda");
        int i = 0;
        while (i < jumlahData) {
            System.out.println(mahasiswa[i].getNim() + "  " + mahasiswa[i].getNama());
            i++;
        }
        
    }

    public static void editData() {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while (i < jumlahData) {
            System.out.print(i + 1 + ". ");
            System.out.println(mahasiswa[i].getNama() + " " + mahasiswa[i].getNim());
            i++;
        }
        System.out.print("Masukan No yang mau diubah= ");
        int xdata = scan.nextInt() - 1;
        System.out.print("Masukan Nama Baru = ");
        String nama = scan.next();
        System.out.print("Masukan NIM Baru = ");
        Long nim = scan.nextLong();

        mahasiswa[xdata].setNama(nama);
        mahasiswa[xdata].setNim(nim);

        
    }


    public static void hapusData() {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        int j;
        while (i < jumlahData) {
            System.out.print(i + 1 + ". ");
            System.out.println(mahasiswa[i].getNama() + " " + mahasiswa[i].getNim());
            i++;
        }
        System.out.print("Masukan nomer yang mau dihapus = ");
        int xdata = scan.nextInt() - 1;

        System.out.println("Nama : " + mahasiswa[xdata].getNama());
        System.out.println("Nim : " + mahasiswa[xdata].getNim());
        System.out.println("Yakin hapus? y/n");
        String pil = scan.next();
        if (pil.equalsIgnoreCase("y")) {
            mahasiswa[xdata] = null;
            for (i = 0; i < jumlahData - 1; i++) {
                Mahasiswa temp;
                if (mahasiswa[i] == null) {
                    temp = mahasiswa[i + 1];
                    mahasiswa[i] = mahasiswa[i + 1];
                    mahasiswa[i + 1] = null;

                }
            }
            jumlahData = jumlahData - 1;

            System.out.println("Data Berhasil Dihapus!");
        } else {

        }
        
    }
    
 

 // Pencarian Data

    public static void cariData() {
    	Scanner scan = new Scanner(System.in);
        System.out.println("Pilih Algoritma Pencarian : ");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Pilihan : ");
        int cariD = scan.nextInt();
        switch(cariD)
        {
            case 1:
            {
                System.out.print("Ketik NIM yang ingin anda cari : ");
                long ls = scan.nextLong();
                linearSearch(ls);
                break;
            }
            case 2:
            {
                System.out.print("Ketik NIM yang ingin anda cari : ");
                long bs = scan.nextLong();
                binarySearch(bs);
                break;
            }
        }
    }

    // jenis pencarian data
    // linier search
    public static void linearSearch(long ls)
    {
        int n = jumlahData;
        for(int i = 0; i < n; i++)
        {
            if(mahasiswa[i].getNim() == ls)
            {
                System.out.println("NIM yang anda cari ada pada indeks ke-" + (i+1));
            }
        }
    }

    public static void binarySearch(long bs)
    {
        int l = 0, r = jumlahData - 1;
        while(l <= r)
        {
            int m = l + (r - l) / 2;

            if (mahasiswa[m].getNim() == bs)
            {
                System.out.println("NIM yang anda cari ada pada indeks ke-" + (m+1));
            }

            if(mahasiswa[m].getNim() < bs)
            {
                l = m + 1;
            } else
            {
                r = m - 1;
            }
        }
    }
    

    public static void urutkanData()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih Algoritma Pengurutan : ");
        System.out.println("1. EXCHANGE SORT");
        System.out.println("2. SELECTION SORT");
        System.out.println("3. QUICK SORT");
        System.out.println("4. INSERTION SORT");
        System.out.println("5. BUBBLE SORT");
        System.out.println("6. SHELL SORT");
        System.out.println("7. BINARY INSERTION SORT");
        System.out.print("Pilihan : ");
        int algo = scanner.nextInt();
        switch (algo)
        {
            case 1:
            {
                exchangeSort();
                break;
            }
            case 2:
            {
                selectionSort();
                break;
            }
            case 3:
            {
                quickSort(mahasiswa, 0, jumlahData-1);
                break;
            }
            case 4:
            {
                insertionSort();
                break;
            }
            case 5:
            {
                bubbleSort();
                break;
            }
            case 6:
            {
                shellSort();
                break;
            }
            case 7:
            {
                bis();
                break;
            }
        }
    }

    public static void exchangeSort()
    {
        for(int x = 0; x < jumlahData; x++)
        {
            for(int y = x + 1; y < jumlahData; y++)
            {
                if(mahasiswa[x].getNim() > mahasiswa[y].getNim())
                {
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
    }

    public static void quickSort(Mahasiswa[] arr, int low, int high)
    {
        if(low < high)
        {
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }

    static int partition(Mahasiswa[] arr, int low, int high)
    {
        int p = low, j;
        for(j = low + 1; j <= high; j++)
        {
            if(arr[j].getNim() < arr[low].getNim())
            {
                swap(arr, ++p, j);
            }
        }
        swap(arr, low, p);
        return p;
    }

    static void swap(Mahasiswa[] arr, int low, int pivot)
    {
        Mahasiswa tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    public static void selectionSort()
    {
        for(int i = 0; i < jumlahData - 1; i++)
        {
            int min_index = i;
            for(int j = i+1; j < jumlahData; j++)
            {
                if(mahasiswa[j].getNim() < mahasiswa[min_index].getNim())
                {
                    min_index = j;
                }
                Mahasiswa temp = mahasiswa[min_index];
                mahasiswa[min_index] = mahasiswa[i];
                mahasiswa[i] = temp;
            }
        }
    }

    public static void insertionSort()
    {
        for(int i = 1; i < jumlahData; ++i)
        {
            Mahasiswa key = mahasiswa[i];
            int j = i - 1;

            while((j >= 0) && (mahasiswa[j].getNim() > key.getNim()))
            {
                mahasiswa[j + 1] = mahasiswa[j];
                j--;
            }
            mahasiswa[j + 1] = key;
        }
    }

    public static void bubbleSort()
    {
        for(int i = 0; i < jumlahData - 1; i++)
        {
            for(int j = 0; j < jumlahData - i - 1; j++)
            {
                if(mahasiswa[j].getNim() > mahasiswa[j + 1].getNim())
                {
                    Mahasiswa temp = mahasiswa[j];
                    mahasiswa[j] = mahasiswa[j + 1];
                    mahasiswa[j + 1] = temp;
                }
            }
        }
    }

    public static void shellSort()
    {
        for(int bagi = jumlahData/2; bagi > 0; bagi /= 2)
        {
            for(int i = bagi; i < jumlahData; i += 1)
            {
                Mahasiswa temp = mahasiswa[i];
                int j;
                for(j = i; (j >= bagi) && (mahasiswa[j - bagi].getNim() > temp.getNim()); j -= bagi)
                {
                    mahasiswa[j] = mahasiswa[j - bagi];
                }
                mahasiswa[j] = temp;
            }
        }
    }

    public static void bis()
    {
        boolean tukar = true;
        int mulai = 0;
        int akhir = jumlahData;
        while(tukar == true)
        {
            tukar = false;
            for(int i = mulai; i < akhir - 1; ++i)
            {
                if(mahasiswa[i].getNim() > mahasiswa[i + 1].getNim())
                {
                    Mahasiswa temp = mahasiswa[i];
                    mahasiswa[i] = mahasiswa[i + 1];
                    mahasiswa[i + 1] = temp;
                    tukar = true;
                }
            }
            if(tukar == false)
            {
                break;
            }
            tukar = false;
            akhir = akhir - 1;
            for(int i = akhir - 1; i >= mulai; i--)
            {
                if(mahasiswa[i].getNim() > mahasiswa[i + 1].getNim())
                {
                    Mahasiswa temp = mahasiswa[i];
                    mahasiswa[i] = mahasiswa[i + 1];
                    mahasiswa[i + 1] = temp;
                    tukar = true;
                }
            }
            mulai = mulai + 1;
        }
    }
    public static void UAS()
    {
        if(jumlahData == 0)
        {
            System.out.println("Tidak ada data");
        } else
        {
            int jarak = jumlahData;
            int susut = 13;
            int urut = 0;

            while(urut == 0)
            {
                jarak = (jarak*10) / susut;
                if(jarak <= 1)
                {
                    jarak = 1;
                    urut = 1;
                }
                for(int i = 0; (i + jarak) < jumlahData; i++)
                {
                    if(mahasiswa[i].getNim() > mahasiswa[i + jarak].getNim())
                    {
                        Mahasiswa temp = mahasiswa[i];
                        mahasiswa[i] = mahasiswa[i+jarak];
                        mahasiswa[i+jarak] = temp;
                        urut = 0;
                    }
                }
            }
            System.out.println("Data telah diurutkan. Silahkan tampilkan data");
        }
    }


}
