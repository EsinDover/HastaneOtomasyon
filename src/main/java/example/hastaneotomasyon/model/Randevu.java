package example.hastaneotomasyon.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class Randevu {
    private int randevuId;
    private LocalDate randevuTarihi;
    private int hastaId;
    private int doktorId;
    private int sekreterId;

    public int getRandevuId() {
        return randevuId;
    }

    public void setRandevuId(int randevuId) {
        this.randevuId = randevuId;
    }

    public LocalDate getRandevuTarihi() {
        return randevuTarihi;
    }

    public void setRandevuTarihi(LocalDate randevuTarihi) {
        this.randevuTarihi = randevuTarihi;
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

    public int getSekreterId() {
        return sekreterId;
    }

    public void setSekreterId(int sekreterId) {
        this.sekreterId = sekreterId;
    }
}
