package example.hastaneotomasyon.controller;

import example.hastaneotomasyon.model.Muayene;
import example.hastaneotomasyon.service.MuayeneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/muayene")
public class MuayeneController {

    @Autowired
    private MuayeneService muayeneService;

    @GetMapping
    public List<Muayene> getAllMuayene() {
        return muayeneService.getAllMuayene();
    }

    @PostMapping("/create")
    public String addMuayene(@RequestBody Muayene muayene) {
        muayeneService.addMuayene(muayene);
        return "Muayene başarıyla eklendi!";
    }

    @GetMapping("/{id}")
    public Muayene getMuayene(@PathVariable int id) {
        return muayeneService.getMuayeneById(id);
    }

    @PutMapping("/{id}")
    public String updateMuayene(@PathVariable int id, @RequestBody Muayene muayene) {
        muayene.setMuayeneId(id);
        muayeneService.updateMuayene(muayene);
        return "Muayene başarıyla güncellendi!";
    }

    @DeleteMapping("/{id}")
    public String deleteMuayene(@PathVariable int id) {
        muayeneService.deleteMuayene(id);
        return "Muayene başarıyla silindi!";
    }
}
