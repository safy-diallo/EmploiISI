package hasa.hafia.controller;

import hasa.hafia.entites.Offres;
import hasa.hafia.service.OffreService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/offres")
@PreAuthorize("hasAnyRole('ROLE_RECRUTEUR')")
public class OffreController {
    private final OffreService service;
    private static final String DEFAULT_VIEW = "views/offres/index";
    public OffreController(OffreService service) {
        this.service = service;
    }

    @PostMapping
    public String create(Offres offres){
        Offres saved = service.create(offres);
        //todo
        return DEFAULT_VIEW;
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, Offres offres){
        Offres updated = service.update(id, offres);
        //todo...
        return DEFAULT_VIEW;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable  Long id){
        service.delete(id);
        //todo...
        return DEFAULT_VIEW;
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id){
        Offres offres = service.findById(id);
        //todo...
        return DEFAULT_VIEW;
    }

    @GetMapping("/list")
    public String getAll(){
        List<Offres> offres = service.findAll();
        //todo...
        return DEFAULT_VIEW;
    }

    @GetMapping
    public String home(){
        return DEFAULT_VIEW;
    }
}
