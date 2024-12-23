package example.hastaneotomasyon.model;

public class Ziyaretci {

    private int ziyaretciId;
    private int hastaId;
    private String ziyaretciAdi;
    private String ziyaretSaati;
    private String iliski;


    public int getZiyaretciId() {
        return ziyaretciId;
    }

    public void setZiyaretciId(int ziyaretciId) {
        this.ziyaretciId = ziyaretciId;
    }

    public int getHastaId() {
        return hastaId;
    }

    public void setHastaId(int hastaId) {
        this.hastaId = hastaId;
    }

    public String getZiyaretciAdi() {
        return ziyaretciAdi;
    }

    public void setZiyaretciAdi(String ziyaretciAdi) {
        this.ziyaretciAdi = ziyaretciAdi;
    }

    public String getZiyaretSaati() {
        return ziyaretSaati;
    }

    public void setZiyaretSaati(String ziyaretSaati) {
        this.ziyaretSaati = ziyaretSaati;
    }

    public String getIliski() {
        return iliski;
    }

    public void setIliski(String iliski) {
        this.iliski = iliski;
    }
}

