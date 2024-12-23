package example.hastaneotomasyon.model;


public class Hemsire {

    private int hemsireId;
    private String isim;
    private String soyisim;
    private int odaId;
    private int doktorId;

    // Getter ve Setter metodları
    public int getHemsireId() {
        return hemsireId;
    }

    public void setHemsireId(int hemsireId) {
        this.hemsireId = hemsireId;
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

    public int getOdaId() {
        return odaId;
    }

    public void setOdaId(int odaId) {
        this.odaId = odaId;
    }

    public int getDoktorId() {
        return doktorId;
    }

    public void setDoktorId(int doktorId) {
        this.doktorId = doktorId;
    }
}
