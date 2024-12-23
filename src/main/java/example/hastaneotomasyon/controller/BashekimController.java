package example.hastaneotomasyon.controller;


import example.hastaneotomasyon.model.Bashekim;
import example.hastaneotomasyon.service.BashekimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bashekim")
public class BashekimController {

    @Autowired
    private BashekimService bashekimService;

    @GetMapping
    public List<Bashekim> getAllBashekim() {
        return bashekimService.getAllBashekim();
    }
    @GetMapping("/withbolum")
    public List<String> getBashekimWithBolumNames() {
        return bashekimService.getBashekimWithBolumNames();
    }


    @GetMapping("/{id}")
    public Bashekim getBashekimById(@PathVariable int id) {
        return bashekimService.getBashekimById(id);
    }

    @PostMapping("/create")
    public String addBashekim(@RequestBody Bashekim bashekim) {
        bashekimService.addBashekim(bashekim);
        return "Başhekim added successfully!";
    }

    @PutMapping("/{id}")
    public String updateBashekim(@PathVariable int id, @RequestBody Bashekim bashekim) {
        bashekim.setBashekimId(id);
        bashekimService.updateBashekim(bashekim);
        return "Başhekim updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteBashekim(@PathVariable int id) {
        bashekimService.deleteBashekim(id);
        return "Başhekim deleted successfully!";
    }
}
