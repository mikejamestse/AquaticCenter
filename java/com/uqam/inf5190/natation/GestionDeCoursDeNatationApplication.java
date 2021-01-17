package com.uqam.inf5190.natation;

import com.uqam.inf5190.natation.dao.CoursProduitRepository;
import com.uqam.inf5190.natation.dao.CoursRepository;
import com.uqam.inf5190.natation.dao.SaisonRepository;
import com.uqam.inf5190.natation.dao.UserRepository;
import com.uqam.inf5190.natation.entities.Cours;
import com.uqam.inf5190.natation.entities.CoursProduit;
import com.uqam.inf5190.natation.entities.Session;
import com.uqam.inf5190.natation.entities.User;
import com.uqam.inf5190.natation.entities.enums.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@SpringBootApplication
public class GestionDeCoursDeNatationApplication {

	private static final Logger LOGGER = LogManager.getLogger(GestionDeCoursDeNatationApplication.class.getName());

	public static void main(String[] args) {


		ApplicationContext ctx = SpringApplication.run(GestionDeCoursDeNatationApplication.class, args);
		CoursRepository coursRepository = ctx.getBean(CoursRepository.class);
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		CoursProduitRepository coursProduitRepository = ctx.getBean(CoursProduitRepository.class);
		SaisonRepository saisonRepository = ctx.getBean(SaisonRepository.class);

		// Creation d'un utilisateur regulier
		User f = new User("Fouad", "Serradj","srdj.fouad@gmail.com", "438-992-6903", "123456", "5610", "Snowdon", "Montreal", "H3T1X7");
		// Creation d'un administrateur systeme
		User admin = new User("ADMIN", "SYSTEM","admin@inf5190.com", "438-992-6903", "fouad", "0007", "honduras", "Gatineau", "X1XX1X");
		admin.setRole(Role.ADMIN);
		userRepository.save(f);
		userRepository.save(admin);

		// Creation de session active
		saisonRepository.save(new Session(Saison.HIVER, 2021));
		saisonRepository.save(new Session(Saison.PRINTEMPS, 2021));
		saisonRepository.save(new Session(Saison.ETE, 2021));
		saisonRepository.save(new Session(Saison.AUTOMNE, 2021));

		// Creation de cours deja pris par un utilisateur
		coursRepository.save(new Cours(250.00, 12, "C'est un cours de debutant", Niveau.ETOILE_DE_MER, f,Status.FAIT ));
		coursRepository.save(new Cours(350.00, 12, "C'est un cours de natation classique",Niveau.BAMBINS, f,Status.FAIT ));
		coursRepository.save(new Cours(150.00, 12, "Il faut se porter sois même", Niveau.TORTUES, f,Status.FAIT ));
		coursRepository.save(new Cours(220.00, 12, "Travailler le jeux de jambe", Niveau.PINGOUINS, f,Status.FAIT ));
		coursRepository.save(new Cours(200.00, 12, "Travailler l'apnée", Niveau.SALAMANDRE, f,Status.ACTIF ));

		// Creation des cours produit qui sont disponible a etre pris pour la saison Hiver 2021
		coursProduitRepository.save(new CoursProduit(250.00, 4, "Cours de débutant, vous devez commencer par ici",14,17,2021, Saison.HIVER, Niveau.ETOILE_DE_MER , Days.JEUDI));
		coursProduitRepository.save(new CoursProduit(350.00, 6, "Cours de second niveau, on y apprend les mouvements intermédiaires ",15,18,2021, Saison.HIVER, Niveau.BAMBINS , Days.SAMEDI));
		coursProduitRepository.save(new CoursProduit(400.00, 10, "Cours de troisième niveau, on y apprend les mouvements avancés",10,14,2021, Saison.HIVER, Niveau.TORTUES , Days.VENDREDI));
		coursProduitRepository.save(new CoursProduit(550.00, 3, "Cours de quatrième niveau, on y apprend la dexteritée",13,17,2021, Saison.HIVER, Niveau.PINGOUINS , Days.LUNDI));
		coursProduitRepository.save(new CoursProduit(600.00, 12, "Cours de cinquième niveau, on y apprend le brassage",17,20,2021, Saison.HIVER, Niveau.SALAMANDRE , Days.MARDI));
		coursProduitRepository.save(new CoursProduit(500.00, 9, "Cours de sixième niveau, on y apprend la synchronisation",9,12,2021, Saison.HIVER, Niveau.BALEINES , Days.MERCREDI));
		coursProduitRepository.save(new CoursProduit(900.00, 2, "Cours de septième niveau, on y apprend les figures",14,18,2021, Saison.HIVER, Niveau.GRENOUILLES , Days.VENDREDI));
		coursProduitRepository.save(new CoursProduit(930.00, 1, "Cours de huitième niveau, on y apprend les mesures",17,20,2021, Saison.HIVER, Niveau.DAUPHINS , Days.SAMEDI));
		coursProduitRepository.save(new CoursProduit(1250.00, 4, "Cours de neuvième niveau, on y apprend les larges brasses et les longues distances",10,14,2021, Saison.HIVER, Niveau.JUNIOR_1 , Days.JEUDI));
		coursProduitRepository.save(new CoursProduit(1350.00, 2, "Cours de dernier niveau, il est cloturé par une compétition provinciale",14,18,2021, Saison.HIVER, Niveau.MAITRE_NAGEUR , Days.MARDI));

// Creation des cours produit qui sont disponible a etre pris pour la saison PRINTEMPS 2021
		coursProduitRepository.save(new CoursProduit(250.00, 4, "Cours de débutant, vous devez commencer par ici",14,17,2021, Saison.PRINTEMPS, Niveau.ETOILE_DE_MER , Days.JEUDI));
		coursProduitRepository.save(new CoursProduit(350.00, 6, "Cours de second niveau, on y apprend les mouvements intermédiaires ",15,18,2021, Saison.PRINTEMPS, Niveau.BAMBINS , Days.SAMEDI));
		coursProduitRepository.save(new CoursProduit(400.00, 10, "Cours de troisième niveau, on y apprend les mouvements avancés",10,14,2021, Saison.PRINTEMPS, Niveau.TORTUES , Days.VENDREDI));
		coursProduitRepository.save(new CoursProduit(550.00, 3, "Cours de quatrième niveau, on y apprend la dexteritée",13,17,2021, Saison.PRINTEMPS, Niveau.PINGOUINS , Days.LUNDI));
		coursProduitRepository.save(new CoursProduit(600.00, 12, "Cours de cinquième niveau, on y apprend le brassage",17,20,2021, Saison.PRINTEMPS, Niveau.SALAMANDRE , Days.MARDI));
		coursProduitRepository.save(new CoursProduit(500.00, 9, "Cours de sixième niveau, on y apprend la synchronisation",9,12,2021, Saison.PRINTEMPS, Niveau.BALEINES , Days.MERCREDI));
		coursProduitRepository.save(new CoursProduit(900.00, 2, "Cours de septième niveau, on y apprend les figures",14,18,2021, Saison.PRINTEMPS, Niveau.GRENOUILLES , Days.VENDREDI));
		coursProduitRepository.save(new CoursProduit(930.00, 1, "Cours de huitième niveau, on y apprend les mesures",17,20,2021, Saison.PRINTEMPS, Niveau.DAUPHINS , Days.SAMEDI));
		coursProduitRepository.save(new CoursProduit(1250.00, 4, "Cours de neuvième niveau, on y apprend les larges brasses et les longues distances",10,14,2021, Saison.PRINTEMPS, Niveau.JUNIOR_1 , Days.JEUDI));
		coursProduitRepository.save(new CoursProduit(1350.00, 2, "Cours de dernier niveau, il est cloturé par une compétition provinciale",14,18,2021, Saison.PRINTEMPS, Niveau.MAITRE_NAGEUR , Days.MARDI));

		// Creation des cours produit qui sont disponible a etre pris pour la saison ETE 2021
		coursProduitRepository.save(new CoursProduit(250.00, 12, "Cours de débutant, vous devez commencer par ici",14,17,2021, Saison.ETE, Niveau.ETOILE_DE_MER , Days.JEUDI));
		coursProduitRepository.save(new CoursProduit(350.00, 12, "Cours de second niveau, on y apprend les mouvements intermédiaires ",15,18,2021, Saison.ETE, Niveau.BAMBINS , Days.SAMEDI));
		coursProduitRepository.save(new CoursProduit(400.00, 12, "Cours de troisième niveau, on y apprend les mouvements avancés",10,14,2021, Saison.ETE, Niveau.TORTUES , Days.VENDREDI));
		coursProduitRepository.save(new CoursProduit(550.00, 12, "Cours de quatrième niveau, on y apprend la dexteritée",13,17,2021, Saison.ETE, Niveau.PINGOUINS , Days.LUNDI));
		coursProduitRepository.save(new CoursProduit(600.00, 14, "Cours de cinquième niveau, on y apprend le brassage",17,20,2021, Saison.ETE, Niveau.SALAMANDRE , Days.MARDI));
		coursProduitRepository.save(new CoursProduit(500.00, 12, "Cours de sixième niveau, on y apprend la synchronisation",9,12,2021, Saison.ETE, Niveau.BALEINES , Days.MERCREDI));
		coursProduitRepository.save(new CoursProduit(900.00, 4, "Cours de septième niveau, on y apprend les figures",14,18,2021, Saison.ETE, Niveau.GRENOUILLES , Days.VENDREDI));
		coursProduitRepository.save(new CoursProduit(930.00, 6, "Cours de huitième niveau, on y apprend les mesures",17,20,2021, Saison.ETE, Niveau.DAUPHINS , Days.SAMEDI));
		coursProduitRepository.save(new CoursProduit(1250.00, 11, "Cours de neuvième niveau, on y apprend les larges brasses et les longues distances",10,14,2021, Saison.ETE, Niveau.JUNIOR_1 , Days.JEUDI));
		coursProduitRepository.save(new CoursProduit(1350.00, 2, "Cours de dernier niveau, il est cloturé par une compétition provinciale",14,18,2021, Saison.ETE, Niveau.MAITRE_NAGEUR , Days.MARDI));

		// Creation des cours produit qui sont disponible a etre pris pour la saison AUTOMNE 2021
		coursProduitRepository.save(new CoursProduit(250.00, 12, "Cours de débutant, vous devez commencer par ici",14,17,2021, Saison.AUTOMNE, Niveau.ETOILE_DE_MER , Days.JEUDI));
		coursProduitRepository.save(new CoursProduit(350.00, 12, "Cours de second niveau, on y apprend les mouvements intermédiaires ",15,18,2021, Saison.AUTOMNE, Niveau.BAMBINS , Days.SAMEDI));
		coursProduitRepository.save(new CoursProduit(400.00, 12, "Cours de troisième niveau, on y apprend les mouvements avancés",10,14,2021, Saison.AUTOMNE, Niveau.TORTUES , Days.VENDREDI));
		coursProduitRepository.save(new CoursProduit(550.00, 12, "Cours de quatrième niveau, on y apprend la dexteritée",13,17,2021, Saison.AUTOMNE, Niveau.PINGOUINS , Days.LUNDI));
		coursProduitRepository.save(new CoursProduit(600.00, 14, "Cours de cinquième niveau, on y apprend le brassage",17,20,2021, Saison.AUTOMNE, Niveau.SALAMANDRE , Days.MARDI));
		coursProduitRepository.save(new CoursProduit(500.00, 12, "Cours de sixième niveau, on y apprend la synchronisation",9,12,2021, Saison.AUTOMNE, Niveau.BALEINES , Days.MERCREDI));
		coursProduitRepository.save(new CoursProduit(900.00, 12, "Cours de septieme niveau, on y apprend les figures",14,18,2021, Saison.AUTOMNE, Niveau.GRENOUILLES , Days.VENDREDI));
		coursProduitRepository.save(new CoursProduit(930.00, 12, "Cours de huitième niveau, on y apprend les mesures",17,20,2021, Saison.AUTOMNE, Niveau.DAUPHINS , Days.SAMEDI));
		coursProduitRepository.save(new CoursProduit(1250.00, 12, "Cours de neuvième niveau, on y apprend les larges brasses et les longues distances",10,14,2021, Saison.AUTOMNE, Niveau.JUNIOR_1 , Days.JEUDI));
		coursProduitRepository.save(new CoursProduit(1350.00, 12, "Cours de dernier niveau, il est cloturé par une compétition provinciale",14,18,2021, Saison.AUTOMNE, Niveau.MAITRE_NAGEUR , Days.MARDI));


		LOGGER.info("***********Log4j*****************");
		LOGGER.info("Log4j a fini ses logs de startup, il est a l'ecoute");

	}

}
