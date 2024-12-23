package example.hastaneotomasyon.model;


public class Muayene {

    private int muayeneId;
    private int hastaId;
    private int doktorId;
    private int bolumId;

    // Getter ve Setter metodları
    public int getMuayeneId() {
        return muayeneId;
    }

    public void setMuayeneId(int muayeneId) {
        this.muayeneId = muayeneId;
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

    public int getBolumId() {
        return bolumId;
    }

    public void setBolumId(int bolumId) {
        this.bolumId = bolumId;
    }
}
