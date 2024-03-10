package POSTTEST1;
import java.util.ArrayList;
import java.util.Scanner;


class BeansKopi {
    public String Biji;
    public String Jenis;
    public int Harga;
}

class AsalBeans {
    public String Negara;
    public String Daerah;
}

public class posttest1 {
    static Scanner input = new Scanner(System.in);

    public static void tampilkanData(ArrayList<BeansKopi> beans, ArrayList<AsalBeans> asalKopi){
        System.out.println("Data Kopi:");
        System.out.println("No\tBiji\tJenis\tHarga\tNegara\tDaerah");
        for (int i = 0; i < beans.size(); i++) {
            BeansKopi bean = beans.get(i);
            AsalBeans asal = asalKopi.get(i);
            System.out.println((i+1) + "\t" + bean.Biji + "\t" + bean.Jenis + "\t" + bean.Harga + "\t" + asal.Negara + "\t" + asal.Daerah);
        }
    }

    public static void tambahKopi(ArrayList<BeansKopi> beans, ArrayList<AsalBeans> asal){
        // Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        BeansKopi newBean = new BeansKopi();
        AsalBeans newAsal = new AsalBeans();

        System.out.print("Masukkan data kopi baru:\n");
        System.out.print("Biji: ");
        newBean.Biji = input.nextLine();
        System.out.print("Jenis: ");
        newBean.Jenis = input.nextLine();
        System.out.print("Harga: ");
        newBean.Harga = input.nextInt();
        input.nextLine();  
        System.out.print("Asal Negara: ");
        newAsal.Negara = input.nextLine();
        System.out.print("Asal Daerah: ");
        newAsal.Daerah = input.nextLine();

        beans.add(newBean);
        asal.add(newAsal);

        System.out.println("Data kopi telah ditambahkan.");
    }
    public static void hapusData(ArrayList<BeansKopi> beans, ArrayList<AsalBeans> asal){
        tampilkanData(beans,asal);
        System.out.print("Masukkan indeks data kopi yang akan dihapus: ");
        int index = input.nextInt();
        if (index >= 0 && index < beans.size()) {
            beans.remove(index-1);
            asal.remove(index-1);
            System.out.println("Data kopi telah dihapus.");
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    public static void updateData(ArrayList<BeansKopi> beans, ArrayList<AsalBeans> asal){
        tampilkanData(beans, asal);
        System.out.print("Masukkan indeks data kopi yang akan diupdate: ");
        int index = input.nextInt();
        if (index >= 0 && index < beans.size()) {
            BeansKopi beanUpdate = beans.get(index-1);
            AsalBeans asalUpdate= asal.get(index-1);
            System.out.println("Masukkan data baru:");
            System.out.print("Biji: ");
            beanUpdate.Biji = input.next();
            System.out.print("Jenis: ");
            beanUpdate.Jenis = input.next();
            System.out.print("Harga: ");
            beanUpdate.Harga = input.nextInt();
            input.nextLine();  
            System.out.print("Asal Negara: ");
            asalUpdate.Negara = input.nextLine();
            System.out.print("Asal Daerah: ");
            asalUpdate.Daerah = input.nextLine();
            System.out.println("Data kopi telah diupdate.");
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    public static void main(String[] args) {
        
        ArrayList<BeansKopi> beans = new ArrayList<>();
        ArrayList<AsalBeans> asalKopi = new ArrayList<>();
        
        boolean run = true;
        while (run) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan Data Kopi");
            System.out.println("2. Tambah Data Kopi");
            System.out.println("3. Hapus Data Kopi");
            System.out.println("4. Update Data Kopi");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    tampilkanData(beans, asalKopi);
                    
                    break;
                case 2:
                    tambahKopi(beans, asalKopi);
                    
                    break;
                case 3:
                    hapusData(beans, asalKopi);
                    
                    break;
                case 4:
                    updateData(beans, asalKopi);
                    
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        System.out.println("Program berakhir.");
    }
}
