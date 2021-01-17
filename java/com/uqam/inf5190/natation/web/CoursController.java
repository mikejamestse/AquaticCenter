package com.uqam.inf5190.natation.web;


import com.uqam.inf5190.natation.dao.CoursProduitRepository;
import com.uqam.inf5190.natation.dao.CoursRepository;
import com.uqam.inf5190.natation.dao.UserRepository;
import com.uqam.inf5190.natation.entities.Cours;
import com.uqam.inf5190.natation.entities.CoursProduit;
import com.uqam.inf5190.natation.entities.User;
import com.uqam.inf5190.natation.entities.enums.Niveau;
import com.uqam.inf5190.natation.entities.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cours")
public class CoursController {

    // avant tout, creer notre repository, c'est l'entite qui va se charger fire les operations CRUD & custom sur la BD
    // on utilisera l'annotation @Autowired pour implementer notre bean

    @Autowired
    private CoursProduitRepository coursProduitRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CoursRepository coursRepository;
    
    @RequestMapping(value="afficherCours", method = RequestMethod.GET)
    public String displayAllCours(Model model,@RequestParam(name="session", defaultValue="") String session ) {
        if(session.contentEquals("Hiver")){
            List<CoursProduit> coursList = coursProduitRepository.findProduitBySaison("HIVER");
            String pageTitle = "Hiver 2021";
            int coursCount = coursList.size();
            model.addAttribute("coursList", coursList);
            model.addAttribute("pageTitle", pageTitle);
            model.addAttribute("coursCount", coursCount);
            return "user/displayCours";
        }
        else if(session.contentEquals("Automne")){
            List<CoursProduit> coursList = coursProduitRepository.findProduitBySaison("AUTOMNE");
            String pageTitle = "Automne 2021";
            int coursCount = coursList.size();
            model.addAttribute("coursList", coursList);
            model.addAttribute("pageTitle", pageTitle);
            model.addAttribute("coursCount", coursCount);
            return "user/displayCours";
        }
        else if(session.contentEquals("Ete")){
            List<CoursProduit> coursList = coursProduitRepository.findProduitBySaison("ETE");
            String pageTitle = "Ete 2021";
            int coursCount = coursList.size();
            model.addAttribute("coursList", coursList);
            model.addAttribute("pageTitle", pageTitle);
            model.addAttribute("coursCount", coursCount);
            return "user/displayCours";
        }else {
            String pageTitle = "Choisir session";
            List<String> availableSaison = new ArrayList<String>();
            availableSaison.add("Hiver");
            availableSaison.add("Ete");
            availableSaison.add("Automne");
            int sessionCount = availableSaison.size();
            int year = 2021;
            model.addAttribute("pageTitle", pageTitle);
            model.addAttribute("Sessions", availableSaison );
            model.addAttribute("sessionCount", sessionCount);
            model.addAttribute("year", year);
            return "user/chooseSession";
        }
    }

    @RequestMapping(value="/checkout", method = RequestMethod.GET)
    public String inscrireCours(
            Model model,
            @RequestParam(name = "niveau", defaultValue = "")String n,
            @RequestParam(name = "prix", defaultValue = "") String p,
            @RequestParam(name = "description", defaultValue = "") String d,
            @RequestParam(name = "capacite", defaultValue = "")String c)
    {
        if(n.contentEquals("") || p.contentEquals("") || d.contentEquals("") || c.contentEquals("")){
            return "user/userAccount";
        }else{
            String niv =  n;
            String des = d ;
            double pri = Double.parseDouble(p);
            int cap = Integer.parseInt(c);
            model.addAttribute("niveau", niv);
            model.addAttribute("description", des);
            model.addAttribute("price", pri);
            model.addAttribute("capacite", cap);
            return "/user/checkoutInscription";
        }
    }

    @RequestMapping(value="/checkout/process", method = RequestMethod.POST)
    public RedirectView checkoutCours(
            @RequestParam(name = "niveau", defaultValue = "")String n,
            @RequestParam(name = "prix", defaultValue = "") String p,
            @RequestParam(name = "description", defaultValue = "") String d,
            @RequestParam(name = "capacite", defaultValue = "")String c,
            @RequestParam(name = "email", defaultValue = "")String e
            )
    {
        String description = d ;
        double price = Double.parseDouble(p);
        int capacite = Integer.parseInt(c);
        Niveau niveauValeur = Niveau.valueOf(n);
        User user = userRepository.findUserByUsername(e);
        Cours cours = new Cours(price,capacite,description,niveauValeur, user,Status.ACTIF);
        coursRepository.save(cours);
        RedirectView rd = new RedirectView("/user/account");
        return rd;
    }
}
