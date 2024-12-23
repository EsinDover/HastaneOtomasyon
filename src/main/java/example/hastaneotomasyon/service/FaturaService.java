package example.hastaneotomasyon.service;

import example.hastaneotomasyon.model.Doktor;
import example.hastaneotomasyon.model.Fatura;
import example.hastaneotomasyon.repository.FaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaturaService {

    @Autowired
    private FaturaRepository faturaRepository;

    public int addFatura(Fatura fatura) {
        return faturaRepository.save(fatura);
    }
    public List<Fatura> getAllFatura() {
        return faturaRepository.findAll();
    }

    public Fatura getFaturaById(int faturaId) {
        return faturaRepository.findById(faturaId);
    }

    public int updateFatura(Fatura fatura) {
        return faturaRepository.update(fatura);
    }

    public int deleteFatura(int faturaId) {
        return faturaRepository.delete(faturaId);
    }
}

