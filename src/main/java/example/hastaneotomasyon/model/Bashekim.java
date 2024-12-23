package example.hastaneotomasyon.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Bashekim {
    private int bashekimId;
    private String isim;
    private String soyisim;
    private int bolumId;


    public int getBashekimId() {
        return bashekimId;
    }

    public void setBashekimId(int bashekimId) {
        this.bashekimId = bashekimId;
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

    public int getBolumId() {
        return bolumId;
    }

    public void setBolumId(int bolumId) {
        this.bolumId = bolumId;
    }

    @Override
    public String toString() {
        return "Bashekim{" +
                "bashekimId=" + bashekimId +
                ", isim='" + isim + '\'' +
                ", soyisim='" + soyisim + '\'' +
                ", bolumId=" + bolumId +
                '}';
    }
}
