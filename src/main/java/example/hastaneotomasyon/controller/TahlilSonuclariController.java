package example.hastaneotomasyon.controller;

import example.hastaneotomasyon.model.TahlilSonuclari;
import example.hastaneotomasyon.service.TahlilSonuclariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tahlilsonuclari")
public class TahlilSonuclariController {

    @Autowired
    private TahlilSonuclariService tahlilSonuclariService;

    @GetMapping
    public List<TahlilSonuclari> getAllTahlilSonuclari() {
        return tahlilSonuclariService.getAllTahlilSonuclari();
    }

    @PostMapping("/create")
    public String addTahlilSonucu(@RequestBody TahlilSonuclari tahlilSonucu) {
        tahlilSonuclariService.addTahlilSonucu(tahlilSonucu);
        return "Tahlil sonucu başarıyla eklendi!";
    }

    @GetMapping("/{id}")
    public TahlilSonuclari getTahlilSonucu(@PathVariable int id) {
        return tahlilSonuclariService.getTahlilSonucuById(id);
    }

    @PutMapping("/{id}")
    public String updateTahlilSonucu(@PathVariable int id, @RequestBody TahlilSonuclari tahlilSonucu) {
        tahlilSonucu.setSonucId(id);
        tahlilSonuclariService.updateTahlilSonucu(tahlilSonucu);
        return "Tahlil sonucu başarıyla güncellendi!";
    }

    @DeleteMapping("/{id}")
    public String deleteTahlilSonucu(@PathVariable int id) {
        tahlilSonuclariService.deleteTahlilSonucu(id);
        return "Tahlil sonucu başarıyla silindi!";
    }
}
