package hasa.hafia.controller;

import hasa.hafia.entites.Offres;
import hasa.hafia.service.OffreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/offres")
public class OffreController {
    private final OffreService service;

    public OffreController(OffreService service) {
        this.service = service;
    }

    @PostMapping
    public String create(Offres offres){
        Offres saved = service.create(offres);
        //todo
        return "views/offres";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, Offres offres){
        Offres updated = service.update(id, offres);
        //todo...
        return "views/offres";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable  Long id){
        service.delete(id);
        //todo...
        return "views/offres";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id){
        Offres offres = service.findById(id);
        //todo...
        return "views/offres";
    }

    @GetMapping("/list")
    public String getAll(){
        List<Offres> offres = service.findAll();
        //todo...
        return "views/offres";
    }

    @GetMapping
    public String home(){
        return "views/offres";
    }
}
