package example.hastaneotomasyon.controller;


import example.hastaneotomasyon.model.Doktor;
import example.hastaneotomasyon.model.Fatura;
import example.hastaneotomasyon.service.FaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fatura")
public class FaturaController {

    @Autowired
    private FaturaService faturaService;

    @PostMapping("/create")
    public String addFatura(@RequestBody Fatura fatura) {
        faturaService.addFatura(fatura);
        return "Fatura başarıyla eklendi!";
    }

    @GetMapping
    public List<Fatura> getAllFatura() {
        return faturaService.getAllFatura();
    }

    @GetMapping("/{id}")
    public Fatura getFatura(@PathVariable int id) {
        return faturaService.getFaturaById(id);
    }

    @PutMapping("/{id}")
    public String updateFatura(@PathVariable int id, @RequestBody Fatura fatura) {
        fatura.setFaturaId(id);
        faturaService.updateFatura(fatura);
        return "Fatura başarıyla güncellendi!";
    }

    @DeleteMapping("/{id}")
    public String deleteFatura(@PathVariable int id) {
        faturaService.deleteFatura(id);
        return "Fatura başarıyla silindi!";
    }
}


