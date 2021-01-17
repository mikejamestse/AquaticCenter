package com.uqam.inf5190.natation.web;

import com.uqam.inf5190.natation.dao.UserRepository;
import com.uqam.inf5190.natation.entities.User;
import com.uqam.inf5190.natation.entities.enums.Role;
import com.uqam.inf5190.natation.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class homeController {

    // on utilise notre propre classe de service utilisateur
    @Autowired
    private MyUserDetailsService userService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value="/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error/404Error";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error/500Error";
            }
        }
        return "error/error";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginForm(Model model, @RequestParam(name="authenticated", defaultValue="") String authenticated){
        User user = new User();
        String errMessage = "";
        if (authenticated.contentEquals("false")){
            errMessage ="Mauvaise saisit de courriel ou mot de passe. Veuillez recommencer svp";
        }
        model.addAttribute("User", user);
        model.addAttribute("errMessage", errMessage );
        return "connexion";
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model){
        User user = new User();
        model.addAttribute("User", user);
        return "creer_compte";
    }

    @RequestMapping(value = "/signup/addUser", method = RequestMethod.POST)
    public RedirectView addUser(User user, RedirectAttributes redirection){
        User u = userRepository.findUserByUsername(user.getUsername());
        if(u == null){

            user.setRole(Role.USER);
            userService.save(user);
            RedirectView rd = new RedirectView("/login");
            redirection.addFlashAttribute("SuccessMessage", "Bravo, vous y etes presque ! Veuillez vous connecter pour finaliser votre inscription");
            return rd;
        }else {
            RedirectView rd = new RedirectView("/signup");
            redirection.addFlashAttribute("errMessage", "Desole, Ce courriel est deja utilise, veuillez choisir un autre");
            return rd;
        }
    }
}