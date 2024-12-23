package example.hastaneotomasyon.controller;

import example.hastaneotomasyon.model.Laboratuvar;
import example.hastaneotomasyon.service.LaboratuvarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laboratuvar")
public class LaboratuvarController {

    @Autowired
    private LaboratuvarService laboratuvarService;

    @GetMapping
    public List<Laboratuvar> getAllLaboratuvar() {
        return laboratuvarService.getAllLaboratuvar();
    }

    @PostMapping("/create")
    public String addLaboratuvar(@RequestBody Laboratuvar laboratuvar) {
        laboratuvarService.addLaboratuvar(laboratuvar);
        return "Laboratuvar başarıyla eklendi!";
    }

    @GetMapping("/{id}")
    public Laboratuvar getLaboratuvar(@PathVariable int id) {
        return laboratuvarService.getLaboratuvarById(id);
    }

    @PutMapping("/{id}")
    public String updateLaboratuvar(@PathVariable int id, @RequestBody Laboratuvar laboratuvar) {
        laboratuvar.setLaboratuvarId(id);
        laboratuvarService.updateLaboratuvar(laboratuvar);
        return "Laboratuvar başarıyla güncellendi!";
    }

    @DeleteMapping("/{id}")
    public String deleteLaboratuvar(@PathVariable int id) {
        laboratuvarService.deleteLaboratuvar(id);
        return "Laboratuvar başarıyla silindi!";
    }
}
