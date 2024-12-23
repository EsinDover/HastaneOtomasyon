package example.hastaneotomasyon.service;


import example.hastaneotomasyon.model.Hasta;
import example.hastaneotomasyon.model.Tedavi;
import example.hastaneotomasyon.repository.TedaviRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TedaviService {

    @Autowired
    private TedaviRepository tedaviRepository;

    public int addTedavi(Tedavi tedavi) {
        return tedaviRepository.save(tedavi);
    }

    public List<Tedavi> getAllTedavi() {
        return tedaviRepository.findAll();
    }

    public Tedavi getTedaviById(int tedaviId) {
        return tedaviRepository.findById(tedaviId);
    }

    public int updateTedavi(Tedavi tedavi) {
        return tedaviRepository.update(tedavi);
    }

    public int deleteTedavi(int tedaviId) {
        return tedaviRepository.delete(tedaviId);
    }
}

