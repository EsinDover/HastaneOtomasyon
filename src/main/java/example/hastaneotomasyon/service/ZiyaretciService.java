package example.hastaneotomasyon.service;

import example.hastaneotomasyon.model.Hasta;
import example.hastaneotomasyon.model.Ziyaretci;
import example.hastaneotomasyon.repository.ZiyaretciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZiyaretciService {

    @Autowired
    private ZiyaretciRepository ziyaretciRepository;

    public int addZiyaretci(Ziyaretci ziyaretci) {
        return ziyaretciRepository.save(ziyaretci);
    }

    public List<Ziyaretci> getAllZiyaretci() {
        return ziyaretciRepository.findAll();
    }

    public Ziyaretci getZiyaretciById(int ziyaretciId) {
        return ziyaretciRepository.findById(ziyaretciId);
    }

    public int updateZiyaretci(Ziyaretci ziyaretci) {
        return ziyaretciRepository.update(ziyaretci);
    }

    public int deleteZiyaretci(int ziyaretciId) {
        return ziyaretciRepository.delete(ziyaretciId);
    }
}
