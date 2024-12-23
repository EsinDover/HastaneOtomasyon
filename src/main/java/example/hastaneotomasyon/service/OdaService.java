package example.hastaneotomasyon.service;

import example.hastaneotomasyon.model.Hasta;
import example.hastaneotomasyon.model.Oda;
import example.hastaneotomasyon.repository.OdaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdaService {

    @Autowired
    private OdaRepository odaRepository;

    public int addOda(Oda oda) {
        return odaRepository.save(oda);
    }

    public Oda getOdaById(int odaId) {
        return odaRepository.findById(odaId);
    }
    public List<Oda> getAllOda() {
        return odaRepository.findAll();
    }

    public int updateOda(Oda oda) {
        return odaRepository.update(oda);
    }

    public int deleteOda(int odaId) {
        return odaRepository.delete(odaId);
    }
}
