package example.hastaneotomasyon.service;


import example.hastaneotomasyon.model.Hasta;
import example.hastaneotomasyon.model.Sekreter;
import example.hastaneotomasyon.repository.SekreterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SekreterService {

    @Autowired
    private SekreterRepository sekreterRepository;

    public int addSekreter(Sekreter sekreter) {
        return sekreterRepository.save(sekreter);
    }

    public Sekreter getSekreterById(int sekreterId) {
        return sekreterRepository.findById(sekreterId);
    }

    public List<Sekreter> getAllSekreter() {
        return sekreterRepository.findAll();
    }

    public int updateSekreter(Sekreter sekreter) {
        return sekreterRepository.update(sekreter);
    }

    public int deleteSekreter(int sekreterId) {
        return sekreterRepository.delete(sekreterId);
    }
}
