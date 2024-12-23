package example.hastaneotomasyon.service;


import example.hastaneotomasyon.model.Hasta;
import example.hastaneotomasyon.model.Randevu;
import example.hastaneotomasyon.repository.RandevuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RandevuService {

    @Autowired
    private RandevuRepository randevuRepository;

    public int addRandevu(Randevu randevu) {
        return randevuRepository.save(randevu);
    }

    public List<Randevu> getAllRandevu() {
        return randevuRepository.findAll();
    }

    public Randevu getRandevuById(int randevuId) {
        return randevuRepository.findById(randevuId);
    }

    public int updateRandevu(Randevu randevu) {
        return randevuRepository.update(randevu);
    }

    public int deleteRandevu(int randevuId) {
        return randevuRepository.delete(randevuId);
    }
}
