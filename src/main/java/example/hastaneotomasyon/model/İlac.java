package example.hastaneotomasyon.model;


public class İlac {

    private int ilacId;
    private String ilacAdi;
    private int dozaj;
    private int hastaId;
    private int tedaviId;

    public int getIlacId() {
        return ilacId;
    }

    public void setIlacId(int ilacId) {
        this.ilacId = ilacId;
    }

    public String getIlacAdi() {
        return ilacAdi;
    }

    public void setIlacAdi(String ilacAdi) {
        this.ilacAdi = ilacAdi;
    }

    public int getDozaj() {
        return dozaj;
    }

    public void setDozaj(int dozaj) {
        this.dozaj = dozaj;
    }

    public int getHastaId() {
        return hastaId;
    }

    public void setHastaId(int hastaId) {
        this.hastaId = hastaId;
    }

    public int getTedaviId() {
        return tedaviId;
    }

    public void setTedaviId(int tedaviId) {
        this.tedaviId = tedaviId;
    }
}