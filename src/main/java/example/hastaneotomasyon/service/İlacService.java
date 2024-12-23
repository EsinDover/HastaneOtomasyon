package example.hastaneotomasyon.service;

import example.hastaneotomasyon.model.İlac;
import example.hastaneotomasyon.repository.İlacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class İlacService {

    @Autowired
    private İlacRepository ilacRepository;

    public int addIlac(İlac ilac) {
        return ilacRepository.save(ilac);
    }

    public List<İlac> getAllIlac() {
        return ilacRepository.findAll();
    }

    public İlac getIlacById(int ilacId) {
        return ilacRepository.findById(ilacId);
    }

    public int updateIlac(İlac ilac) {
        return ilacRepository.update(ilac);
    }

    public int deleteIlac(int ilacId) {
        return ilacRepository.delete(ilacId);
    }
}
