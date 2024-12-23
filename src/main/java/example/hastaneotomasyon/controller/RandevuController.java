package example.hastaneotomasyon.controller;

import example.hastaneotomasyon.model.Randevu;
import example.hastaneotomasyon.service.RandevuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/randevu")
public class RandevuController {

    @Autowired
    private RandevuService randevuService;

    @GetMapping
    public List<Randevu> getAllRandevu() {
        return randevuService.getAllRandevu();
    }

    @PostMapping("/create")
    public String addRandevu(@RequestBody Randevu randevu) {
        randevuService.addRandevu(randevu);
        return "Randevu başarıyla eklendi!";
    }

    @GetMapping("/{id}")
    public Randevu getRandevu(@PathVariable int id) {
        return randevuService.getRandevuById(id);
    }

    @PutMapping("/{id}")
    public String updateRandevu(@PathVariable int id, @RequestBody Randevu randevu) {
        randevu.setRandevuId(id);
        randevuService.updateRandevu(randevu);
        return "Randevu başarıyla güncellendi!";
    }

    @DeleteMapping("/{id}")
    public String deleteRandevu(@PathVariable int id) {
        randevuService.deleteRandevu(id);
        return "Randevu başarıyla silindi!";
    }
}
