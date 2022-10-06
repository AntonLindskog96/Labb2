import java.util.Objects;

public class Arrayproduct {

    String kategori;
    String produkt;
    int pris;
    int ean;

    public Arrayproduct(String kategori, String produkt, int pris, int ean) {
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

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public int getEan() {
        return ean;
    }

    public void setEan(int ean) {
        this.ean = ean;
    }

    @Override
    public String toString() {
        return
                kategori +":" +
                " produkt:" + produkt +" " +
                "pris:" + pris +
                ":- QR" + ean + " ---" ;
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
