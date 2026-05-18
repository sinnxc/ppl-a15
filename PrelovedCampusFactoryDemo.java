public class PrelovedCampusFactoryDemo {
    public static void main(String[] args) {
        System.out.println("--- Penjual Menambahkan Buku ---");
        ListingFactory bookFactory = new BookListingFactory();
        bookFactory.publishListing("Buku Kalkulus I");

        System.out.println("\n--- Penjual Menambahkan Elektronik ---");
        ListingFactory electronicFactory = new ElectronicListingFactory();
        electronicFactory.publishListing("Kalkulator Scientific Casio");
    }
}

// 1. Interface Produk
interface ProductListing {
    void prepareListing(String namaBarang);
    void validateListing();
}

// 2. Concrete Product A
class BookListing implements ProductListing {
    @Override
    public void prepareListing(String namaBarang) {
        System.out.println("[BookListing] Mengatur kategori menjadi 'Buku & Alat Tulis' untuk: " + namaBarang);
    }

    @Override
    public void validateListing() {
        System.out.println("[BookListing] Validasi khusus buku: Memeriksa kelengkapan halaman dan kondisi sampul...");
    }
}

// 3. Concrete Product B
class ElectronicListing implements ProductListing {
    @Override
    public void prepareListing(String namaBarang) {
        System.out.println("[ElectronicListing] Mengatur kategori menjadi 'Barang Elektronik' untuk: " + namaBarang);
    }

    @Override
    public void validateListing() {
        System.out.println(
                "[ElectronicListing] Validasi khusus elektronik: Memastikan barang berfungsi dan tidak konslet...");
    }
}

// 4. Creator (Abstract Factory)
abstract class ListingFactory {
    // Factory Method
    protected abstract ProductListing createListing();

    // Core logic yang menggunakan factory method
    public void publishListing(String namaBarang) {
        ProductListing listing = createListing();
        listing.prepareListing(namaBarang);
        listing.validateListing();
        System.out.println("[Sistem] Barang '" + namaBarang + "' berhasil dipublikasikan ke marketplace!");
    }
}

// 5. Concrete Creator A
class BookListingFactory extends ListingFactory {
    @Override
    protected ProductListing createListing() {
        return new BookListing();
    }
}

// 6. Concrete Creator B
class ElectronicListingFactory extends ListingFactory {
    @Override
    protected ProductListing createListing() {
        return new ElectronicListing();
    }
}