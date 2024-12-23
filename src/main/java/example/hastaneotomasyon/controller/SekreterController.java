package example.hastaneotomasyon.controller;

import example.hastaneotomasyon.model.Sekreter;
import example.hastaneotomasyon.service.SekreterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sekreter")
public class SekreterController {

    @Autowired
    private SekreterService sekreterService;

    @GetMapping
    public List<Sekreter> getAllSekreter() {
        return sekreterService.getAllSekreter();
    }

    @PostMapping("/create")
    public String addSekreter(@RequestBody Sekreter sekreter) {
        sekreterService.addSekreter(sekreter);
        return "Sekreter başarıyla eklendi!";
    }

    @GetMapping("/{id}")
    public Sekreter getSekreter(@PathVariable int id) {
        return sekreterService.getSekreterById(id);
    }

    @PutMapping("/{id}")
    public String updateSekreter(@PathVariable int id, @RequestBody Sekreter sekreter) {
        sekreter.setSekreterId(id);
        sekreterService.updateSekreter(sekreter);
        return "Sekreter başarıyla güncellendi!";
    }

    @DeleteMapping("/{id}")
    public String deleteSekreter(@PathVariable int id) {
        sekreterService.deleteSekreter(id);
        return "Sekreter başarıyla silindi!";
    }
}
