package example.hastaneotomasyon.controller;

import example.hastaneotomasyon.model.Tedavi;
import example.hastaneotomasyon.service.TedaviService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tedavi")
public class TedaviController {

    @Autowired
    private TedaviService tedaviService;

    @GetMapping
    public List<Tedavi> getAllTedavi() {
        return tedaviService.getAllTedavi();
    }

    @PostMapping("/create")
    public String addTedavi(@RequestBody Tedavi tedavi) {
        tedaviService.addTedavi(tedavi);
        return "Tedavi başarıyla eklendi!";
    }

    @GetMapping("/{id}")
    public Tedavi getTedavi(@PathVariable int id) {
        return tedaviService.getTedaviById(id);
    }

    @PutMapping("/{id}")
    public String updateTedavi(@PathVariable int id, @RequestBody Tedavi tedavi) {
        tedavi.setTedaviId(id);
        tedaviService.updateTedavi(tedavi);
        return "Tedavi başarıyla güncellendi!";
    }

    @DeleteMapping("/{id}")
    public String deleteTedavi(@PathVariable int id) {
        tedaviService.deleteTedavi(id);
        return "Tedavi başarıyla silindi!";
    }
}
