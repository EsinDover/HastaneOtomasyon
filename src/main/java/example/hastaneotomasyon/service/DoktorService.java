package example.hastaneotomasyon.service;

import example.hastaneotomasyon.model.Bashekim;
import example.hastaneotomasyon.model.Doktor;
import example.hastaneotomasyon.repository.DoktorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoktorService {

    @Autowired
    private DoktorRepository doktorRepository;


    public int addDoktor(Doktor doktor) {
        return doktorRepository.save(doktor);
    }
    public List<Doktor> getAllDoktor() {
        return doktorRepository.findAll();
    }

    public Doktor getDoktorById(int doktorId) {
        return doktorRepository.findById(doktorId);
    }

    public int updateDoktor(Doktor doktor) {
        return doktorRepository.update(doktor);
    }

    public int deleteDoktor(int doktorId) {
        return doktorRepository.delete(doktorId);
    }
}
