package example.hastaneotomasyon.controller;

import example.hastaneotomasyon.model.Bolum;
import example.hastaneotomasyon.service.BolumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bolum")
public class BolumController {

    @Autowired
    private BolumService bolumService;

    @GetMapping
    public List<Bolum> getAllBolum() {
        return bolumService.getAllBolum();
    }

    @PostMapping("/create")
    public String addBolum(@RequestBody Bolum bolum) {
        bolumService.addBolum(bolum);
        return "Bölüm başarıyla eklendi!";
    }

    @GetMapping("/{id}")
    public Bolum getBolum(@PathVariable int id) {
        return bolumService.getBolumById(id);
    }

    @PutMapping("/{id}")
    public String updateBolum(@PathVariable int id, @RequestBody Bolum bolum) {
        bolum.setBolum_id(id);
        bolumService.updateBolum(bolum);
        return "Bölüm başarıyla güncellendi!";
    }

    @DeleteMapping("/{id}")
    public String deleteBolum(@PathVariable int id) {
        bolumService.deleteBolum(id);
        return "Bölüm başarıyla silindi!";
    }
}

