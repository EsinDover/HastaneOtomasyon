package example.hastaneotomasyon.controller;

import example.hastaneotomasyon.model.Doktor;
import example.hastaneotomasyon.service.DoktorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doktor")
public class DoktorController {

    @Autowired
    private DoktorService doktorService;

    @GetMapping
    public List<Doktor> getAllDoktor() {
        return doktorService.getAllDoktor();
    }


    @GetMapping("/{id}")
    public Doktor getDoktor(@PathVariable int id) {
        return doktorService.getDoktorById(id);
    }

    @PostMapping("/create")
    public String addDoktor(@RequestBody Doktor doktor) {
        doktorService.addDoktor(doktor);
        return "Doktor başarıyla eklendi!";
    }

    @PutMapping("/{id}")
    public String updateDoktor(@PathVariable int id, @RequestBody Doktor doktor) {
        doktor.setDoktorId(id);
        doktorService.updateDoktor(doktor);
        return "Doktor başarıyla güncellendi!";
    }

    @DeleteMapping("/{id}")
    public String deleteDoktor(@PathVariable int id) {
        doktorService.deleteDoktor(id);
        return "Doktor başarıyla silindi!";
    }
}
