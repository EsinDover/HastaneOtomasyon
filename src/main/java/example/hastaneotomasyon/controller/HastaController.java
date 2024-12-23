package example.hastaneotomasyon.controller;

import example.hastaneotomasyon.model.Hasta;
import example.hastaneotomasyon.service.HastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hasta")
public class HastaController {

    @Autowired
    private HastaService hastaService;

    @GetMapping
    public List<Hasta> getAllHasta() {
        return hastaService.getAllHasta();
    }

    @GetMapping("/{id}")
    public Hasta getHasta(@PathVariable int id) {
        return hastaService.getHastaById(id);
    }

    @PostMapping("/create")
    public String addHasta(@RequestBody Hasta hasta) {
        hastaService.addHasta(hasta);
        return "Hasta başarıyla eklendi!";
    }

    @PutMapping("/{id}")
    public String updateHasta(@PathVariable int id, @RequestBody Hasta hasta) {
        hasta.setHastaId(id);
        hastaService.updateHasta(hasta);
        return "Hasta başarıyla güncellendi!";
    }

    @DeleteMapping("/{id}")
    public String deleteHasta(@PathVariable int id) {
        hastaService.deleteHasta(id);
        return "Hasta başarıyla silindi!";
    }
}
