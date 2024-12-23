package example.hastaneotomasyon.service;


import example.hastaneotomasyon.model.Hasta;
import example.hastaneotomasyon.model.Laboratuvar;
import example.hastaneotomasyon.repository.LaboratuvarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratuvarService {

    @Autowired
    private LaboratuvarRepository laboratuvarRepository;

    public int addLaboratuvar(Laboratuvar laboratuvar) {
        return laboratuvarRepository.save(laboratuvar);
    }

    public List<Laboratuvar> getAllLaboratuvar() {
        return laboratuvarRepository.findAll();
    }

    public Laboratuvar getLaboratuvarById(int laboratuvarId) {
        return laboratuvarRepository.findById(laboratuvarId);
    }

    public int updateLaboratuvar(Laboratuvar laboratuvar) {
        return laboratuvarRepository.update(laboratuvar);
    }

    public int deleteLaboratuvar(int laboratuvarId) {
        return laboratuvarRepository.delete(laboratuvarId);
    }
}

