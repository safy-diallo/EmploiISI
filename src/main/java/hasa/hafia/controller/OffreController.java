package hasa.hafia.controller;

import hasa.hafia.entites.Demande;
import hasa.hafia.entites.Offres;
import hasa.hafia.repository.OffreRepository;
import hasa.hafia.service.OffreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/offres")
//@PreAuthorize("hasAnyRole('ROLE_RECRUTEUR')")
public class OffreController {
   
	private final OffreService service;
    private static final String DEFAULT_VIEW = "views/offres";
    private static final String DEFAULT_REDIRECTION = "redirect:/offres";

    public OffreController(OffreService service) {
        this.service = service;
    }

    @GetMapping
    public String index () {
        //model.addAttribute("liste_offres", service.findAll());
        //model.addAttribute("offre", new Offres());
        return DEFAULT_VIEW.concat("/list");
    }
    @PreAuthorize("hasAnyRole('ROLE_RECRUTEUR')")
    @GetMapping("/listeOffre")
    public String listeDemande(Model model){
    	model.addAttribute("liste_offres", service.findAll());        
         return DEFAULT_VIEW.concat("/listeOffre");
    }
    @PreAuthorize("hasAnyRole('ROLE_RECRUTEUR')")
    @GetMapping("/ajoutOffre")
    public String addDemande(Model model){
    	model.addAttribute("offre", new Offres());
         return DEFAULT_VIEW.concat("/add");
    }
    @PreAuthorize("hasAnyRole('ROLE_RECRUTEUR')")
    @PostMapping
    public String add(@ModelAttribute("offre") Offres offre) {
        offre.setDemandes(null);
        service.create(offre);
        return DEFAULT_REDIRECTION;
    }
    @PreAuthorize("hasAnyRole('ROLE_RECRUTEUR')")
    @GetMapping("/edit")
    public String update(HttpServletRequest request, Model model){
        final Long id = Long.valueOf(request.getParameter("id"));
        Offres offres = service.findById(id);
        model.addAttribute("offre", offres);
        return DEFAULT_VIEW;
    }
    @PreAuthorize("hasAnyRole('ROLE_RECRUTEUR')")
    @GetMapping("/delete")
    public String delete (long id, Model model) {
        service.delete(id);
        model.addAttribute("liste_offre", service.findAll());//Pour la liste
        model.addAttribute("offre", new Offres());//Pour le formulaire
        return DEFAULT_REDIRECTION;
    }
    
    
/*   @PostMapping
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
    }*/
}
