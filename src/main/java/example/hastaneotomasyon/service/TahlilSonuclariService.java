package example.hastaneotomasyon.service;


import example.hastaneotomasyon.model.Hasta;
import example.hastaneotomasyon.model.TahlilSonuclari;
import example.hastaneotomasyon.repository.TahlilSonuclariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TahlilSonuclariService {

    @Autowired
    private TahlilSonuclariRepository tahlilSonuclariRepository;

    public int addTahlilSonucu(TahlilSonuclari tahlilSonucu) {
        return tahlilSonuclariRepository.save(tahlilSonucu);
    }

    public List<TahlilSonuclari> getAllTahlilSonuclari() {
        return tahlilSonuclariRepository.findAll();
    }

    public TahlilSonuclari getTahlilSonucuById(int sonucId) {
        return tahlilSonuclariRepository.findById(sonucId);
    }

    public int updateTahlilSonucu(TahlilSonuclari tahlilSonucu) {
        return tahlilSonuclariRepository.update(tahlilSonucu);
    }

    public int deleteTahlilSonucu(int sonucId) {
        return tahlilSonuclariRepository.delete(sonucId);
    }
}
