package example.hastaneotomasyon.controller;

import example.hastaneotomasyon.model.Hemsire;
import example.hastaneotomasyon.service.HemsireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hemsire")
public class HemsireController {

    @Autowired
    private HemsireService hemsireService;

    @GetMapping
    public List<Hemsire> getAllHemsire() {
        return hemsireService.getAllHemsire();
    }

    @GetMapping("/{id}")
    public Hemsire getHemsire(@PathVariable int id) {
        return hemsireService.getHemsireById(id);
    }

    @PostMapping("/create")
    public String addHemsire(@RequestBody Hemsire hemsire) {
        hemsireService.addHemsire(hemsire);
        return "Hemşire başarıyla eklendi!";
    }

    @PutMapping("/{id}")
    public String updateHemsire(@PathVariable int id, @RequestBody Hemsire hemsire) {
        hemsire.setHemsireId(id);
        hemsireService.updateHemsire(hemsire);
        return "Hemşire başarıyla güncellendi!";
    }

    @DeleteMapping("/{id}")
    public String deleteHemsire(@PathVariable int id) {
        hemsireService.deleteHemsire(id);
        return "Hemşire başarıyla silindi!";
    }
}
