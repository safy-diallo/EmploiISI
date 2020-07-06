package hasa.hafia.controller;
import hasa.hafia.entites.Demande;
import hasa.hafia.service.DemandeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/demande")
@PreAuthorize("hasAnyRole('ROLE_DEMANDEUR')")
public class DemandeController {
    private final DemandeService service;
    private static final String DEFAULT_VIEW = "views/demande/index";
    public DemandeController(DemandeService service) {
        this.service = service;
    }

    @PostMapping
    public String create(Demande demandeur){
        System.out.println(demandeur);
        Demande saved = service.create(demandeur);
        //todo...
        return DEFAULT_VIEW;
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id){
        Demande existing = service.findById(id);
        //todo...
        return DEFAULT_VIEW;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        //toto...
        return DEFAULT_VIEW;
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id){
        Demande demande = service.findById(id);
        //todo...
        return DEFAULT_VIEW;
    }

    @GetMapping("/list")
    public String getAll(){
        List<Demande> demandes = service.findAll();
        //todo...
        return DEFAULT_VIEW;
    }

    @GetMapping
    public String index(){

        return DEFAULT_VIEW;
    }
}
