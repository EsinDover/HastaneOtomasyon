package example.hastaneotomasyon.model;


public class TahlilSonuclari {

    private int sonucId;
    private int hastaId;
    private String sonuc;

    // Getter ve Setter metodları
    public int getSonucId() {
        return sonucId;
    }

    public void setSonucId(int sonucId) {
        this.sonucId = sonucId;
    }

    public int getHastaId() {
        return hastaId;
    }

    public void setHastaId(int hastaId) {
        this.hastaId = hastaId;
    }

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }
}
