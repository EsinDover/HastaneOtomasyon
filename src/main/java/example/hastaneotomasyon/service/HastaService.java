package example.hastaneotomasyon.service;

import example.hastaneotomasyon.model.Hasta;
import example.hastaneotomasyon.repository.HastaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HastaService {

    @Autowired
    private HastaRepository hastaRepository;

    public int addHasta(Hasta hasta) {
        return hastaRepository.save(hasta);
    }

    public Hasta getHastaById(int hastaId) {
        return hastaRepository.findById(hastaId);
    }

    public List<Hasta> getAllHasta() {
        return hastaRepository.findAll();
    }

    public int updateHasta(Hasta hasta) {
        return hastaRepository.update(hasta);
    }

    public int deleteHasta(int hastaId) {
        return hastaRepository.delete(hastaId);
    }
}

