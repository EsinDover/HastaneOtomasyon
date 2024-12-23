package example.hastaneotomasyon.service;


import example.hastaneotomasyon.model.Bashekim;
import example.hastaneotomasyon.model.Bolum;
import example.hastaneotomasyon.repository.BolumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BolumService {

    @Autowired
    private BolumRepository bolumRepository;

    public List<Bolum> getAllBolum() {
        return bolumRepository.findAll();
    }

    public int addBolum(Bolum bolum) {
        return bolumRepository.save(bolum);
    }

    public Bolum getBolumById(int bolumId) {
        return bolumRepository.findById(bolumId);
    }

    public int updateBolum(Bolum bolum) {
        return bolumRepository.update(bolum);
    }

    public int deleteBolum(int bolumId) {
        return bolumRepository.delete(bolumId);
    }
}

