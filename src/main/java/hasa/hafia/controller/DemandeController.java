package hasa.hafia.controller;
import hasa.hafia.entites.Demande;
import hasa.hafia.service.DemandeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/demande")
public class DemandeController {
    private final DemandeService service;

    public DemandeController(DemandeService service) {
        this.service = service;
    }

    @PostMapping
    public String create(Demande demandeur){
        System.out.println(demandeur);
        Demande saved = service.create(demandeur);
        //todo...
        return "views/demande";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id){
        Demande existing = service.findById(id);
        //todo...
        return "views/demande";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        //toto...
        return "views/demande";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id){
        Demande demande = service.findById(id);
        //todo...
        return "views/demande";
    }

    @GetMapping("/list")
    public String getAll(){
        List<Demande> demandes = service.findAll();
        //todo...
        return "views/demande";
    }

    @GetMapping
    public String index(){

        return "/views/demande";
    }
}
