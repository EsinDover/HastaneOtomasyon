package example.hastaneotomasyon.controller;

import example.hastaneotomasyon.model.Ziyaretci;
import example.hastaneotomasyon.service.ZiyaretciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ziyaretci")
public class ZiyaretciController {

    @Autowired
    private ZiyaretciService ziyaretciService;

    @GetMapping
    public List<Ziyaretci> getAllZiyaretci() {
        return ziyaretciService.getAllZiyaretci();
    }

    @PostMapping("/create")
    public String addZiyaretci(@RequestBody Ziyaretci ziyaretci) {
        ziyaretciService.addZiyaretci(ziyaretci);
        return "Ziyaretçi başarıyla eklendi!";
    }

    @GetMapping("/{id}")
    public Ziyaretci getZiyaretci(@PathVariable int id) {
        return ziyaretciService.getZiyaretciById(id);
    }

    @PutMapping("/{id}")
    public String updateZiyaretci(@PathVariable int id, @RequestBody Ziyaretci ziyaretci) {
        ziyaretci.setZiyaretciId(id);
        ziyaretciService.updateZiyaretci(ziyaretci);
        return "Ziyaretçi başarıyla güncellendi!";
    }

    @DeleteMapping("/{id}")
    public String deleteZiyaretci(@PathVariable int id) {
        ziyaretciService.deleteZiyaretci(id);
        return "Ziyaretçi başarıyla silindi!";
    }
}
