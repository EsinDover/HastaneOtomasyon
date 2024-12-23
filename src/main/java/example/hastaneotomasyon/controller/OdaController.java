package example.hastaneotomasyon.controller;

import example.hastaneotomasyon.model.Oda;
import example.hastaneotomasyon.service.OdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oda")
public class OdaController {

    @Autowired
    private OdaService odaService;

    @GetMapping
    public List<Oda> getAllOda() {
        return odaService.getAllOda();
    }

    @PostMapping("/create")
    public String addOda(@RequestBody Oda oda) {
        odaService.addOda(oda);
        return "Oda başarıyla eklendi!";
    }

    @GetMapping("/{id}")
    public Oda getOda(@PathVariable int id) {
        return odaService.getOdaById(id);
    }

    @PutMapping("/{id}")
    public String updateOda(@PathVariable int id, @RequestBody Oda oda) {
        oda.setOdaId(id);
        odaService.updateOda(oda);
        return "Oda başarıyla güncellendi!";
    }

    @DeleteMapping("/{id}")
    public String deleteOda(@PathVariable int id) {
        odaService.deleteOda(id);
        return "Oda başarıyla silindi!";
    }
}
