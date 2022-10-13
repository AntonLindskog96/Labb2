import java.util.Objects;

public class Arrayproduct {

    String kategori;
    String produkt;
    double pris;
    int ean;

    public Arrayproduct(String kategori, String produkt, double pris, int ean) {
        this.kategori = kategori;
        this.produkt = produkt;
        this.pris = pris;
        this.ean = ean;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getProdukt() {
        return produkt;
    }

    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public double getEan() {
        return ean;
    }

    public void setEan(int ean) {
        this.ean = ean;
    }

    @Override
    public String toString() {
        return
                kategori +":" +
                " Produkt:" + produkt +" " +
                "Pris:" + pris +
                ":- QR:" + ean + " ---" ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arrayproduct that = (Arrayproduct) o;
        return pris == that.pris && ean == that.ean && kategori.equals(that.kategori) && produkt.equals(that.produkt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kategori, produkt, pris, ean);
    }
}
