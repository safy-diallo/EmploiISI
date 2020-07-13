package hasa.hafia.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hasa.hafia.entites.Demande;
import hasa.hafia.repository.DemandeRepository;
import hasa.hafia.service.DemandeService;

@Controller
@RequestMapping("/demande")
//@PreAuthorize("hasAnyRole('ROLE_DEMANDEUR')")
public class DemandeController {
    private final DemandeService service;
    private static final String DEFAULT_VIEW = "views/demande/index";
    @Autowired
    private DemandeRepository demandedao;
    public DemandeController(DemandeService service) {
        this.service = service;
    }

    @RequestMapping("/liste")
    public String listeCandidat (ModelMap map)
    {
    	 map.addAttribute("liste_candidat", demandedao.findAll());//Pour la liste
         map.addAttribute("demande", new Demande());//Pour le formulaire

    	return "views/demande/add";
    }
    
    
@RequestMapping(value = "/ajout", method = { RequestMethod.GET, RequestMethod.POST })
	
	public String add(long id,String nom, String prenom,String experience,String niveauEtude,String motivation) 
	{
		Demande demande=new Demande();
		demande.setId(id);
		demande.setNom(nom);
		demande.setPrenom(prenom);
		demande.setExperience(Integer.parseInt(experience));		
		demande.setMotivation(motivation);
		demande.setNiveauEtude(niveauEtude);		
		System.out.println("======================================================");
		System.out.println(Integer.parseInt(experience)+""+""+niveauEtude+""+motivation+"");
		System.out.println("======================================================");
		try {
			demandedao.save(demande);//ajout ou mise à jour
			demandedao.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "views/demande/add";		
	}
@RequestMapping(value="/delete", method = RequestMethod.GET)
public String delete (long id)
{
	try {
		demandedao.delete(demandedao.getOne(id));
		demandedao.flush();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return "Redirect:/views/demande/add";
	
}

@RequestMapping(value="/edit",method = RequestMethod.GET)
public String edit (long id,ModelMap model)
{
	try {
		List<Demande> demandes = demandedao.findAll();
		model.put("liste_candidat", demandes);
		Demande demande=  demandedao.getOne(id);
		model.put("demande", demande);
	} 
	catch (Exception e) {
		e.printStackTrace();
	}		
	return "views/demande/add";
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
