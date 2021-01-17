package com.uqam.inf5190.natation.web;

import com.uqam.inf5190.natation.dao.CoursProduitRepository;
import com.uqam.inf5190.natation.dao.SaisonRepository;
import com.uqam.inf5190.natation.entities.CoursProduit;
import com.uqam.inf5190.natation.entities.Session;
import com.uqam.inf5190.natation.entities.enums.Days;
import com.uqam.inf5190.natation.entities.enums.Niveau;
import com.uqam.inf5190.natation.entities.enums.Saison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

    @Autowired
    private SaisonRepository saisonRepository;

    @Autowired
    private CoursProduitRepository coursProduitRepository;


    @RequestMapping(value="/account", method = RequestMethod.GET)
    public String adminAccount(Model model){
        String pageTitle = "Admin. System";
        model.addAttribute("pageTitle", pageTitle);
        return "admin/adminAccount";
    }

    @RequestMapping(value="/session", method = RequestMethod.GET)
    public String displaySession(Model model){
        List<Session> sessionList = saisonRepository.findAll();
        String pageTitle = "Admin. Session";
        int sessionCount = sessionList.size();
        model.addAttribute("sessionList", sessionList);
        model.addAttribute("sessionCount", sessionCount);
        model.addAttribute("pageTitle", pageTitle);
        return "admin/displaySession";
    }

    @RequestMapping(value="/session/addSession", method = RequestMethod.GET)
    public String addSession(){
            return "admin/addSession";
        }

    @RequestMapping(value="/session/addSession/process", method = RequestMethod.GET)
    public RedirectView processAddSession( RedirectAttributes redirectAttributes,@RequestParam(name="saison", defaultValue="") String s,@RequestParam(name="year", defaultValue="") String y){
        Saison saisonValeur = Saison.valueOf(s);
        int yearValeur = Integer.parseInt(y);
        saisonRepository.save(new Session(saisonValeur,yearValeur));
        redirectAttributes.addFlashAttribute("SuccessMessage", "Felicitation, votre session a ete ajoute");
        RedirectView rd = new RedirectView("/admin/session");
        return rd;
    }
    
    @RequestMapping(value = "/cours", method = RequestMethod.GET)
    public String displayCours(RedirectAttributes redirection, Model model, @RequestParam(name="session", defaultValue="")String session, @RequestParam(name="year", defaultValue = "") String year){

        List<CoursProduit> coursList = coursProduitRepository.findAll();
        String pageTitle = "Cours";
        int coursCount = coursList.size();

        model.addAttribute("coursList", coursList);
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("coursCount", coursCount);
        return "admin/displayCours";
    }

    @RequestMapping(value="/cours/addCours", method = RequestMethod.GET)
    public String addCours(){
        return "admin/addCours";
    }

    @RequestMapping(value="/cours/addCours/process", method = RequestMethod.GET)
    public RedirectView processAddCours(
            RedirectAttributes redirectAttributes,
            @RequestParam(name="niveau", defaultValue="") String niveau,
            @RequestParam(name="startHour", defaultValue="") String startHour,
            @RequestParam(name="endHour", defaultValue="") String endHour,
            @RequestParam(name="daySchedule", defaultValue="") String daySchedule,
            @RequestParam(name="saison", defaultValue="") String saison,
            @RequestParam(name="annee", defaultValue="") String annee,
            @RequestParam(name="capacity", defaultValue="") String capacity,
            @RequestParam(name="price", defaultValue="") String price,
            @RequestParam(name="description", defaultValue="") String description
    ){
        Saison saisonValeur = Saison.valueOf(saison);
        Niveau niveauValeur = Niveau.valueOf(niveau);
        int startHourValeur = Integer.parseInt(startHour);
        int endtHourValeur = Integer.parseInt(endHour);
        int anneeValeur = Integer.parseInt(annee);
        int capacityValeur = Integer.parseInt(capacity);
        double priceValeur = Double.parseDouble(price);
        Days day = Days.valueOf(daySchedule);
        CoursProduit c = new CoursProduit(priceValeur,capacityValeur, description, startHourValeur, endtHourValeur, anneeValeur, saisonValeur, niveauValeur, day );
        coursProduitRepository.save(c);

        redirectAttributes.addFlashAttribute("SuccessMessage", "Felicitation, votre cours a ete ajoute");
        RedirectView rd = new RedirectView("/admin/cours/");
        return rd;
    }


}
