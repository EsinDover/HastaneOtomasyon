package example.hastaneotomasyon.model;


public class Tedavi {

    private int tedaviId;
    private int hastaId;
    private int doktorId;
    private int muayaneId;
    private int bolumId;
    private String tedaviTuru;

    public int getTedaviId() {
        return tedaviId;
    }

    public void setTedaviId(int tedaviId) {
        this.tedaviId = tedaviId;
    }

    public int getHastaId() {
        return hastaId;
    }

    public void setHastaId(int hastaId) {
        this.hastaId = hastaId;
    }

    public int getDoktorId() {
        return doktorId;
    }

    public void setDoktorId(int doktorId) {
        this.doktorId = doktorId;
    }

    public int getMuayaneId() {
        return muayaneId;
    }

    public void setMuayaneId(int muayaneId) {
        this.muayaneId = muayaneId;
    }

    public int getBolumId() {
        return bolumId;
    }

    public void setBolumId(int bolumId) {
        this.bolumId = bolumId;
    }

    public String getTedaviTuru() {
        return tedaviTuru;
    }

    public void setTedaviTuru(String tedaviTuru) {
        this.tedaviTuru = tedaviTuru;
    }
}

