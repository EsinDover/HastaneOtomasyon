package example.hastaneotomasyon.model;


public class Sekreter {

    private int sekreterId;
    private String isim;
    private String soyisim;
    private int doktorId;

    public int getSekreterId() {
        return sekreterId;
    }

    public void setSekreterId(int sekreterId) {
        this.sekreterId = sekreterId;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public int getDoktorId() {
        return doktorId;
    }

    public void setDoktorId(int doktorId) {
        this.doktorId = doktorId;
    }
}
