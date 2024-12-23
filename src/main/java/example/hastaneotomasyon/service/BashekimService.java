package example.hastaneotomasyon.service;


import example.hastaneotomasyon.model.Bashekim;
import example.hastaneotomasyon.repository.BashekimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BashekimService {

    @Autowired
    private BashekimRepository bashekimRepository;

    public List<Bashekim> getAllBashekim() {
        return bashekimRepository.findAll();
    }

    public Bashekim getBashekimById(int id) {
        return bashekimRepository.findById(id);
    }

    public List<String> getBashekimWithBolumNames() {
        return bashekimRepository.findBashekimWithBolumNames();
    }


    public int addBashekim(Bashekim bashekim) {
        return bashekimRepository.save(bashekim);
    }

    public int updateBashekim(Bashekim bashekim) {
        return bashekimRepository.update(bashekim);
    }

    public int deleteBashekim(int id) {
        return bashekimRepository.delete(id);
    }
}
