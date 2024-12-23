package example.hastaneotomasyon.service;

import example.hastaneotomasyon.model.Hemsire;
import example.hastaneotomasyon.repository.HemsireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HemsireService {

    @Autowired
    private HemsireRepository hemsireRepository;

    public int addHemsire(Hemsire hemsire) {
        return hemsireRepository.save(hemsire);
    }

    public List<Hemsire> getAllHemsire() {
        return hemsireRepository.findAll();
    }

    public Hemsire getHemsireById(int hemsireId) {
        return hemsireRepository.findById(hemsireId);
    }

    public int updateHemsire(Hemsire hemsire) {
        return hemsireRepository.update(hemsire);
    }

    public int deleteHemsire(int hemsireId) {
        return hemsireRepository.delete(hemsireId);
    }
}

