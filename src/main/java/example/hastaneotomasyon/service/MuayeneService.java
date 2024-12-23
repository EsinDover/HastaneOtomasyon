package example.hastaneotomasyon.service;


import example.hastaneotomasyon.model.Hasta;
import example.hastaneotomasyon.model.Muayene;
import example.hastaneotomasyon.repository.MuayeneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuayeneService {

    @Autowired
    private MuayeneRepository muayeneRepository;

    public int addMuayene(Muayene muayene) {
        return muayeneRepository.save(muayene);
    }
    public List<Muayene> getAllMuayene() {
        return muayeneRepository.findAll();
    }

    public Muayene getMuayeneById(int muayeneId) {
        return muayeneRepository.findById(muayeneId);
    }

    public int updateMuayene(Muayene muayene) {
        return muayeneRepository.update(muayene);
    }

    public int deleteMuayene(int muayeneId) {
        return muayeneRepository.delete(muayeneId);
    }
}


