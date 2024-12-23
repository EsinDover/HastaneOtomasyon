package example.hastaneotomasyon.controller;

import example.hastaneotomasyon.model.İlac;
import example.hastaneotomasyon.service.İlacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ilac")
public class İlacController {

    @Autowired
    private İlacService ilacService;

    @GetMapping
    public List<İlac> getAllIlac() {
        return ilacService.getAllIlac();
    }

    @GetMapping("/{id}")
    public İlac getIlac(@PathVariable int id) {
        return ilacService.getIlacById(id);
    }

    @PostMapping("/create")
    public String addIlac(@RequestBody İlac ilac) {
        ilacService.addIlac(ilac);
        return "İlaç başarıyla eklendi!";
    }

    @PutMapping("/{id}")
    public String updateIlac(@PathVariable int id, @RequestBody İlac ilac) {
        ilac.setIlacId(id);
        ilacService.updateIlac(ilac);
        return "İlaç başarıyla güncellendi!";
    }

    @DeleteMapping("/{id}")
    public String deleteIlac(@PathVariable int id) {
        ilacService.deleteIlac(id);
        return "İlaç başarıyla silindi!";
    }
}
