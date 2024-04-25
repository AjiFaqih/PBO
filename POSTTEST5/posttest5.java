package POSTTEST5;
import java.util.ArrayList;
import java.util.Scanner;

public final class posttest5 {
    static final Scanner input = new Scanner(System.in);

    public static void tampilkanData(ArrayList<BeansKopi> beans, ArrayList<AsalBeans> asalKopi) {
        System.out.println("Data Kopi:");
        System.out.println("No\tBiji\tJenis\tHarga\tNegara\tDaerah");
        for (int i = 0; i < beans.size(); i++) {
            BeansKopi bean = beans.get(i);
            AsalBeans asal = asalKopi.get(i);
            System.out.println((i + 1) + "\t" + bean.getBiji() + "\t" + bean.getJenis() + "\t" + bean.getHarga()
                    + "\t" + asal.getNegara() + "\t" + asal.getDaerah());
        }
    }

    public static void tambahKopi(ArrayList<BeansKopi> beans, ArrayList<AsalBeans> asal) {
        Scanner input = new Scanner(System.in);
        BeansKopi newBean = null;
        AsalBeans newAsal = null; 

        System.out.println("Masukkan data kopi baru:");
        System.out.print("Biji: ");
        String biji = input.nextLine();
        System.out.println("Pilih jenis kopi:");
        System.out.println("1. Arabica");
        System.out.println("2. Robusta");
        System.out.print("Pilihan: ");
        int pilihan = input.nextInt();
        input.nextLine();
        System.out.print("Harga: ");
        int harga = input.nextInt();
        input.nextLine();
        newAsal = new AsalBeans() {
            private String negara;
            private String daerah;
            
            @Override
            public void setNegara(String negara) {
                this.negara = negara;
            }
            
            @Override
            public void setDaerah(String daerah) {
                this.daerah = daerah;
            }
            
            @Override
            public String getNegara() {
                return negara;
            }
            
            @Override
            public String getDaerah() {
                return daerah;
            }
        };
        System.out.print("Asal Negara: ");
        newAsal.setNegara(input.nextLine());
        System.out.print("Asal Daerah: ");
        newAsal.setDaerah(input.nextLine());

        switch (pilihan) {
            case 1:
                newBean = new Arabica(biji);
                break;
            case 2:
                newBean = new Robusta(biji);
                break;
            default:
                System.out.println("Jenis kopi tidak valid.");
                return;
        }

        newBean.setHarga(harga);

        beans.add(newBean);
        asal.add(newAsal);

        System.out.println("Data kopi telah ditambahkan.");
    }

    public static void hapusData(ArrayList<BeansKopi> beans, ArrayList<AsalBeans> asal) {
        tampilkanData(beans, asal);
        System.out.print("Masukkan indeks data kopi yang akan dihapus: ");
        int index = input.nextInt();
        if (index > 0 && index <= beans.size()) {
            beans.remove(index - 1);
            asal.remove(index - 1);
            System.out.println("Data kopi telah dihapus.");
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    public static void updateData(ArrayList<BeansKopi> beans, ArrayList<AsalBeans> asal) {
        tampilkanData(beans, asal);
        System.out.print("Masukkan indeks data kopi yang akan diupdate: ");
        int index = input.nextInt();
        if (index > 0 && index <= beans.size()) {
            BeansKopi beanUpdate = beans.get(index - 1);
            AsalBeans asalUpdate = asal.get(index - 1);
            System.out.println("Masukkan data baru:");
            System.out.print("Jenis: ");
            beanUpdate.setJenis(input.next());
            System.out.print("Harga: ");
            beanUpdate.setHarga(input.nextInt());
            input.nextLine();
            System.out.print("Asal Negara: ");
            asalUpdate.setNegara(input.nextLine());
            System.out.print("Asal Daerah: ");
            asalUpdate.setDaerah(input.nextLine());
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

abstract class BeansKopi {
    private final String biji;
    private String jenis;
    private int harga;

    public BeansKopi(String biji) {
        this.biji = biji;
    }

    public final String getBiji() {
        return biji;
    }

    public final void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public final String getJenis() {
        return jenis;
    }

    public final void setHarga(int harga) {
        this.harga = harga;
    }

    public final int getHarga() {
        return harga;
    }

    public abstract void setJenisArabica();

    public abstract void setJenisRobusta();

    @Override
    public String toString() {
        return biji + "\t" + jenis + "\t" + harga;
    }
}

abstract class AsalBeans {
    public abstract String getNegara();

    public abstract void setNegara(String negara);

    public abstract String getDaerah();

    public abstract void setDaerah(String daerah);
}

final class Arabica extends BeansKopi {
    public Arabica(String biji) {
        super(biji);
        setJenisArabica();
    }

    @Override
    public final void setJenisArabica() {
        this.setJenis("Arabica");
    }

    @Override
    public final void setJenisRobusta() {
        // Kosong karena jenis Arabica tidak dapat diubah menjadi Robusta
    }
}

final class Robusta extends BeansKopi {
    public Robusta(String biji) {
        super(biji);
        setJenisRobusta();
    }

    @Override
    public final void setJenisArabica() {
        // Kosong karena jenis Robusta tidak dapat diubah menjadi Arabica
    }

    @Override
    public final void setJenisRobusta() {
        this.setJenis("Robusta");
    }
}
